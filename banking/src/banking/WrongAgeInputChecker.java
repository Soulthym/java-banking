package banking;

import java.util.List;

import banking.Account;

public class WrongAgeInputChecker implements InputChecker {

	private List <Account> _accounts;
	private String _name;

	public WrongAgeInputChecker(List <Account> accounts, String name) {
		_accounts = accounts;
		_name = name;
	}


	@Override
	public void validate(String userInput) throws InputException {
		// TODO Auto-generated method stub
		try {
			int ageToTransfer = Integer.parseInt(userInput);
			int found = 0;
			for(int i = 0; i < _accounts.size(); i++) {
				if (_name.equals(_accounts.get(i).getUserName()) && ageToTransfer==_accounts.get(i).getUserAge()) {
					found = 1;
				}
			}
			if (found == 0) {
				throw new InputException("The age doesn't match with the name you gave. This person isn't in our data base.");
			}
		}catch (NumberFormatException nfe) {
			throw new InputException("You did not put a number.");
		}
	}

}
