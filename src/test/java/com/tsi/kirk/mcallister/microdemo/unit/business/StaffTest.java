package com.tsi.kirk.mcallister.microdemo.unit.business;

import com.tsi.kirk.mcallister.microdemo.business.Staff;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StaffTest {

    Staff testStaff;

    @BeforeEach
    public void setUp() {
        testStaff = new Staff(
                "First Name",
                "Last Name",
                250,
                250,
                true,
                "username"
        );
    }

    @Test
    public void testGetSetStaffId() {
        int expected = 500;

        testStaff.setStaffId(expected);
        int actual = testStaff.getStaffId();

        Assertions.assertEquals(expected, actual, "Staff ID is wrong");
    }

    @Test
    public void testGetSetFirstName() {
        String expected = "New First Name";

        testStaff.setFirstName(expected);
        String actual = testStaff.getFirstName();

        Assertions.assertEquals(expected, actual, "First Name is wrong");
    }

    @Test
    public void testGetSetLastName() {
        String expected = "New Last Name";

        testStaff.setLastName(expected);
        String actual = testStaff.getLastName();

        Assertions.assertEquals(expected, actual, "Last Name is wrong");
    }

    @Test
    public void testGetSetAddressId() {
        int expected = 500;

        testStaff.setAddressId(expected);
        int actual = testStaff.getAddressId();

        Assertions.assertEquals(expected, actual, "Address ID is wrong");
    }

    @Test
    public void testGetSetPicture() {
        byte[] expected = new byte[10];

        testStaff.setPicture(expected);
        byte[] actual = testStaff.getPicture();

        Assertions.assertEquals(expected, actual, "Picture is wrong");
    }

    @Test
    public void testGetSetEmail() {
        String expected = "a@b.c";

        testStaff.setEmail(expected);
        String actual = testStaff.getEmail();

        Assertions.assertEquals(expected, actual, "Email is wrong");
    }

    @Test
    public void testGetSetStoreId() {
        int expected = 500;

        testStaff.setStoreId(expected);
        int actual = testStaff.getStoreId();

        Assertions.assertEquals(expected, actual, "Store ID is wrong");
    }

    @Test
    public void testGetSetActive() {
        boolean expected = false;

        testStaff.setActive(expected);
        boolean actual = testStaff.getActive();

        Assertions.assertEquals(expected, actual, "Active is wrong");
    }

    @Test
    public void testGetSetUsername() {
        String expected = "New Username";

        testStaff.setUsername(expected);
        String actual = testStaff.getUsername();

        Assertions.assertEquals(expected, actual, "Username is wrong");
    }

    @Test
    public void testGetSetPassword() {
        String expected = "New Password";

        testStaff.setPassword(expected);
        String actual = testStaff.getPassword();

        Assertions.assertEquals(expected, actual, "Password is wrong");
    }
}
