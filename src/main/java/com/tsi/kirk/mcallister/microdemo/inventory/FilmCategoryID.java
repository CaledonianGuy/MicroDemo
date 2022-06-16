package com.tsi.kirk.mcallister.microdemo.inventory;

import jakarta.persistence.*;

import java.io.Serializable;

@Embeddable
public class FilmCategoryID implements Serializable {

    //Attributes -------------------------------------------------------------
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", referencedColumnName = "category_id", nullable = false)
    private int filmID;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "film_id", referencedColumnName = "film_id", nullable = false)
    private int categoryId;
    // -----------------------------------------------------------------------

    //Getters & Setters ------------------------------------------------------
    public int getFilmID() {
        return filmID;
    }

    public void setFilmID(int filmID) {
        this.filmID = filmID;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
    // -----------------------------------------------------------------------
}
