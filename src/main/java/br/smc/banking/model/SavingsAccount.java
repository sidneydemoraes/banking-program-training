package br.smc.banking.model;

import lombok.NonNull;

import java.math.BigDecimal;

/**
 * Bean representing a Savings Account.
 *
 * Created by Sidney de Moraes.
 */
public class SavingsAccount extends Account {


	public SavingsAccount(@NonNull Owner owner) {

		super(owner);
	}


	public void applyInterest(BigDecimal interest) {

		int decimalDigits = 2;
		this.balance = this.balance.multiply(interest).setScale(decimalDigits, BigDecimal.ROUND_HALF_UP);
	}
}
