package com.tsi.kirk.mcallister.microdemo.inventory;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

@Entity
@Table(name = "film_actor")
public class FilmActor {

    //Attributes -------------------------------------------------------------
//    @EmbeddedId
//    private FilmActorID filmActorID;

    @Id
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "actor_id", referencedColumnName = "actor_id", nullable = false)
    private int actorId;
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "film_id", referencedColumnName = "film_id", nullable = false)
    private int filmId;
    // -----------------------------------------------------------------------

    //Constructors -----------------------------------------------------------
    public FilmActor() {}
    // -----------------------------------------------------------------------

    //Getters & Setters ------------------------------------------------------
//    public FilmActorID getFilmActorID() {
//        return filmActorID;
//    }
//
//    public void setFilmActorID(FilmActorID filmActorID) {
//        this.filmActorID = filmActorID;
//    }

    public int getActorId() {
        return actorId;
    }

    public void setActorId(int actorId) {
        this.actorId = actorId;
    }

    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }
    // -----------------------------------------------------------------------

    //Methods ----------------------------------------------------------------

    // -----------------------------------------------------------------------
}
