package ru.kpfu.itis.servlets;

import ru.kpfu.itis.form.UserForm;
import ru.kpfu.itis.repositories.UsersRepository;
import ru.kpfu.itis.repositories.UsersRepositoryJdbcImpl;
import ru.kpfu.itis.services.UsersService;
import ru.kpfu.itis.services.UsersServicesImpl;

import javax.servlet.ServletException;
import javax.servlet.UnavailableException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebServlet("/signUp")
public class RegistrationServlet extends HttpServlet {

    //private Connection connection;

    private UsersService usersService;

    private final String DB_URL = "jdbc:postgresql://localhost:5432/sem01";
    private final String DB_USERNAME = "sem01";
    private final String DB_PASSWORD = "sem01";

    @Override
    public void init() throws ServletException {
        try {
            //Подгружаем драйвер, оно автоматически регистрирует JDBC
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

            UsersRepository usersRepository = new UsersRepositoryJdbcImpl(connection);
            usersService = new UsersServicesImpl(usersRepository);
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Unavailable");
            throw new UnavailableException("Сайт недоступен!!!");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("jsp/registration.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        UserForm userForm = new UserForm();
        userForm.setFirstName(request.getParameter("first_name"));
        userForm.setLastName(request.getParameter("last_name"));
        userForm.setLogin(request.getParameter("login"));
        userForm.setPassword(request.getParameter("password"));

        usersService.register(userForm);

        request.getRequestDispatcher("jsp/registration.jsp").forward(request, response);

    }

}
