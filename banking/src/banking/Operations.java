package org.bank;

import java.util.ArrayList;
import java.util.List;

import org.check.AlreadyExistingAccountInputChecker;
import org.check.InputException;
import org.check.IntegerInputChecker;
import org.check.LoanTauxInputChecker;
import org.check.LoanTimeInputChecker;
import org.check.NoOneInDataBase;
import org.check.NoOneToTransferTo;
import org.check.NumberOfLoansRuleChecker;
import org.check.RuleException;
import org.check.WrongAgeInputChecker;
import org.check.WrongNameInputChecker;
import org.logger.FileLogger;
import org.logger.LoggerFactory;
import org.logger.WritingException;

public class Operations {

	private List <Account> _accounts;
	private Interface _interface;
	private FileLogger _fileLogger;
	
	public Operations () throws WritingException {
		_accounts = new ArrayList <Account> ();
		_interface = new Interface();
		_fileLogger = LoggerFactory.getFileLogger();
	}
	
	public Account createNewAccount (String name, int age) throws InputException, WritingException {
		_interface.checkUserPossibilities(new AlreadyExistingAccountInputChecker (_accounts, name, age));
		Account userAccount = new Account (name, age);
		_accounts.add(userAccount);
		_fileLogger.info ("PROGRAM", "The program is now used by " + userAccount.getUserName());
		return userAccount;
	}
	
	public Account connectToYourAccount (String name) throws InputException, WritingException {
		_interface.checkUserPossibilities(new NoOneInDataBase(_accounts));
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
		_interface.informUser("Your funds are " + account.getTotal() + "€.");
	}
	
	public void depositMoney (Account account) throws InputException, WritingException {
		int moneyToAdd = Integer.parseInt(_interface.askUser("How much would you like to deposit?", new IntegerInputChecker(0, Integer.MAX_VALUE)));
		account.addMoney(moneyToAdd);
		_interface.informUser("Your funds are now " + account.getTotal() + "€.");
		_fileLogger.info ("PROGRAM", "Account : " + account.getUserName() + " , age : "+ account.getUserAge() + " has been credited of" + account.getTotal() + "€.");
	}
	
	public void withdrawMoney (Account account) throws InputException, WritingException {
		int moneyToWithdraw = Integer.parseInt(_interface.askUser("How much would you like to withdraw?", new IntegerInputChecker(0, account.getTotal(), "You don't have enough money, you only have " + account.getTotal() + "€.")));
		account.withdrawMoney(moneyToWithdraw);
		_interface.informUser("Your funds are now " + account.getTotal() + "€.");
		_fileLogger.info ("PROGRAM", "Account : " + account.getUserName() + " , age : "+ account.getUserAge() + " has been credited of" + account.getTotal() + "€.");
	
	}
	
	public void manageLoans (Account account) throws RuleException, InputException, WritingException {
		int userChoice = Integer.parseInt(_interface.askUser("(Fill in with the option's number)\n1) See your loans\n2) Take a new loan", new IntegerInputChecker(1, 2)));
		switch (userChoice) {
			case 1 : {
				_interface.informUser("Here is your list of loans :\n");
				for(int i = 0; i < account.getLoans().size(); i++) {
					_interface.informUser("Amount : " + Integer.toString(account.getLoans().get(i).getAmount()));
					_interface.informUser("Rate : " + Double.toString(account.getLoans().get(i).getTaux()));
					_interface.informUser("Time : " + Integer.toString(account.getLoans().get(i).getTime()));

				}
			}
			case 2 : {
				_interface.checkUserPossibilities(new NumberOfLoansRuleChecker(account.getLoans().size()));
				int amount = Integer.parseInt(_interface.askUser("What amount do you need?", new IntegerInputChecker(0, Integer.MAX_VALUE)));
				double taux = Double.parseDouble(_interface.askUser("Which rate would you like?", new LoanTauxInputChecker()));
				int time = Integer.parseInt(_interface.askUser("On how many years would you like to refund?", new LoanTimeInputChecker(account.getUserAge())));
				double annuites = account.takeANewLoan(taux, amount, time);
				_interface.informUser("Your list of loans is now :\n" );
				for(int i = 0; i < account.getLoans().size(); i++) {
					_interface.informUser("Amount" + Integer.toString(account.getLoans().get(i).getAmount()));
					_interface.informUser("Rate : " + Double.toString(account.getLoans().get(i).getTaux()));
					_interface.informUser("Time : " + Integer.toString(account.getLoans().get(i).getTime()));
				}
				_interface.informUser("and you will have to refund " + annuites +"€ each year.");
				_fileLogger.info ("PROGRAM", "Account : " + account.getUserName() + " , age : "+ account.getUserAge() + " has a new loan of " + amount + "€, with a rate of " + taux + "and a time of : " + time);
			}
		}
	}
	
	//throws InputException & RuleException ?
	public void transferMoney (Account account) throws RuleException, InputException, WritingException {
		_interface.checkUserPossibilities(new NoOneToTransferTo(_accounts));
		_interface.informUser("Here is the list of our members :\n");
		for(int i = 0; i < _accounts.size(); i++) {
			_interface.informUser(_accounts.get(i).getUserName());
			_interface.informUser(Integer.toString(_accounts.get(i).getUserAge()));
		}
		String nameToTransfer = _interface.askUser("Who would you like to transfer money to?", new WrongNameInputChecker(_accounts));
		int ageToTransfer = Integer.parseInt(_interface.askUser("What is the age of the reciever", new WrongAgeInputChecker(_accounts)));
		int moneyToTransfer = Integer.parseInt(_interface.askUser("How much money would you like to transfer?", new IntegerInputChecker(0, account.getTotal())));
		account.withdrawMoney(moneyToTransfer);
		for(int i = 0; i < _accounts.size(); i++) {
			if (nameToTransfer.equals(_accounts.get(i).getUserName()) && ageToTransfer==_accounts.get(i).getUserAge()) {
				Account accountToTransfer = _accounts.get(i);
				accountToTransfer.addMoney(moneyToTransfer);
				_fileLogger.info ("PROGRAM", moneyToTransfer + "€ has been transfered from " + account.getUserName() + ", " + account.getUserAge() + " to " + accountToTransfer.getUserName() + ", " + accountToTransfer.getUserAge());
			}
		}
	}
	
}
