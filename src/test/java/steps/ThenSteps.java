package steps;

import cucumber.api.java8.En;
import helpers.World;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

/**
 * Then steps definitions for integrated tests.
 *
 * Created by Sidney de Moraes
 */
public class ThenSteps implements En {

	private World world;

	public ThenSteps(World world) {

		this.world = world;

		Then("^my account balance is shown as \\$([\\d\\.]+)$", (String amount) -> {

			BigDecimal expectedBalance = new BigDecimal(amount);
			assertEquals(expectedBalance, world.getRegularAccount().getBalance());
		});

		Then("^I see a '([\\w\\s]+)' error message$", (String error) -> {

			String expectedExceptionName = error.replace(" ", "") + "Exception";
			assertEquals(expectedExceptionName, world.getThrownException());
		});
	}
}
