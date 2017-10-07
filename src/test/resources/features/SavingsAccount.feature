Feature: Savings Account

	Scenario: Deposit money

		Given I have a “savings” account
		And my account has a balance of $5000.00
		When I deposit $500.00
		Then my account balance is shown as $5500.00

	Scenario: Withdraw money with enough funds

		Given I have a “savings” account
		And my account has a balance of $1000.00
		When I withdraw $600.00
		Then my account balance is shown as $400.00

	Scenario: Withdraw money without funds

		Given I have a “savings” account
		And my account has a balance of $100.00
		When I withdraw $500.00
		Then I see a “No Funds” error message
		And my account balance is shown as $100.00

	Scenario: Receive interest

		Given I have a “savings” account
		And my account has a balance of $1000.00
		And interests are set to 10%
		When the interests collection is triggered
		Then my account balance is shown as $1100.00