import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Integrated Test created following the BDD principle.
 * This file was named as <code>Test</code> instead of <code>IT</code> just to ease execution during code evaluation.
 *
 * Created by Sidney de Moraes
 */
@RunWith(Cucumber.class)
@CucumberOptions(
	plugin = {
		"pretty",
		"html:target/cucumber"
	},
	glue = {
			"classpath:steps"
	},
	features = {
		"classpath:features"
	}
)
public class TestRunner {

}
