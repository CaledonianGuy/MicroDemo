package com.tsi.kirk.mcallister.microdemo.inventory;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmActorRepository extends CrudRepository<FilmActor, FilmActorID> {

//    Iterable<FilmActor> findByActorCatId_FilmId(int filmId);
//    Iterable<FilmActor> findByActorCatId_ActorId(int actorId);

    Iterable<FilmActor> findByFilmId(int filmId);
    Iterable<FilmActor> findByActorId(int actorId);
}
