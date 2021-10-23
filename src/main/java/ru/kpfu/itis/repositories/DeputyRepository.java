package ru.kpfu.itis.repositories;

import ru.kpfu.itis.models.Deputy;

import java.util.List;

public interface DeputyRepository extends CrudRepository<Deputy>{
    List<Deputy> getFavouriteDeputyByUserId(Long userId);
}
