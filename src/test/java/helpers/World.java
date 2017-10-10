package helpers;

import br.smc.banking.model.Account;
import br.smc.banking.model.AccountType;
import lombok.Getter;
import lombok.Setter;

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
	@Setter
	private String thrownException;

}
