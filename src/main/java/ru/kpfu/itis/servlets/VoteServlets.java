package ru.kpfu.itis.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.kpfu.itis.form.VoteForm;
import ru.kpfu.itis.models.Deputy;
import ru.kpfu.itis.models.User;
import ru.kpfu.itis.services.DeputyService;
import ru.kpfu.itis.services.UsersService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebServlet("/vote")
public class VoteServlets extends HttpServlet {
    private DeputyService deputyService;
    private ObjectMapper objectMapper;
    private UsersService usersService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        ServletContext context = config.getServletContext();
        deputyService = (DeputyService) context.getAttribute("deputyService");
        usersService = (UsersService) context.getAttribute("usersService");
        objectMapper = new ObjectMapper();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        String email = (String) session.getAttribute("Email");
        Optional<User> userByEmailOptional = usersService.findOneByEmail(email);

        if (userByEmailOptional.isPresent()) {
            User user = userByEmailOptional.get();
            req.setAttribute("FirstName", user.getFirstName());

        }
        String eLogOut = "<li><a href=\"/logout\">Выйти</a></li>";
        req.setAttribute("emailLogOut", eLogOut);

        List<Deputy> voteDeputies;
        voteDeputies = deputyService.getAllDeputy();
        req.setAttribute("ListDeputies", voteDeputies);

        if (req.getSession().getAttribute("Email") == null) {
            resp.sendRedirect("/signIn");
        } else {
            req.getRequestDispatcher("/WEB-INF/views/vote.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        VoteForm voteForm = objectMapper.readValue(req.getReader(), VoteForm.class);
        String choice= req.getParameter("adults-number");
        System.out.println(choice);

        List<Deputy> voteDeputies;


        voteDeputies = deputyService.getVoteDeputy(voteForm);

        String voteAsJson = objectMapper.writeValueAsString(voteDeputies);
        resp.setContentType("application/json");
        resp.getWriter().println(voteAsJson);
    }


}
