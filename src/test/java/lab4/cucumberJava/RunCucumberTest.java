package lab4.cucumberJava;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
@RunWith(Cucumber.class)
@CucumberOptions(	plugin = {"pretty"},
					features = "src/test/resources/Lab4",
					glue = "lab4.cucumberJava"
					)
public class RunCucumberTest {

}
