package com.tsi.kirk.mcallister.microdemo.unit.customerdata;

import com.tsi.kirk.mcallister.microdemo.customerdata.Country;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CountryTest {

    Country testCountry;

    @BeforeEach
    public void setUp() {
        testCountry = new Country("New Country");
    }

    @Test
    public void testGetSetCountryId() {
        int expected = 500;

        testCountry.setCountryId(expected);
        int actual = testCountry.getCountryId();

        Assertions.assertEquals(expected, actual, "Country ID is wrong");
    }

    @Test
    public void testGetSetCountryName() {
        String expected = "Old Country";

        testCountry.setCountryName(expected);
        String actual = testCountry.getCountryName();

        Assertions.assertEquals(expected, actual, "Country Name is wrong");
    }
}
