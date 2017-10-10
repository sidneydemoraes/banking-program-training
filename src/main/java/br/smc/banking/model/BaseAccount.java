package br.smc.banking.model;

import lombok.Getter;

import java.math.BigDecimal;

/**
 * Abstract class that represents the basic structure of a baking account.
 *
 * Created by Sidney de Moraes
 */
public abstract class BaseAccount {

	protected Owner owner;

	@Getter
	protected BigDecimal balance;

}
