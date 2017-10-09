package steps;

import br.smc.banking.model.AccountType;
import br.smc.banking.model.Owner;
import br.smc.banking.model.RegularAccount;
import br.smc.banking.model.factory.AccountFactory;
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

		Given("I have a \"(\\s+)\" account", (String type) -> {
			world.setAccountType(AccountType.convertFromString(type));
		});


		Given("my account has a balance of $([\\d\\.])+", (String amount) -> {

			Owner dummyOwner = DummyObjectsFactory.getDummyOwner();
			BigDecimal balance = new BigDecimal(amount);
			RegularAccount account = AccountFactory.getRegularAccount(dummyOwner, balance);
			world.setRegularAccount(account);
		});

	}

}
