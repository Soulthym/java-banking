package banking;

import java.util.ArrayList;
import java.util.List;

import banking.InputException;
import banking.IntegerInputChecker;
import banking.LitteralInputChecker;
import logger.WritingException;

public class Program {

	private Interface _interface;
	private Operations _operations;
	private Account _userAccount;
	private List <Account> _accounts;


	public Program () throws WritingException {
		_interface = new Interface();
		_operations = new Operations();
		_accounts = new ArrayList <Account> ();
	}

	public Account connexion () throws InputException, WritingException {
		_accounts = _operations.initAccounts();
		int userChoice = Integer.parseInt(_interface.askUser("Welcome to our bank\nWhat would you like to do? (Fill in with the option's number)\n1) Create an account\n2) Connect to you account", new IntegerInputChecker(1, 2)));
		String name = "Bob";
		int age = 10;
		boolean ok = false;
		switch (userChoice) {
			case 1 : {
				while (!ok) {
					ok = true;
					name = _interface.askUser("Please state your name.", new LitteralInputChecker());
					age = Integer.parseInt(_interface.askUser("Please enter your age.", new IntegerInputChecker(0, 150)));
					for (Account account : _accounts) {
						if (name.equals(account.getUserName()) && age == account.getUserAge()){
							System.out.println("There is already a member with this name and age in our data base.");
							ok = false;
						}
					}
				}
				_userAccount = _operations.createNewAccount(name, age);
				break;
			}
			case 2 : {
				while (!ok) {
					name = _interface.askUser("Please state your name.", new LitteralInputChecker());
					age = Integer.parseInt(_interface.askUser("Please enter your age.", new IntegerInputChecker(0, 150)));
					for (Account account : _accounts) {
						if (name.equals(account.getUserName()) && age == account.getUserAge()){
							System.out.println("There is no one in our data base with this name and age.");
							ok = true;
						}
					}
				}
				_userAccount = _operations.connectToYourAccount(name);
				break;
			}
		}
		_interface.informUser("You are now connected as " + _userAccount.getUserName());
		return _userAccount;
	}


	public void menu (Account account) throws InputException, NumberFormatException, WritingException {
		int userChoice = Integer.parseInt(_interface.askUser("What woud you like to do ?(Fill in with the option's number)\n0) See your funds.\n1) Deposit money\n2) Withdraw money\n3) Manage your loans\n4) Transfer money to another account.", new IntegerInputChecker(0, 4)));
		switch (userChoice) {
			case 0 : {
				_operations.seeYourFunds(account);
				break;
			}
			case 1 : {
				_operations.depositMoney(account);
				break;
			}
			case 2 : {
				_operations.withdrawMoney(account);
				break;
			}
			case 3 : {
				_operations.manageLoans(account);
				break;
			}
			case 4 : {
				_operations.transferMoney(account);
				break;
			}
		}
	}
}
