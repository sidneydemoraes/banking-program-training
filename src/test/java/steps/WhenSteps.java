package steps;

import br.smc.banking.exception.InsuficientFundsException;
import cucumber.api.java8.En;
import helpers.World;

import java.math.BigDecimal;

/**
 * When steps definitions for integrated tests.
 *
 * Created by Sidney de Moraes
 */
public class WhenSteps implements En {

	private World world;

	public WhenSteps(World world) {

		this.world = world;

		When("^I deposit \\$([\\d\\.]+)$", (String amount) -> {
			BigDecimal value = new BigDecimal(amount);
			world.getRegularAccount().deposit(value);
		});

		When("^I withdraw \\$([\\d\\.]+)$", (String amount) -> {
			BigDecimal value = new BigDecimal(amount);
			try {
				world.getRegularAccount().withdraw(value);
			} catch (InsuficientFundsException e) {
				world.setThrownException(e.getClass().getSimpleName());
			}
		});

		When("^the interests are applied$", () -> {
			world.getSavingsAccount().applyInterest(
					world.getInterest()
			);
		});
	}
}
