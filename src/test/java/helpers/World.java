package helpers;

import br.smc.banking.model.Account;
import br.smc.banking.model.AccountType;
import br.smc.banking.model.CheckingAccount;
import br.smc.banking.model.SavingsAccount;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * A helper object created to hold other objects that will be used by tests throughout steps.
 *
 * Created by Sidney de Moraes.
 */
public class World {

	@Getter @Setter
	private AccountType accountType;

	@Getter @Setter
	private Account regularAccount;

	@Getter
	private CheckingAccount checkingAccount;

	@Getter
	private SavingsAccount savingsAccount;

	@Getter
	@Setter
	private String thrownException;

	@Getter
	@Setter
	private BigDecimal interest;


	public void setCheckingAccount(CheckingAccount account) {

		this.checkingAccount = account;
		this.regularAccount = account;
	}

	public void setSavingsAccount(SavingsAccount account) {

		this.savingsAccount = account;
		this.regularAccount = account;
	}

}
