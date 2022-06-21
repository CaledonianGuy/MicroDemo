package com.tsi.kirk.mcallister.microdemo.unit.inventory;

import com.tsi.kirk.mcallister.microdemo.inventory.FilmActor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FilmActorTest {

    FilmActor testFilmActor;

    @BeforeEach
    public void setUp() {
        testFilmActor = new FilmActor();
    }

    @Test
    public void testGetSetActorId() {
        int expected = 500;

        testFilmActor.setActorId(expected);
        int actual = testFilmActor.getActorId();

        Assertions.assertEquals(expected, actual, "Actor ID is wrong");
    }

    @Test
    public void testGetSetFilmId() {
        int expected = 500;

        testFilmActor.setFilmId(expected);
        int actual = testFilmActor.getFilmId();

        Assertions.assertEquals(expected, actual, "Film ID is wrong");
    }
}
