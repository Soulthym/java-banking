package banking;

import java.util.List;

// import banking.Account;

public class NoOneToTransferTo implements RuleChecker {

	private List <Account> _accounts;

	public NoOneToTransferTo(List <Account> accounts) {
		// TODO Auto-generated constructor stub
		_accounts = accounts;
	}

	@Override
	public void validate() throws RuleException {
		// TODO Auto-generated method stub
		if (_accounts.size() < 2) {
			throw new RuleException("There is no one in our data base to allow you to transfer money");
		}
	}

}
