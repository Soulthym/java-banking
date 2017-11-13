package org.check;

public class QuitProgramInputException implements InputChecker {

	@Override
	public void validate(String userInput) throws InputException {
		// TODO Auto-generated method stub
		if (userInput.equals("q")) {
			throw new InputException("You chose to quit our bank site.");
		}
	}
}
