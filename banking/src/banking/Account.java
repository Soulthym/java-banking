package banking;

import java.util.ArrayList;
import java.util.List;

import banking.InputException;

public class Account {

	private User _user;
	private int _total;
	private List <Loan> _loans;

	public Account (String userName, int userAge) {
		_user = new User (userName, userAge);
		_total = 0;
		_loans = new ArrayList <Loan> ();
		//TODO afficher : vous avez desormais un compte chez nous
	}

	public int getTotal() {
		return _total;
	}


	public String getUserName() {
		return _user.getName();
	}


	public int getUserAge() {
		return _user.getAge();
	}

	public List<Loan> getLoans() {
		//retourner 0 si nul ou cca fonctionne comme ca
		return _loans;
	}

	public void addMoney (int moneyToAdd) throws InputException {
		_total += moneyToAdd;
	}

	public void withdrawMoney (int moneyToWithdraw) throws InputException {
		_total -= moneyToWithdraw;
	}

	public void takeANewLoan (double taux, int amount, int time) {
		Loan loan = new Loan (taux, amount, time);
		_loans.add(loan);
	}

}
