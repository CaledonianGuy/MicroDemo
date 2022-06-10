package com.tsi.kirk.mcallister.microdemo.inventory;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import org.springframework.data.annotation.Id;

@Entity
@Table(name = "film_actor")
public class FilmActor {

    //Attributes -------------------------------------------------------------
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int actorId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int filmId;
    // -----------------------------------------------------------------------

    //Constructors -----------------------------------------------------------
    public FilmActor() {}
    // -----------------------------------------------------------------------

    //Getters & Setters ------------------------------------------------------
    public int getActorId() {
        return actorId;
    }

    public int getFilmId() {
        return filmId;
    }
    // -----------------------------------------------------------------------

    //Methods ----------------------------------------------------------------

    // -----------------------------------------------------------------------
}
