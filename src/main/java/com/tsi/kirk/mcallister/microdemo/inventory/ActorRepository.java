package com.tsi.kirk.mcallister.microdemo.inventory;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ActorRepository extends CrudRepository<Actor, Integer> {

    Optional<Actor> findByFirstNameAndLastName(String firstName, String lastName);
}
