package br.smc.banking.model;

import br.smc.banking.exception.InsuficientFundsException;
import lombok.NonNull;

import java.math.BigDecimal;

/**
 * Bean representing a Regular Banking Account.
 *
 * Created by Sidney de Moraes.
 */
public class RegularAccount extends Account {

	/**
	 * A non-null {@link Owner} must be provided in order to construct a Regular Account.
	 *
	 * @param owner
	 */
	public RegularAccount (@NonNull Owner owner) {

		this(owner, BigDecimal.ZERO);
	}

	/**
	 * Non-null {@link Owner} and {@link BigDecimal} must be provided for this constructor.
	 *
	 * @param owner
	 * @param balance
	 */
	public RegularAccount(@NonNull Owner owner, @NonNull BigDecimal balance) {

		this.owner = owner;
		this.balance = balance;
	}


	/**
	 * Method that allows one to deposit any amount.
	 *
	 * @param amount to be deposited
	 * @return the new balance
	 */
	public BigDecimal deposit (@NonNull BigDecimal amount) {

		if (amount.compareTo(BigDecimal.ZERO) < 0)
			throw new IllegalArgumentException("Amount must be greater than zero");

		return this.balance.add(amount);
	}

	/**
	 * Method that allows one to withdraw amounts lower or equal to available balance.
	 * If the amount is greater, an {@link InsuficientFundsException} is raised.
	 *
	 * @param amount
	 * @return
	 * @throws InsuficientFundsException
	 */
	public BigDecimal withdraw (@NonNull BigDecimal amount) throws InsuficientFundsException {

		if (amount.compareTo(BigDecimal.ZERO) < 0)
			throw new IllegalArgumentException("Amount must be greater than zero");

		if (balance.compareTo(amount) < 0)
			throw new InsuficientFundsException();

		return this.balance.subtract(amount);
	}


}
