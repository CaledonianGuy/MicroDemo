package com.tsi.kirk.mcallister.microdemo.inventory;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

@Entity
@Table(name = "film_category")
public class FilmCategory {

    //Attributes -------------------------------------------------------------
    @Id
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "film_id", referencedColumnName = "film_id", nullable = false)
    private int filmId;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", referencedColumnName = "category_id", nullable = false)
    private Integer categoryId;
    // -----------------------------------------------------------------------

    //Constructors -----------------------------------------------------------
    public FilmCategory() {}
    // -----------------------------------------------------------------------

    //Getters & Setters ------------------------------------------------------
    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }
    // -----------------------------------------------------------------------

    //Methods ----------------------------------------------------------------

    // -----------------------------------------------------------------------
}
