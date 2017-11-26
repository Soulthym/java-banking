package banking;

public class LoanTimeInputChecker implements InputChecker {

	private int _userAge;


	public LoanTimeInputChecker (int userAge) {
		_userAge = userAge;
	}

	@Override
	public void validate(String userInput) throws InputException {
		// TODO Auto-generated method stub
		try {
			int time = Integer.parseInt(userInput);
			if ((time+_userAge) > 70) {
				throw new InputException("Your time is to high, you will be over 70 y.o before refunding.");
			}
		}catch (NumberFormatException nfe) {
			throw new InputException("Please write a number for your time.");
		}
	}

}
