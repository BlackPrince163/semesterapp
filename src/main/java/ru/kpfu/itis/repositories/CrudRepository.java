package ru.kpfu.itis.repositories;

import ru.kpfu.itis.models.User;

import java.util.List;

public interface CrudRepository<T> {
    List<T> findAll();
    T findById(Long id);
    User save(T t);
    void deleteById(Long id);
}
