package com.tsi.kirk.mcallister.microdemo.inventory;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

@Entity
@Table(name = "film_text")
public class FilmText {

    //Attributes -------------------------------------------------------------
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "film_id", nullable = false)
    private int filmId;
    @Column(name = "title", nullable = false)
    private String title;
    @Column(name = "description")
    private String description;
    // -----------------------------------------------------------------------

    //Constructors -----------------------------------------------------------
    public FilmText() {}

    public FilmText(String title) {
        this.title = title;
    }
    // -----------------------------------------------------------------------

    //Getters & Setters ------------------------------------------------------=
    public int getFilmId() {
        return filmId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    // -----------------------------------------------------------------------

    //Methods ----------------------------------------------------------------

    // -----------------------------------------------------------------------
}
