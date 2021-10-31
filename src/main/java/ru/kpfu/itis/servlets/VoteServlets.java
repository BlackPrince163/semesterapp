package ru.kpfu.itis.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.kpfu.itis.form.VoteForm;
import ru.kpfu.itis.models.Deputy;
import ru.kpfu.itis.services.DeputyService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/vote")
public class VoteServlets extends HttpServlet {
    private DeputyService deputyService;
    private ObjectMapper objectMapper;

    @Override
    public void init(ServletConfig config) throws ServletException {
        ServletContext context = config.getServletContext();
        deputyService = (DeputyService) context.getAttribute("deputyService");
        objectMapper = new ObjectMapper();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //req.getRequestDispatcher("/WEB-INF/views/vote.jsp").forward(req, resp);
        /*System.out.println(req.getSession().getAttribute("Email"));*/
        if (req.getSession().getAttribute("Email") == null) {
            /*req.getRequestDispatcher("/signIn").forward(req, resp);*/
            resp.sendRedirect("/signIn");
        } else {
            req.getRequestDispatcher("/WEB-INF/views/vote.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        VoteForm voteForm = objectMapper.readValue(req.getReader(), VoteForm.class);


        List<Deputy> voteDeputies;


        voteDeputies = deputyService.getVoteDeputy(voteForm);

        String voteAsJson = objectMapper.writeValueAsString(voteDeputies);
        resp.setContentType("application/json");
        resp.getWriter().println(voteAsJson);
    }


}
