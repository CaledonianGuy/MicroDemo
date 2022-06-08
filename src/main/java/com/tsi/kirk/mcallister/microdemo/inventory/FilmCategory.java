package com.tsi.kirk.mcallister.microdemo.inventory;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import org.springframework.data.annotation.Id;

@Entity
@Table(name = "film_category")
public class FilmCategory {

    //Attributes -------------------------------------------------------------
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int filmID;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int categoryId;
    // -----------------------------------------------------------------------

    //Constructors -----------------------------------------------------------
    public FilmCategory() {}
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

    //Methods ----------------------------------------------------------------

    // -----------------------------------------------------------------------
}
