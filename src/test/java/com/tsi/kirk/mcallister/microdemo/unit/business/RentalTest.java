package com.tsi.kirk.mcallister.microdemo.unit.business;

import com.tsi.kirk.mcallister.microdemo.business.Rental;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class RentalTest {

    Rental testRental;

    @BeforeEach
    public void setUp() {
        testRental = new Rental(LocalDateTime.now(), 250, 250, 250);
    }

    @Test
    public void testGetSetRentalId() {
        int expected = 500;

        testRental.setRentalId(expected);
        int actual = testRental.getRentalId();

        Assertions.assertEquals(expected, actual, "Rental ID is wrong");
    }

    @Test
    public void testGetSetRentalDate() {
        LocalDateTime expected = LocalDateTime.now();

        testRental.setRentalDate(expected);
        LocalDateTime actual = testRental.getRentalDate();

        Assertions.assertEquals(expected, actual, "Rental Date is wrong");
    }

    @Test
    public void testGetSetInventoryId() {
        int expected = 500;

        testRental.setInventoryId(expected);
        int actual = testRental.getInventoryId();

        Assertions.assertEquals(expected, actual, "Inventory ID is wrong");
    }

    @Test
    public void testGetSetCustomerId() {
        int expected = 500;

        testRental.setCustomerId(expected);
        int actual = testRental.getCustomerId();

        Assertions.assertEquals(expected, actual, "Customer ID is wrong");
    }

    @Test
    public void testGetSetReturnDate() {
        LocalDateTime expected = LocalDateTime.now();

        testRental.setReturnDate(expected);
        LocalDateTime actual = testRental.getReturnDate();

        Assertions.assertEquals(expected, actual, "Return Date is wrong");
    }

    @Test
    public void testGetSetStaffId() {
        int expected = 500;

        testRental.setStaffId(expected);
        int actual = testRental.getStaffId();

        Assertions.assertEquals(expected, actual, "Staff ID is wrong");
    }
}
