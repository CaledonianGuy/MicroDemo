package com.tsi.kirk.mcallister.microdemo.cucumber.addactor;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty"},
        features = "src/test/resources/Cucumber",
        glue = "com.tsi.kirk.mcallister.microdemo.cucumber.addactor")
public class RunCucumberTest {

}
