package banking;

import banking.InputException;
import banking.IntegerInputChecker;
import banking.LitteralInputChecker;
import banking.RuleException;

public class Program {

	private Interface _interface;
	private Operations _operations;
	private Account _userAccount;

	public Program () {
		_interface = new Interface();
		_operations = new Operations();
	}

	public Account connexion () throws RuleException, InputException {
		int userChoice = Integer.parseInt(_interface.askUser("Hello\nWhat would you like to do? (Fill in with the option's number)\n1) Create an account\n2) Connect to you account", new IntegerInputChecker(1, 2)));
		String name = _interface.askUser("Please state your name.", new LitteralInputChecker());
		int age = Integer.parseInt(_interface.askUser("Please enter your age.", new IntegerInputChecker(0, 150)));
		switch (userChoice) {
			case 1 : {
				_userAccount = _operations.createNewAccount(name, age);
				break;
			}
			case 2 : {
				_userAccount = _operations.connectToYourAccount(name);
				break;
			}
		}
		_interface.informUser("You are now connected as" + _userAccount.getUserName());
		return _userAccount;
	}


	public void menu (Account account) throws RuleException, InputException {
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
