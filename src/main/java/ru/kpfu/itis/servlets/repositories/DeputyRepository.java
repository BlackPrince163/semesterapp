package ru.kpfu.itis.servlets.repositories;

import ru.kpfu.itis.servlets.model.Deputy;

import java.util.List;

public interface DeputyRepository extends CrudRepository<Deputy>{
    List<Deputy> getFavouriteDeputyByUserId(Long userId);
}
