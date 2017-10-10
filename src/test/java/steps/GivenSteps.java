package steps;

import br.smc.banking.model.Account;
import br.smc.banking.model.AccountType;
import br.smc.banking.model.Owner;
import cucumber.api.java8.En;
import helpers.DummyObjectsFactory;
import helpers.World;

import java.math.BigDecimal;

/**
 * Given steps definitions for integrated tests.
 *
 * Created by Sidney de Moraes
 */
public class GivenSteps implements En {

	private World world;

	public GivenSteps(World world) {

		this.world = world;

		Given("^I have a (\\w+) account$", (String type) -> {
			world.setAccountType(AccountType.convertFromString(type));
		});


		Given("^my account has a balance of \\$([\\d^\\.]+)$", (String amount) -> {

			Owner dummyOwner = DummyObjectsFactory.getDummyOwner();
			BigDecimal balance = new BigDecimal(amount);
			Account account = new Account(dummyOwner);
			account.deposit(balance);
			world.setRegularAccount(account);
		});

	}

}
