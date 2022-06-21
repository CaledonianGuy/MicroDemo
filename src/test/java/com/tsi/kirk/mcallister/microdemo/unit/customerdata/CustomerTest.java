package com.tsi.kirk.mcallister.microdemo.unit.customerdata;

import com.tsi.kirk.mcallister.microdemo.customerdata.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class CustomerTest {

    Customer testCustomer;

    @BeforeEach
    public void setUp() {
        testCustomer = new Customer(
                250,
                "First Name",
                "Last Name",
                250,
                true,
                LocalDateTime.now()
        );
    }

    @Test
    public void testGetSetCustomerId() {
        int expected = 500;

        testCustomer.setCustomerId(expected);
        int actual = testCustomer.getCustomerId();

        Assertions.assertEquals(expected, actual, "Customer ID is wrong");
    }

    @Test
    public void testGetSetStoreId() {
        int expected = 500;

        testCustomer.setStoreId(expected);
        int actual = testCustomer.getStoreId();

        Assertions.assertEquals(expected, actual, "Store ID is wrong");
    }

    @Test
    public void testGetSetFirstName() {
        String expected = "New First Name";

        testCustomer.setFirstName(expected);
        String actual = testCustomer.getFirstName();

        Assertions.assertEquals(expected, actual, "First Name is wrong");
    }

    @Test
    public void testGetSetLastName() {
        String expected = "New Last Name";

        testCustomer.setLastName(expected);
        String actual = testCustomer.getLastName();

        Assertions.assertEquals(expected, actual, "Last Name is wrong");
    }

    @Test
    public void testGetSetEmail() {
        String expected = "a@b.c";

        testCustomer.setEmail(expected);
        String actual = testCustomer.getEmail();

        Assertions.assertEquals(expected, actual, "Email is wrong");
    }

    @Test
    public void testGetSetAddressId() {
        int expected = 500;

        testCustomer.setAddressId(expected);
        int actual = testCustomer.getAddressId();

        Assertions.assertEquals(expected, actual, "Address ID is wrong");
    }

    @Test
    public void testGetSetActive() {
        boolean expected = false;

        testCustomer.setActive(expected);
        boolean actual = testCustomer.getActive();

        Assertions.assertEquals(expected, actual, "Active is wrong");
    }

    @Test
    public void testGetSetCreateDate() {
        LocalDateTime expected = LocalDateTime.now();

        testCustomer.setCreateDate(expected);
        LocalDateTime actual = testCustomer.getCreateDate();

        Assertions.assertEquals(expected, actual, "Create Date is wrong");
    }
}
