package banking;

import java.util.List;

// import banking.Account;

public class NoOneInDataBase implements RuleChecker {

	private List <Account> _accounts;

	public NoOneInDataBase(List <Account> accounts) {
		// TODO Auto-generated constructor stub
		_accounts = accounts;
	}

	@Override
	public void validate() throws RuleException {
		// TODO Auto-generated method stub
		if (_accounts.isEmpty()) {
			throw new RuleException ("There is no one in our data base.");
		}

	}
}
