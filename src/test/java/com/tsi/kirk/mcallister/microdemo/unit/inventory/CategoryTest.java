package com.tsi.kirk.mcallister.microdemo.unit.inventory;

import com.tsi.kirk.mcallister.microdemo.inventory.Category;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CategoryTest {

    Category testCategory;

    @BeforeEach
    public void setUp() {
        testCategory = new Category("Action");
    }

    @Test
    public void testGetSetCategoryId() {
        int expected = 500;

        testCategory.setCategoryId(expected);
        int testId = testCategory.getCategoryId();

        Assertions.assertEquals(expected, testId, "Test ID is wrong");
    }

    @Test
    public void testGetSetName() {
        String expectedOne = "Action";
        String actualOne = testCategory.getName();

        Assertions.assertEquals(expectedOne, actualOne, "Expected and Actual Names DO NOT match");


        testCategory.setName("Horror");

        String expectedTwo = "Horror";
        String actualTwo = testCategory.getName();

        Assertions.assertEquals(expectedTwo, actualTwo, "Name not changed correctly");
    }
}
