package ru.kpfu.itis.repositories;

import ru.kpfu.itis.models.Deputy;

import java.util.List;

public class DeputyRepositoryJdbcImpl implements DeputyRepository {
    @Override
    public List<Deputy> findAll() {
        return null;
    }

    @Override
    public Deputy findById(Long id) {
        return null;
    }

    @Override
    public void save(Deputy deputy) {

    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public List<Deputy> getFavouriteDeputyByUserId(Long userId) {

        return null;
    }
}