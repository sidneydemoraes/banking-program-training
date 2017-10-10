package br.smc.banking.model;

/**
 * Enumerator containing the available account types.
 *
 * Created by Sidney de Moraes
 */
public enum AccountType {

	CHECKING("CheckingAccount"),
	REGULAR("Account"),
	SAVINGS("SavingsAccount");


	private final String accountClassName;
	private final String packageName = "br.smc.banking.model.";

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


	private AccountType(String className) {
		this.accountClassName = className;
	}

	public String getAccountClassName() {
		return this.packageName + this.accountClassName;
	}

}
