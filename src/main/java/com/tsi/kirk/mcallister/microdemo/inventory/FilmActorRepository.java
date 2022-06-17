package com.tsi.kirk.mcallister.microdemo.inventory;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmActorRepository extends CrudRepository<FilmActor, FilmActorID> {

//    List<FilmActor> findByActorCatId_FilmId(int filmId);
//    List<FilmActor> findByActorCatId_ActorId(int actorId);

    List<FilmActor> findByFilmId(int filmId);
    List<FilmActor> findByActorId(int actorId);
}
