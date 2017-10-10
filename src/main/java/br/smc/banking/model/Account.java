package br.smc.banking.model;

import br.smc.banking.exception.InsuficientFundsException;
import lombok.NonNull;

import java.math.BigDecimal;

/**
 * Bean representing a Regular Banking Account.
 *
 * Created by Sidney de Moraes.
 */
public class Account extends BaseAccount {

	/**
	 * A non-null {@link Owner} must be provided in order to construct a Regular Account.
	 *
	 * @param owner
	 */
	public Account(@NonNull Owner owner) {

		this.owner = owner;
		this.balance = BigDecimal.ZERO;
	}

	/**
	 * Method that allows one to deposit any amount.
	 *
	 * @param amount to be deposited
	 * @return the new balance
	 */
	public BigDecimal deposit(@NonNull BigDecimal amount) {

		if (amount.compareTo(BigDecimal.ZERO) < 0)
			throw new IllegalArgumentException("Amount must be greater than zero");

		this.balance = this.balance.add(amount);
		return this.balance;
	}

	/**
	 * Method that allows one to withdraw amounts lower or equal to available balance.
	 * If the amount is greater, an {@link InsuficientFundsException} is raised.
	 *
	 * @param amount
	 * @return
	 * @throws InsuficientFundsException
	 */
	public BigDecimal withdraw(@NonNull BigDecimal amount) throws InsuficientFundsException {

		if (amount.compareTo(BigDecimal.ZERO) < 0)
			throw new IllegalArgumentException("Amount must be greater than zero");

		if (balance.compareTo(amount) < 0)
			throw new InsuficientFundsException();

		this.balance = this.balance.subtract(amount);
		return this.balance;
	}


}
