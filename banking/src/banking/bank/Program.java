package org.bank;

import org.check.IntegerInputChecker;
import org.check.LitteralInputChecker;

public class Program {

	private Interface _interface;
	private Operations _operations;
	private Account _userAccount;
	
	public Program () {		
		_interface = new Interface();
		_operations = new Operations();
	}
	
	public void connection () throws Exception {
		int userChoice = Integer.parseInt(_interface.askUser("Hello\nWhat would you like to do? (Fill in with the option's number)\n1) Create an account\n2) Connect to you account", new IntegerInputChecker(1, 2)));
		String name = _interface.askUser("Please state your name.", new LitteralInputChecker());
		int age = Integer.parseInt(_interface.askUser("Please enter your age.", new IntegerInputChecker(0, 150)));
		switch (userChoice) {
			case 1 : {
				_userAccount = _operations.createNewAccount(name, age);
				menu (_userAccount);
			}
			case 2 : {
				_userAccount = _operations.connectToYourAccount(name);
				menu (_userAccount);
			}
			
		}
	}
	
	
	//throws Input & Rule Exception ?
	private void menu (Account account) throws Exception {
		int userChoice = Integer.parseInt(_interface.askUser("What woud you like to do ?(Fill in with the option's number)\n0) See your funds.\n1) Deposit money\n2) Withdraw money\n3) Manage your loans\n4) Transfer money to another account.", new IntegerInputChecker(0, 4)));
		switch (userChoice) {
			case 0 : {
				_operations.seeYourFunds(account);
			}
			case 1 : {
				_operations.depositMoney(account);
			}
			case 2 : {
				_operations.withdrawMoney(account);
			}
			case 3 : {
				_operations.manageLoans(account);
			}
			case 4 : {
				_operations.transferMoney(account);
			}
		}
	}
	

	
}
