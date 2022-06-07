package com.tsi.kirk.mcallister.microdemo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MockitoTest {

    private MicroDemoApplication microDemoApp;
    @Mock
    private ActorRepository actorRepo;
    @Mock
    private FilmRepository filmRepo;
    @Mock
    private CategoryRepository catRepo;
    @Mock
    private LanguageRepository langRepo;
    @Mock
    private FilmTextRepository filmTextRepo;
    @Mock
    private InventoryItemRepository inventItemRepo;

    @BeforeEach
    void setUp() {
        microDemoApp = new MicroDemoApplication(actorRepo, filmRepo, catRepo, langRepo, filmTextRepo, inventItemRepo);
    }

    @Test
    public void getAllActors() {
        microDemoApp.getAllActors();
        verify(actorRepo).findAll();
    }

    @Test
    public void getActor() {
        int testIdOne = 1;
        Optional<Actor> testActor = microDemoApp.getActor(testIdOne);

        verify(actorRepo).existsById(testIdOne);

        Assertions.assertNotNull(testActor, "Object is NULL");

        int testIdTwo = 1000;
        testActor = microDemoApp.getActor(testIdTwo);

        Assertions.assertEquals(Optional.empty(), testActor, "Object is NOT NULL");
    }

    @Test
    public void addActor() {
        Actor testActor = new Actor("Emma", "Bacon");

        String expected = "Actor added to database";
        String actual = microDemoApp.addActor(testActor.getFirstName(), testActor.getLastName());

        ArgumentCaptor<Actor> actorArgumentCaptor = ArgumentCaptor.forClass(Actor.class);

        verify(actorRepo).save(actorArgumentCaptor.capture());

        actorArgumentCaptor.getValue();

        Assertions.assertEquals(expected, actual, "Output does not match expected");
    }

    @Test
    public void deleteActor() {


//        int testId = 1;

//        String expectedOne = "Actor deleted from database";
//        String expectedTwo = "Actor not in database";
//        String actualOne = microDemoApp.deleteActor(testId);

//        ArgumentCaptor<Actor> actorArgumentCaptor = ArgumentCaptor.forClass(Actor.class);
//        when(microDemoApp.deleteActor(testId)).thenReturn("");

//        verify(actorRepo).existsById(testId);
//        verify(actorRepo).deleteById(testId);

//        Assertions.assertEquals(expectedOne, actualOne, "Actor was not deleted from the database");

//        String actualTwo = microDemoApp.deleteActor(testId);

//        Assertions.assertEquals(expectedTwo, actualTwo, "Actor was found in the database");


    }
}
