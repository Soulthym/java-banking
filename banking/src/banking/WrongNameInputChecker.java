package org.check;

import java.util.List;

import org.bank.Account;

public class WrongNameInputChecker implements InputChecker {
	
	private List <Account> _accounts;

	public WrongNameInputChecker(List <Account> accounts) {
		_accounts = accounts;
	}


	@Override
	public void validate(String userInput) throws InputException {
		// TODO Auto-generated method stub
		for(int i = 0; i < _accounts.size(); i++) {
			if (!userInput.equals(_accounts.get(i).getUserName())) {
				throw new InputException ("This person is not a member of our bank");
			}
		}
	}

}
