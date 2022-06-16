package com.tsi.kirk.mcallister.microdemo.inventory;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

@Entity
@Table(name = "film_actor")
public class FilmActor {

    //Attributes -------------------------------------------------------------
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int actorId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int filmId;
    // -----------------------------------------------------------------------

    //Constructors -----------------------------------------------------------
    public FilmActor() {}
    // -----------------------------------------------------------------------

    //Getters & Setters ------------------------------------------------------
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
