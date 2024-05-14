package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features ="src/test/resources/feature/crud.feature", // Path to your feature files
        glue ={"CRUD/StepDefinations"} // Package where your step definitions are located

)
public class TestRunner {
}

