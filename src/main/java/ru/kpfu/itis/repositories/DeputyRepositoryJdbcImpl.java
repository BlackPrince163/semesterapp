package ru.kpfu.itis.repositories;

import ru.kpfu.itis.models.Deputy;
import ru.kpfu.itis.models.User;

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
    public User save(Deputy deputy) {
      return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public List<Deputy> getFavouriteDeputyByUserId(Long userId) {

        return null;
    }
}
