package com.tsi.kirk.mcallister.microdemo.unit.inventory;

import com.tsi.kirk.mcallister.microdemo.inventory.Inventory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InventoryTest {

    Inventory testInventory;

    @BeforeEach
    public void setUp() {
        testInventory = new Inventory(250, 250);
    }

    @Test
    public void testGetSetInventoryId() {
        int expected = 500;

        testInventory.setInventoryId(expected);
        int actual = testInventory.getInventoryId();

        Assertions.assertEquals(expected, actual, "Inventory ID is wrong");
    }

    @Test
    public void testGetSetFilmId() {
        int expected = 500;

        testInventory.setFilmId(expected);
        int actual = testInventory.getFilmId();

        Assertions.assertEquals(expected, actual, "Film ID is wrong");
    }

    @Test
    public void testGetSetStoreId() {
        int expected = 500;

        testInventory.setStoreId(expected);
        int actual = testInventory.getStoreId();

        Assertions.assertEquals(expected, actual, "Store ID is wrong");
    }
}
