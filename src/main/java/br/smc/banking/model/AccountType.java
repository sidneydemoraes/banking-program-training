package br.smc.banking.model;

/**
 * Enumerator containing the available account types.
 *
 * Created by Sidney de Moraes
 */
public enum AccountType {

	CHECKING, REGULAR, SAVINGS;


	public static AccountType convertFromString(String type) {

		if (type == null)
			return REGULAR;

		switch (type.toLowerCase()) {
			case "checking":
				return CHECKING;
			case "savings":
				return SAVINGS;
			default:
				return REGULAR;
		}
	}

}
