package com.tsi.kirk.mcallister.microdemo.unit.customerdata;

import com.tsi.kirk.mcallister.microdemo.customerdata.Address;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AddressTest {

    Address testAddress;

    @BeforeEach
    public void setUp() {
        testAddress = new Address("50 Park Avenue", "North District", 250, "07000000001");
    }

    @Test
    public void testGetSetAddressId() {
        int expected = 500;

        testAddress.setAddressId(expected);
        int actual = testAddress.getAddressId();

        Assertions.assertEquals(expected, actual, "Address ID is wrong");
    }

    @Test
    public void testGetSetAddress1() {
        String expected = "100 River Street";

        testAddress.setAddress1(expected);
        String actual = testAddress.getAddress1();

        Assertions.assertEquals(expected, actual, "Address 1 is wrong");
    }

    @Test
    public void testGetSetAddress2() {
        String expected = "100 River Street";

        testAddress.setAddress2(expected);
        String actual = testAddress.getAddress2();

        Assertions.assertEquals(expected, actual, "Address 2 is wrong");
    }

    @Test
    public void testGetSetDistrict() {
        String expected = "South City";

        testAddress.setDistrict(expected);
        String actual = testAddress.getDistrict();

        Assertions.assertEquals(expected, actual, "District is wrong");
    }

    @Test
    public void testGetSetCityId() {
        int expected = 500;

        testAddress.setCityId(expected);
        int actual = testAddress.getCityId();

        Assertions.assertEquals(expected, actual, "City ID is wrong");
    }

    @Test
    public void testGetSetPostCode() {
        String expected = "AA99 9ZZ";

        testAddress.setPostCode(expected);
        String actual = testAddress.getPostCode();

        Assertions.assertEquals(expected, actual, "Post Code is wrong");
    }

    @Test
    public void testgetSetPhone() {
        String expected = "07111111110";

        testAddress.setPhone(expected);
        String actual = testAddress.getPhone();

        Assertions.assertEquals(expected, actual, "Phone number is wrong");
    }
}
