package com.tsi.kirk.mcallister.microdemo.unit.inventory;

import com.tsi.kirk.mcallister.microdemo.inventory.Film;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class FilmTest {

    Film testFilm;

    @BeforeEach
    public void setUp() {
        testFilm = new Film("Best Movie", 1, 14,
                new BigDecimal("3.25"), new BigDecimal("3.25"));
    }

    @Test
    public void testGetFilmId() {

    }
}
