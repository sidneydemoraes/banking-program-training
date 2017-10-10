package br.smc.banking.model;

import lombok.NonNull;

/**
 * Bean representing a Savings Account.
 *
 * Created by Sidney de Moraes.
 */
public class SavingsAccount extends Account {


	public SavingsAccount(@NonNull Owner owner) {

		super(owner);
	}
}
