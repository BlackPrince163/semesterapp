package ru.kpfu.itis.repositories;

import ru.kpfu.itis.models.Deputy;

import java.util.List;
import java.util.Optional;

public interface DeputyRepository extends CrudRepository<Deputy> {
    Optional<Deputy> findByName(String last_name);


}
