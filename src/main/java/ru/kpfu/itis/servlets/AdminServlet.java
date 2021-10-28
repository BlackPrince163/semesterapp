package ru.kpfu.itis.servlets;

import ru.kpfu.itis.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/users")
public class AdminServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> users = new ArrayList<>();
        User user1 = new User();
        user1.setFirstName("Niyaz");
        user1.setLastName("Khadimullin");
        user1.setId(1L);

        User user2 = new User();
        user2.setFirstName("Alsu");
        user2.setLastName("Khadimullina");
        user2.setId(2L);

        users.add(user1);
        users.add(user2);

        request.setAttribute("users", users);
        request.getRequestDispatcher("jsp/userList.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

}
