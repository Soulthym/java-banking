package banking;

public class NumberOfLoansRuleChecker implements RuleChecker{

	private int _numberOfLoans;

	public NumberOfLoansRuleChecker (int userNumberOfLoans) {
		_numberOfLoans = userNumberOfLoans;
	}

	@Override
	public void validate () throws RuleException {
		if (_numberOfLoans > 1) {
			throw new RuleException("You already have two loans, you can't take another one.");
			//Cest bon ou faut que je recupere la confiraton que ca marche?
		}
	}
}
