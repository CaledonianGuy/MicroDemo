package com.tsi.kirk.mcallister.microdemo.unit.inventory;

import com.tsi.kirk.mcallister.microdemo.inventory.Language;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LanguageTest {

    Language testLang;

    @BeforeEach
    public void setUp() {
        testLang = new Language("New Language");
    }

    @Test
    public void testGetSetLanguageId() {
        int expected = 500;

        testLang.setLanguageId(expected);
        int actual = testLang.getLanguageId();

        Assertions.assertEquals(expected, actual, "Language ID is wrong");
    }

    @Test
    public void testGetSetLangName() {
        String expected = "Old Language";

        testLang.setLangName(expected);
        String actual = testLang.getLangName();

        Assertions.assertEquals(expected, actual, "Language Name is wrong");
    }
}
