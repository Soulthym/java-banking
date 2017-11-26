package banking;

public class QuitProgramInputException implements InputChecker {

	@Override
	public void validate(String userInput) throws InputException {
		// TODO Auto-generated method stub
		if (!userInput.equals("c") && !userInput.equals("q")) {
			throw new InputException("Please choose between 'c' or 'q'.");
		}
	}
}
