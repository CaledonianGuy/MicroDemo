package com.tsi.kirk.mcallister.microdemo.unit.inventory;

import com.tsi.kirk.mcallister.microdemo.inventory.Actor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ActorTest {
    Actor testActor;

    @BeforeEach
    public void setUp() {
        testActor = new Actor("Elliot", "Craig");
    }

    @Test
    public void testGetActorId() {
        int testId = testActor.getActorId();

        Assertions.assertNotNull(testId, "Test ID is NULL");
    }

    @Test
    public void testGetSetFirstName() {
        String expectedOne = "Elliot";
        String actualOne = testActor.getFirstName();

        Assertions.assertEquals(expectedOne, actualOne, "Expected and Actual Fist Names DO NOT match");


        testActor.setFirstName("Bob");

        String expectedTwo = "Bob";
        String actualTwo = testActor.getFirstName();

        Assertions.assertEquals(expectedTwo, actualTwo, "First Name not changed correctly");
    }

    @Test
    public void testGetSetLastName() {
        String expectedOne = "Craig";
        String actualOne = testActor.getLastName();

        Assertions.assertEquals(expectedOne, actualOne, "Expected and Actual Last Names DO NOT match");


        testActor.setLastName("Cat");

        String expectedTwo = "Cat";
        String actualTwo = testActor.getLastName();

        Assertions.assertEquals(expectedTwo, actualTwo, "Last Name not changed correctly");
    }
}
