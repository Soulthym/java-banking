package banking;

public class LitteralInputChecker implements InputChecker {

	@Override
	public void validate(String userInput) throws InputException {
		// TODO Auto-generated method stub
		for (char c : userInput.toCharArray()) {
			if (Character.isDigit(c)) {
				throw new InputException("This is not a string but a number.");
			}
		}
	}

}
