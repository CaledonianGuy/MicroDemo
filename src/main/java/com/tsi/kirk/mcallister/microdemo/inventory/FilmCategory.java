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
    @GeneratedValue(strategy = GenerationType.AUTO)
    int filmID;
    @GeneratedValue(strategy = GenerationType.AUTO)
    int categoryId;
    // -----------------------------------------------------------------------

    //Constructors -----------------------------------------------------------
    public FilmCategory() {}
    // -----------------------------------------------------------------------

    //Getters & Setters ------------------------------------------------------
    public int getFilmID() {
        return filmID;
    }

    public int getCategoryId() {
        return categoryId;
    }
    // -----------------------------------------------------------------------

    //Methods ----------------------------------------------------------------

    // -----------------------------------------------------------------------
}
