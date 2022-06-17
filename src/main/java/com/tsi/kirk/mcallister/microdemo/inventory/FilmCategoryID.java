package com.tsi.kirk.mcallister.microdemo.inventory;

import jakarta.persistence.*;

import java.io.Serializable;

@Embeddable
public class FilmCategoryID implements Serializable {

    //Attributes -------------------------------------------------------------
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "film_id", referencedColumnName = "film_id", nullable = false)
    private int filmId;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", referencedColumnName = "category_id", nullable = false)
    private int categoryId;
    // -----------------------------------------------------------------------

    //Getters & Setters ------------------------------------------------------
    public int getFilmID() {
        return filmId;
    }

    public void setFilmID(int filmID) {
        this.filmId = filmID;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
    // -----------------------------------------------------------------------
}
