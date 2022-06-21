package com.tsi.kirk.mcallister.microdemo.unit.business;

import com.tsi.kirk.mcallister.microdemo.business.Store;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StoreTest {

    Store testStore;

    @BeforeEach
    public void setUp() {
        testStore = new Store(250, 250);
    }

    @Test
    public void testGetSetStoreId() {
        int expected = 500;

        testStore.setStoreId(expected);
        int actual = testStore.getStoreId();

        Assertions.assertEquals(expected, actual, "Store ID is wrong");
    }

    @Test
    public void testGetSetManagerStaffId() {
        int expected = 500;

        testStore.setManagerStaffId(expected);
        int actual = testStore.getManagerStaffId();

        Assertions.assertEquals(expected, actual, "Staff ID is wrong");
    }

    @Test
    public void testGetSetAddressId() {
        int expected = 500;

        testStore.setAddressId(expected);
        int actual = testStore.getAddressId();

        Assertions.assertEquals(expected, actual, "Address ID is wrong");
    }
}
