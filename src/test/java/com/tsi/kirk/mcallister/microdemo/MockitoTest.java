package com.tsi.kirk.mcallister.microdemo;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.internal.matchers.apachecommons.ReflectionEquals;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.assertj.core.api.Assertions.assertThat;
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
        //TODO this might need to be bigger - since not a main mapping might skip for now
        int mockId = 1;
        microDemoApp.getActor(mockId);
        verify(actorRepo).findById(mockId);
//        Assertions.assertNotNull(mockActor, "Object is NULL");
    }

    @Test
    public void addActor() {
        Actor expectedActor = new Actor("EMMA", "BACON");

        microDemoApp.addActor(expectedActor.getFirstName(), expectedActor.getLastName());

        ArgumentCaptor<Actor> actorArgumentCaptor = ArgumentCaptor.forClass(Actor.class);
        verify(actorRepo).save(actorArgumentCaptor.capture());
        Actor actualActor = actorArgumentCaptor.getValue();

        Assertions.assertTrue(new ReflectionEquals(expectedActor).matches(actualActor));
    }

    @Test
    public void deleteActor() {
        //TODO not sure if more need to happen here
        int mockId = 1;

        microDemoApp.deleteActor(mockId);
        verify(actorRepo).deleteById(mockId);
    }

    @Test
    public void updateActor() {
        int mockId = 1;
        Actor expectedActor = new Actor("EMMA", "BACON");

        when(actorRepo.findById(mockId)).thenReturn(Optional.of(expectedActor));
        microDemoApp.updateActor(mockId, expectedActor.getFirstName(), expectedActor.getLastName());

        ArgumentCaptor<Actor> actorArgumentCaptor = ArgumentCaptor.forClass(Actor.class);
        verify(actorRepo).save(actorArgumentCaptor.capture());
        Actor actualActor = actorArgumentCaptor.getValue();

        Assertions.assertTrue(new ReflectionEquals(expectedActor).matches(actualActor));
    }
}
