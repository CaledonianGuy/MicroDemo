package com.tsi.kirk.mcallister.microdemo.inventory;

import jakarta.persistence.*;

import java.io.Serializable;

@Embeddable
public class FilmActorID implements Serializable {

    //Attributes -------------------------------------------------------------
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "actor_id", nullable = false)
    private int actorId;
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "film_id", nullable = false)
    private int filmId;
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
}
