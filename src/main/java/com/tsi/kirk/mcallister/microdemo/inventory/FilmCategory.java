package com.tsi.kirk.mcallister.microdemo.inventory;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

@Entity
@Table(name = "film_category")
public class FilmCategory {

    //Attributes -------------------------------------------------------------
    @EmbeddedId
    private FilmCategoryID filmCatId;

    @Id
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "film_id", referencedColumnName = "film_id", nullable = false)
    private int filmId;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", referencedColumnName = "category_id", nullable = false)
    private int categoryId;
    // -----------------------------------------------------------------------

    //Constructors -----------------------------------------------------------
    public FilmCategory() {}
    // -----------------------------------------------------------------------
    public FilmCategoryID getFilmCatId() {
        return filmCatId;
    }

    public void setFilmCatId(FilmCategoryID filmCatId) {
        this.filmCatId = filmCatId;
    }

    //Getters & Setters ------------------------------------------------------
    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
    // -----------------------------------------------------------------------

    //Methods ----------------------------------------------------------------

    // -----------------------------------------------------------------------
}
