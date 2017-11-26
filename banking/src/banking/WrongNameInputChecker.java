package banking;

import java.util.List;

import banking.Account;

public class WrongNameInputChecker implements InputChecker {

	private List <Account> _accounts;

	public WrongNameInputChecker(List <Account> accounts) {
		_accounts = accounts;
	}


	@Override
	public void validate(String userInput) throws InputException {
		// TODO Auto-generated method stub
		int found = 0;
		for(int i = 0; i < _accounts.size(); i++) {
			if (userInput.equals(_accounts.get(i).getUserName())) {
				found = 1;
			}
		}
		if (found==0) {
			throw new InputException ("This person is not a member of our bank");
		}
	}

}
