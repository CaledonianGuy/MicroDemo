package com.tsi.kirk.mcallister.microdemo.inventory;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmActorRepository extends CrudRepository<FilmActor, Integer> {
    Iterable<FilmActor> findByFilmId(int filmId);
    Iterable<FilmActor> findByActorId(int actorId);
}
