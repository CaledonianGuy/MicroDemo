package com.tsi.kirk.mcallister.microdemo.cucumber.addactor;

import com.tsi.kirk.mcallister.microdemo.MicroDemoApplication;
import com.tsi.kirk.mcallister.microdemo.inventory.Actor;
import com.tsi.kirk.mcallister.microdemo.inventory.ActorRepository;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.ArgumentCaptor;
import org.mockito.internal.matchers.apachecommons.ReflectionEquals;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class addActorStepDef {

    Actor newActor;
    MicroDemoApplication microDemoApp;
    ActorRepository actorRepo;

    @Before
    public void beforeScenario() {
        actorRepo = mock(ActorRepository.class);
        microDemoApp = new MicroDemoApplication(actorRepo);

//        Actor newActor;
//        ActorRepository
//        MicroDemoApplication microdemo =
    }

    @Given("I have the actors information")
    public void i_have_the_actors_information() {
        newActor = new Actor("Drew", "McAvoy");
//        throw new io.cucumber.java.PendingException();
    }

    @When("I input the data into the database")
    public void i_input_the_data_into_the_database() {
        microDemoApp.addActor(newActor.getFirstName(), newActor.getLastName());
//        throw new io.cucumber.java.PendingException();
    }

    @Then("I get the success return string")
    public void i_get_the_success_return_string() {
        //TODO Assertions goes here
        ArgumentCaptor<Actor> actorArgumentCaptor = ArgumentCaptor.forClass(Actor.class);
        verify(actorRepo).save(actorArgumentCaptor.capture());
        Actor actualActor = actorArgumentCaptor.getValue();

        Assertions.assertTrue(new ReflectionEquals(newActor).matches(actualActor));
//        throw new io.cucumber.java.PendingException();
    }
}
