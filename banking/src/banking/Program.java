package banking;

// import banking.InputException;
// import banking.IntegerInputChecker;
// import banking.LitteralInputChecker;
// import banking.RuleException;

public class Program {

	private Interface _interface;
	private Operations _operations;
	private Account _userAccount;

	public Program () {
		try {
			_interface = new Interface();
			_operations = new Operations();
		} catch (Exception e) {
			System.out.println("failed");
		}
	}

	public Account connexion () throws RuleException, InputException {
		int userChoice = 0;
		String name = "";
		int age = 0;
		try {
			userChoice = Integer.parseInt(_interface.askUser("Hello\nWhat would you like to do? (Fill in with the option's number)\n1) Create an account\n2) Connect to you account", new IntegerInputChecker(1, 2)));
		} catch (Exception e){
			System.out.println("failed");
		}
		try {
			name = _interface.askUser("Please state your name.", new LitteralInputChecker());
		} catch (Exception e){
			System.out.println("failed");
		}
		try {
			age = Integer.parseInt(_interface.askUser("Please enter your age.", new IntegerInputChecker(0, 150)));
		} catch (Exception e){
			System.out.println("failed");
		}
		switch (userChoice) {
			case 1 : {
				try {
					_userAccount = _operations.createNewAccount(name, age);
				} catch (Exception e) {
					System.out.println("failed");
				}
				break;
			}
			case 2 : {
				try {
					_userAccount = _operations.connectToYourAccount(name);
				} catch (Exception e) {
					System.out.println("failed");
				}
				break;
			}
		}
		try {
			_interface.informUser("You are now connected as" + _userAccount.getUserName());
		} catch (Exception e) {
			System.out.println("failed");
		}
	return _userAccount;
	}


	public void menu (Account account) throws RuleException, InputException {
		try{
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
		} catch (Exception e) {
			System.out.println("failed");
		}
	}
}
