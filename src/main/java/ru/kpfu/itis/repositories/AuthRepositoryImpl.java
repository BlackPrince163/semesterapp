package ru.kpfu.itis.repositories;

import ru.kpfu.itis.models.Auth;
import ru.kpfu.itis.models.User;

import java.io.PrintWriter;
import java.sql.Connection;
import java.util.List;

public class AuthRepositoryImpl implements AuthRepository {

    private Connection connection;


    public AuthRepositoryImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Auth findByCookieValue(String cookieValue) {
        return null;
    }

    @Override
    public List<Auth> findAll() {
        return null;
    }

    @Override
    public Auth findById(Long id) {
        return null;
    }

    @Override
    public User save(Auth auth) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
