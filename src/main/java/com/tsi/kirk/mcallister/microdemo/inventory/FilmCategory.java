package com.tsi.kirk.mcallister.microdemo.inventory;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

@Entity
@Table(name = "film_category")
public class FilmCategory {

    //Attributes -------------------------------------------------------------
//    @EmbeddedId
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private FilmCategoryID filmCatId;

    @Id
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", referencedColumnName = "category_id", nullable = false)
    private int filmID;

//    @Id
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "film_id", referencedColumnName = "film_id", nullable = false)
    private int categoryId;
    // -----------------------------------------------------------------------

//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //Constructors -----------------------------------------------------------
    public FilmCategory() {}
    // -----------------------------------------------------------------------

    //Getters & Setters ------------------------------------------------------
//    public FilmCategoryID getFilmCatId() {
//        return filmCatId;
//    }

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
