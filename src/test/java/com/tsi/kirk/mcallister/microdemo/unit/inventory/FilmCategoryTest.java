package com.tsi.kirk.mcallister.microdemo.unit.inventory;

import com.tsi.kirk.mcallister.microdemo.inventory.FilmCategory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FilmCategoryTest {

    FilmCategory testFilmCat;

    @BeforeEach
    public void setUp() {
        testFilmCat = new FilmCategory();
    }

    @Test
    public void testGetSetFilmId() {
        int expected = 500;

        testFilmCat.setFilmId(expected);
        int actual = testFilmCat.getFilmId();

        Assertions.assertEquals(expected, actual, "Film ID is wrong");
    }

    @Test
    public void testGetSetCategoryId() {
        int expected = 500;

        testFilmCat.setCategoryId(expected);
        int actual = testFilmCat.getCategoryId();

        Assertions.assertEquals(expected, actual, "Category ID is wrong");
    }
}
