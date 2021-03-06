package banking;

import java.util.ArrayList;
import java.util.List;

import banking.InputException;
import banking.IntegerInputChecker;
import banking.LoanTauxInputChecker;
import banking.LoanTimeInputChecker;
import banking.WrongAgeInputChecker;
import banking.WrongNameInputChecker;
import logger.FileLogger;
import logger.LoggerFactory;
import logger.WritingException;

public class Operations {

	private List <Account> _accounts;
	private Interface _interface;
	private FileLogger _fileLogger;

	public Operations () throws WritingException {
		_accounts = new ArrayList <Account> ();
		_interface = new Interface();
		_fileLogger = LoggerFactory.getFileLogger();
	}

	public List<Account> initAccounts () {
		Account account1 = new Account ("Chloe", 35);
		Account account2 = new Account ("Benjamin", 52);
		Account account3 = new Account ("Emilie", 77);
		_accounts.add(account1);
		_accounts.add(account2);
		_accounts.add(account3);
		return _accounts;
	}

	public Account createNewAccount (String name, int age) throws InputException, WritingException {
		Account userAccount = new Account (name, age);
		_accounts.add(userAccount);
		_fileLogger.info ("PROGRAM", "The program is now used by " + userAccount.getUserName());
		return userAccount;
	}

	public Account connectToYourAccount (String name) throws InputException, WritingException {
		Account userAccount = _accounts.get(0);
		for (Account account : _accounts) {
			if (name.equals(account.getUserName())){
				userAccount = account;
			}
		}
		_fileLogger.info ("PROGRAM", "The program is now used by " + userAccount.getUserName());
		return userAccount;
	}

	public void seeYourFunds (Account account) throws WritingException {
		_interface.informUser("Your funds are " + account.getTotal() + "�.");
	}

	public void depositMoney (Account account) throws InputException, WritingException {
		int moneyToAdd = Integer.parseInt(_interface.askUser("How much would you like to deposit?", new IntegerInputChecker(0, Integer.MAX_VALUE)));
		account.addMoney(moneyToAdd);
		_interface.informUser("Your funds are now " + account.getTotal() + "�.");
		_fileLogger.info ("PROGRAM", "Account : " + account.getUserName() + " , age : "+ account.getUserAge() + " has been credited of" + account.getTotal() + "�.");
	}

	public void withdrawMoney (Account account) throws InputException, WritingException {
		int moneyToWithdraw = Integer.parseInt(_interface.askUser("How much would you like to withdraw?", new IntegerInputChecker(0, account.getTotal(), "You don't have enough money, you only have " + account.getTotal() + "�.")));
		account.withdrawMoney(moneyToWithdraw);
		_interface.informUser("Your funds are now " + account.getTotal() + "�.");
		_fileLogger.info ("PROGRAM", "Account : " + account.getUserName() + " , age : "+ account.getUserAge() + " has been credited of" + account.getTotal() + "�.");

	}

	public void manageLoans (Account account) throws InputException, WritingException {
		int userChoice = Integer.parseInt(_interface.askUser("(Fill in with the option's number)\n1) See your loans\n2) Take a new loan", new IntegerInputChecker(1, 2)));
		switch (userChoice) {
			case 1 : {
				_interface.informUser("Here is your list of loans :");
				for(int i = 0; i < account.getLoans().size(); i++) {
					_interface.informUser("Amount : " + Integer.toString(account.getLoans().get(i).getAmount()));
					_interface.informUser("Rate : " + Double.toString(account.getLoans().get(i).getTaux()));
					_interface.informUser("Time : " + Integer.toString(account.getLoans().get(i).getTime()));

				}
			}
			case 2 : {
				if (account.getLoans().size() < 2) {
					int amount = Integer.parseInt(_interface.askUser("What amount do you need?", new IntegerInputChecker(0, Integer.MAX_VALUE)));
					double taux = Double.parseDouble(_interface.askUser("Which rate would you like?", new LoanTauxInputChecker()));
					int time = Integer.parseInt(_interface.askUser("On how many years would you like to refund?", new LoanTimeInputChecker(account.getUserAge())));
					account.takeANewLoan(taux, amount, time);
					_fileLogger.info ("PROGRAM", "Account : " + account.getUserName() + " , age : "+ account.getUserAge() + " has a new loan of " + amount + "�, with a rate of " + taux + "and a time of : " + time);
					_interface.informUser("Your list of loans is now :\n" );
				} else {
					_interface.informUser("You can't have another loan, here is your list of loans :");
				}
				for(int i = 0; i < account.getLoans().size(); i++) {
				_interface.informUser("Amount : " + Integer.toString(account.getLoans().get(i).getAmount()));
				_interface.informUser("Rate : " + Double.toString(account.getLoans().get(i).getTaux()));
				_interface.informUser("Time : " + Integer.toString(account.getLoans().get(i).getTime()));
				}
			}
		}
	}

	public void transferMoney (Account account) throws InputException, WritingException {
		_interface.informUser("Here is the list of our members :\n");
		for(int i = 0; i < _accounts.size(); i++) {
			_interface.informUser(_accounts.get(i).getUserName());
			_interface.informUser(Integer.toString(_accounts.get(i).getUserAge()));
		}
		String nameToTransfer = _interface.askUser("Who would you like to transfer money to?", new WrongNameInputChecker(_accounts));
		int ageToTransfer = Integer.parseInt(_interface.askUser("What is the age of the reciever", new WrongAgeInputChecker(_accounts, nameToTransfer)));
		int moneyToTransfer = Integer.parseInt(_interface.askUser("How much money would you like to transfer?", new IntegerInputChecker(0, account.getTotal())));
		account.withdrawMoney(moneyToTransfer);
		for(int i = 0; i < _accounts.size(); i++) {
			if (nameToTransfer.equals(_accounts.get(i).getUserName()) && ageToTransfer==_accounts.get(i).getUserAge()) {
				Account accountToTransfer = _accounts.get(i);
				accountToTransfer.addMoney(moneyToTransfer);
				_fileLogger.info ("PROGRAM", moneyToTransfer + "� has been transfered from " + account.getUserName() + ", " + account.getUserAge() + " to " + accountToTransfer.getUserName() + ", " + accountToTransfer.getUserAge());
			}
		}
	}

}
