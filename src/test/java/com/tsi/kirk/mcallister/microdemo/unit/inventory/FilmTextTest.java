package com.tsi.kirk.mcallister.microdemo.unit.inventory;

import com.tsi.kirk.mcallister.microdemo.inventory.FilmText;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FilmTextTest {

    FilmText testFilmText;

    @BeforeEach
    public void setUp() {
        testFilmText = new FilmText("Cool Title");
    }

    @Test
    public void testGetSetFilmId() {
        int expected = 500;

        testFilmText.setFilmId(expected);
        int actual = testFilmText.getFilmId();

        Assertions.assertEquals(expected, actual, "Film ID is wrong");
    }

    @Test
    public void testGetSetTitle() {
        String expected = "Cool Title 2";

        testFilmText.setTitle(expected);
        String actual = testFilmText.getTitle();

        Assertions.assertEquals(expected, actual, "Title is wrong");
    }

    @Test
    public void testGetSetDescription() {
        String expected = "Cool description";

        testFilmText.setDescription(expected);
        String actual = testFilmText.getDescription();

        Assertions.assertEquals(expected, actual, "Description is wrong");
    }
}
