package ru.kpfu.itis;

import ru.kpfu.itis.models.User;
import ru.kpfu.itis.servlets.repositories.UsersRepository;
import ru.kpfu.itis.servlets.repositories.UsersRepositoryJdbcImpl;

import java.sql.*;
import java.util.Scanner;

public class App2 {
    public static void main(String[] args) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            //ignore
        }
        Connection connection = null;
        Statement statement = null;

        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/sem01", "sem01", "sem01");
            statement = connection.createStatement();

            UsersRepository usersRepository = new UsersRepositoryJdbcImpl(statement);

           // System.out.println(usersRepository.findAll());


            //System.out.println(usersRepository.findById(3L));
            Scanner scanner = new Scanner(System.in);
            User user = new User();
            user.setFirstName(scanner.next());
            user.setLastName(scanner.next());
            user.setEmail(scanner.next());

            usersRepository.save(user);

            } catch (SQLException throwables) {
            //ignore
        }
    }
}
