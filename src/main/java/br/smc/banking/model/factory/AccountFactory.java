package br.smc.banking.model.factory;

import br.smc.banking.model.Owner;
import br.smc.banking.model.RegularAccount;

import java.math.BigDecimal;

/**
 * Factory for the different kinds of {@link br.smc.banking.model.Account}.
 *
 * Created by Sidney de Moraes.
 */
public class AccountFactory {

	/**
	 * Create a {@link RegularAccount} with ZERO balance.
	 *
	 * @param owner
	 * @return
	 */
	public static RegularAccount getRegularAccount(Owner owner) {

		return new RegularAccount(owner);
	}


	/**
	 * Create a {@link RegularAccount} with customized balance.
	 *
	 * @param owner
	 * @param amount
	 * @return
	 */
	public static RegularAccount getRegularAccount(Owner owner, BigDecimal amount) {

		return new RegularAccount(owner, amount);
	}

}
