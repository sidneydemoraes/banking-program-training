package steps;

import br.smc.banking.model.*;
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
			AccountType accountType = world.getAccountType();
			Class accountClass;
			try {
				accountClass = Class.forName(accountType.getAccountClassName());
			} catch (ClassNotFoundException e) {
				throw new RuntimeException(e);
			}

			switch (accountType) {
				case REGULAR:
					Account account = new Account(dummyOwner);
					account.deposit(balance);
					world.setRegularAccount(account);
					break;
				case CHECKING:
					CheckingAccount checkingAccount = new CheckingAccount(dummyOwner);
					checkingAccount.deposit(balance);
					world.setCheckingAccount(checkingAccount);
					break;
				case SAVINGS:
					SavingsAccount savingsAccount = new SavingsAccount(dummyOwner);
					savingsAccount.deposit(balance);
					world.setSavingsAccount(savingsAccount);
					break;
				default:
					throw new RuntimeException();
			}

		});


		Given("^my account has a loan limit of \\$([\\d\\.]+)$", (String amount) -> {
			BigDecimal limit = new BigDecimal(amount);
			world.getCheckingAccount().setLoanLimit(limit);
		});

	}

}
