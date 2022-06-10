package com.tsi.kirk.mcallister.microdemo.inventory;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Table(name = "film")
public class Film {

    //Attributes -------------------------------------------------------------
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int filmId;
    String title;
    String description;
    Date releaseYear;
    int languageId;
    Integer originalLanguageId;
    int rentalDuration;
    BigDecimal rentalRate;
    int length;
    BigDecimal replacementCost;
    String rating;
    String specialFeatures;
    // -----------------------------------------------------------------------

    //Constructors -----------------------------------------------------------
    public Film() {}

    public Film(String title, int languageId, int rentalDuration, BigDecimal rentalRate, BigDecimal replacementCost) {
        this.title = title;
        this.languageId = languageId;
        this.rentalDuration = rentalDuration;
        this.rentalRate = rentalRate;
        this.replacementCost = replacementCost;
    }
    // -----------------------------------------------------------------------

    //Getters & Setters ------------------------------------------------------
    public int getFilmId() {
        return filmId;
    }

    /*
    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }
     */

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

    public Date getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Date releaseYear) {
        this.releaseYear = releaseYear;
    }

    public int getLanguageId() {
        return languageId;
    }

    public void setLanguageId(int languageId) {
        this.languageId = languageId;
    }

    public Integer getOriginalLanguageId() {
        return originalLanguageId;
    }

    public void setOriginalLanguageId(Integer originalLanguageId) {
        this.originalLanguageId = originalLanguageId;
    }

    public int getRentalDuration() {
        return rentalDuration;
    }

    public void setRentalDuration(int rentalDuration) {
        this.rentalDuration = rentalDuration;
    }

    public BigDecimal getRentalRate() {
        return rentalRate;
    }

    public void setRentalRate(BigDecimal rentalRate) {
        this.rentalRate = rentalRate;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public BigDecimal getReplacementCost() {
        return replacementCost;
    }

    public void setReplacementCost(BigDecimal replacementCost) {
        this.replacementCost = replacementCost;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getSpecialFeatures() {
        return specialFeatures;
    }

    public void setSpecialFeatures(String specialFeatures) {
        this.specialFeatures = specialFeatures;
    }
    // -----------------------------------------------------------------------

    //Methods ----------------------------------------------------------------

    // -----------------------------------------------------------------------
}
