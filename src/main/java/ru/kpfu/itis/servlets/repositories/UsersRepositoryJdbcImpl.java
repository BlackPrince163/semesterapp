package ru.kpfu.itis.servlets.repositories;

import ru.kpfu.itis.servlets.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UsersRepositoryJdbcImpl implements UsersRepository {


    private Statement statement;
    public UsersRepositoryJdbcImpl(Statement statement) {
        this.statement = statement;
    }

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        try {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users");
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong("id"));
                user.setFirstName(resultSet.getString("first_name"));
                user.setLastName(resultSet.getString("last_name"));
                user.setEmail(resultSet.getString("email"));

                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public User findById(Long id) {
        try {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users WHERE users.id=" + id);
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong("id"));
                user.setFirstName(resultSet.getString("first_name"));
                user.setLastName(resultSet.getString("last_name"));
                user.setEmail(resultSet.getString("email"));

                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public void save(User user) {
        //langeage
        String sql_insert_user = "insert into users (first_name, last_name, email) " +
                "values ('"+ user.getFirstName()  +"', '"+ user.getLastName() +"', '"+ user.getEmail() +"')";
        try {
            statement.execute(sql_insert_user);
        } catch (SQLException e) {
            //ignore
        }
    }

    @Override
    public void deleteById(Long id) {

    }


}
