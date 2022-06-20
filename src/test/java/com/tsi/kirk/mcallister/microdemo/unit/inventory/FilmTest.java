package com.tsi.kirk.mcallister.microdemo.unit.inventory;

import com.tsi.kirk.mcallister.microdemo.inventory.Film;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.sql.Date;

public class FilmTest {

    Film testFilm;

    @BeforeEach
    public void setUp() {
        testFilm = new Film("Best Movie", 1, 14,
                new BigDecimal("3.25"), new BigDecimal("3.25"));
    }

    @Test
    public void testGetSetFilmId() {
        int expected = 500;

        testFilm.setFilmId(expected);
        int testId = testFilm.getFilmId();

        Assertions.assertEquals(expected, testId, "Test ID is wrong");
    }

    @Test
    void testGetSetTitle() {
        String expected = "Best Movie 5";

        testFilm.setTitle(expected);
        String actual = testFilm.getTitle();

        Assertions.assertEquals(expected, actual, "Title is wrong");
    }

    @Test
    void testGetSetDescription() {
        String expected = "Cool description";

        testFilm.setDescription(expected);
        String actual = testFilm.getDescription();

        Assertions.assertEquals(expected, actual, "Description is wrong");
    }

    @Test
    void testGetSetReleaseYear() {
        Date expected = new Date(System.currentTimeMillis());

        testFilm.setReleaseYear(expected);
        Date actual = testFilm.getReleaseYear();

        Assertions.assertEquals(expected, actual, "Release Year is wrong");
    }

    @Test
    void testGetSetLanguageId() {
        int expected = 500;

        testFilm.setLanguageId(expected);
        int actual = testFilm.getLanguageId();

        Assertions.assertEquals(expected, actual, "Language ID is wrong");
    }

    @Test
    void testGetSetOriginalLanguageId() {
        //TODO issues with Original Language ID being NULL.

        /*
        Integer expected = 500;

        testFilm.setFilmId(expected);
        Integer actual = testFilm.getOriginalLanguageId();

        Assertions.assertEquals(expected, actual, "Original Language ID is wrong");

         */
    }

    @Test
    void testGetSetRentalDuration() {
        int expected = 500;

        testFilm.setRentalDuration(expected);
        int actual = testFilm.getRentalDuration();

        Assertions.assertEquals(expected, actual, "Rental Duration is wrong");
    }

    @Test
    void testGetSetRentalRate() {
        BigDecimal expected = new BigDecimal(500);

        testFilm.setRentalRate(expected);
        BigDecimal actual = testFilm.getRentalRate();

        Assertions.assertEquals(expected, actual, "Rental Rate is wrong");
    }

    @Test
    void testGetSetLength() {
        int expected = 500;

        testFilm.setLength(expected);
        int actual = testFilm.getLength();

        Assertions.assertEquals(expected, actual, "Length is wrong");
    }

    @Test
    void testGetSetReplacementCost() {
        BigDecimal expected = new BigDecimal(500);

        testFilm.setReplacementCost(expected);
        BigDecimal actual = testFilm.getReplacementCost();

        Assertions.assertEquals(expected, actual, "Replacement Cost is wrong");
    }

    @Test
    void testGetSetRating() {
        //TODO issues with Rating being NULL.

        /*
        String expected = "R";

        testFilm.setRating(expected);
        String actual = testFilm.getSpecialFeatures();

        Assertions.assertEquals(expected, actual, "Rating is wrong");

         */
    }

    @Test
    void testGetSetSpecialFeatures() {
        String expected = "Interviews";

        testFilm.setSpecialFeatures(expected);
        String actual = testFilm.getSpecialFeatures();

        Assertions.assertEquals(expected, actual, "Special Features is wrong");
    }
}
