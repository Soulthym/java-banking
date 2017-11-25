package banking;

public class IntegerInputChecker implements InputChecker {

	private int _minimum;
	private int _maximum;
	private String _errorMessage;

	public IntegerInputChecker(int minimum, int maximum, String errorMessage) {
		_minimum = minimum;
		_maximum = maximum;
		_errorMessage = errorMessage;
	}

	public IntegerInputChecker(int minimum, int maximum) {
		this (minimum, maximum, "You put a wrong number.");
	}

	@Override
	public void validate(String userInput) throws InputException {
		// TODO Auto-generated method stub
		try {
			int value = Integer.parseInt(userInput);
			if (value < _minimum || value > _maximum) {
				throw new InputException (_errorMessage);
			}
		}catch (NumberFormatException nfe) {
			throw new InputException ("You did not put a number.");
		}
	}

}
