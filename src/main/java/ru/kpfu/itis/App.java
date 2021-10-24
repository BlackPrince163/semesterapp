package ru.kpfu.itis;

import java.sql.*;

public class App {
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

            ResultSet resultSet = statement.executeQuery("select first_name, email from users");

            while (resultSet.next()) {
                System.out.println(resultSet.getString("first_name"));
                System.out.print(resultSet.getString("email"));
                System.out.println("\n");
            }
        } catch (SQLException e) {
            //ignore
        }
    }
}
