package com.tsi.kirk.mcallister.microdemo.unit.customerdata;

import com.tsi.kirk.mcallister.microdemo.customerdata.City;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CityTest {

    City testCity;

    @BeforeEach
    public void setUp() {
        testCity = new City("New City", 250);
    }

    @Test
    public void testGetSetCityId() {
        int expected = 500;

        testCity.setCityId(expected);
        int actual = testCity.getCityId();

        Assertions.assertEquals(expected, actual, "City ID is wrong");
    }

    @Test
    public void testGetSetCityName() {
        String expected = "Old City";

        testCity.setCityName(expected);
        String actual = testCity.getCityName();

        Assertions.assertEquals(expected, actual, "City Name is wrong");
    }

    @Test
    public void testGetSetCountryId() {
        int expected = 500;

        testCity.setCountryId(expected);
        int actual = testCity.getCountryId();

        Assertions.assertEquals(expected, actual, "Country ID is wrong");
    }
}
