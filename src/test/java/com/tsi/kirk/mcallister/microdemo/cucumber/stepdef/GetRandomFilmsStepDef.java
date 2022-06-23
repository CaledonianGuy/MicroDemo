package com.tsi.kirk.mcallister.microdemo.cucumber.stepdef;

import com.github.tomakehurst.wiremock.WireMockServer;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.After;
import org.junit.jupiter.api.Assertions;

import java.io.IOException;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;

public class GetRandomFilmsStepDef {

    private static String numOfFilmsToFind;
    private static String path;
    private static HttpResponse response;

    private final WireMockServer mockServer = new WireMockServer(options().dynamicPort());
    private final CloseableHttpClient httpClient = HttpClients.createDefault();

    @Before
    public void setUp() {
        mockServer.start();
    }

    @After
    public void tearDown() {
        mockServer.stop();
    }

    @Given("I want a {string} of movies I would like found")
    public void build(String numOfFilmsToFind) {
        GetRandomFilmsStepDef.numOfFilmsToFind = numOfFilmsToFind;
        path = "/Find_Films/" + numOfFilmsToFind;
    }

    @When("I send the request")
    public void sendRequest() throws IOException {
        configureFor("localhost", mockServer.port());
        stubFor(get(urlEqualTo(path))
                .willReturn(aResponse().withStatus(200)));

        HttpGet request = new HttpGet("http://localhost:" + mockServer.port() + path);
        response = httpClient.execute(request);
    }

    @Then("The request return status code {int}")
    public void returnStatusCode(int expected) {
        Assertions.assertEquals(expected, response.getStatusLine().getStatusCode());
        verify(getRequestedFor(urlEqualTo(path)));
    }

    @And("I want to find by {string}")
    public void buildURLStringGenre(String genre) {
        path = "/Find_Films_By_Genre/" + genre + "/" + numOfFilmsToFind;
    }

    @And("I want to find by {string} {string}")
    public void buildURLStringActor(String firstName, String lastName) {
        path = "/Find_Films_By_Actor/" + firstName + "/" + lastName + "/" + numOfFilmsToFind;
    }
}
