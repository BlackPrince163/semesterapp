package ru.kpfu.itis.servlets.repositories;

import java.util.List;

public interface    CrudRepository<T> {
    List<T> findAll();
    T findById(Long id);
    void save(T t);
    void deleteById(Long id);
}
