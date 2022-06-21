package com.tsi.kirk.mcallister.microdemo.mockito;

import com.tsi.kirk.mcallister.microdemo.MicroDemoApplication;
import com.tsi.kirk.mcallister.microdemo.inventory.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.internal.matchers.apachecommons.ReflectionEquals;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MockitoTest {

    private MicroDemoApplication microDemoApp;
    @Mock
    private ActorRepository actorRepo;
    @Mock
    private FilmRepository filmRepo;
    @Mock
    private CategoryRepository catRepo;
//    @Mock
//    private LanguageRepository langRepo;
//    @Mock
//    private FilmTextRepository filmTextRepo;
//    @Mock
//    private InventoryRepository inventItemRepo;
    @Mock
    private FilmCategoryRepository filmCatRepo;
    @Mock
    private FilmActorRepository filmActorRepo;


    @BeforeEach
    void setUp() {
        microDemoApp = new MicroDemoApplication(
                actorRepo,
                filmRepo,
                catRepo,
                filmCatRepo,
                filmActorRepo
        );
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
        int mockId = 1;
        Actor expectedActor = new Actor("Drew", "McAvoy");

        when(actorRepo.findById(mockId)).thenReturn(Optional.of(expectedActor));
        microDemoApp.deleteActor(mockId);
        verify(actorRepo).deleteById(mockId);
    }

    @Test
    public void updateActor() {
        int mockId = 1;
        Actor expectedActorOne = new Actor("EMMA", "BACON");

        when(actorRepo.findById(mockId)).thenReturn(Optional.of(expectedActorOne));
        microDemoApp.updateActor(mockId, expectedActorOne.getFirstName(), expectedActorOne.getLastName());

        ArgumentCaptor<Actor> actorArgumentCaptor = ArgumentCaptor.forClass(Actor.class);
        verify(actorRepo, times(1)).save(actorArgumentCaptor.capture());
        Actor actualActor = actorArgumentCaptor.getValue();

        Assertions.assertTrue(new ReflectionEquals(expectedActorOne).matches(actualActor));


        Actor expectedActorTwo = new Actor(" ", " ");

        when(actorRepo.findById(mockId)).thenReturn(Optional.of(expectedActorTwo));
        microDemoApp.updateActor(mockId, expectedActorTwo.getFirstName(), expectedActorTwo.getLastName());

        actorArgumentCaptor = ArgumentCaptor.forClass(Actor.class);
        verify(actorRepo, times(2)).save(actorArgumentCaptor.capture());
        actualActor = actorArgumentCaptor.getValue();

        Assertions.assertTrue(new ReflectionEquals(expectedActorTwo).matches(actualActor));
    }
}
