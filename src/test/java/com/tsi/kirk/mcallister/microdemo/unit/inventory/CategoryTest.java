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
    public void testGetCategoryId() {
        int testId = testCategory.getCategoryId();

        Assertions.assertNotNull(testId, "Test ID is NULL");
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
