package banking;

import java.util.List;

import banking.Account;
import banking.User;

public class AlreadyExistingAccountInputChecker implements RuleChecker {

	private List <Account> _accounts;
	private String _userName;
	private int _userAge;

	public AlreadyExistingAccountInputChecker(List <Account> accounts, String name, int age) {
		_accounts = accounts;
		_userName = name;
		_userAge = age;
	}

	@Override
	public void validate() throws RuleException {
		// TODO Auto-generated method stub
		if (!_accounts.isEmpty()) {
			for (Account account : _accounts) {
				if (_userName.equals(account.getUserName()) && _userAge==account.getUserAge()) {
					throw new RuleException("This account already exist in your base.");
				}
			}
		}
	}

}
