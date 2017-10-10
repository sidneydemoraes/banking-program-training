package br.smc.banking.model;

import br.smc.banking.exception.InsuficientFundsException;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * Bean representing a Checking Account.
 *
 * Created by Sidney de Moraes.
 */
public class CheckingAccount extends Account {

	@Setter
	@Getter
	private BigDecimal loanLimit;


	public CheckingAccount(Owner owner) {

		super(owner);
		this.loanLimit = BigDecimal.ZERO;
	}


	@Override
	public BigDecimal withdraw(@NonNull BigDecimal amount) throws InsuficientFundsException {

		if (amount.compareTo(BigDecimal.ZERO) < 0)
			throw new IllegalArgumentException("Amount must be greater than zero");

		if (balance.add(loanLimit).compareTo(amount) < 0)
			throw new InsuficientFundsException();

		this.balance = this.balance.subtract(amount);
		return this.balance;
	}
}
