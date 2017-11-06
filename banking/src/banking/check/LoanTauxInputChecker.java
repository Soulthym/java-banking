package org.check;

public class LoanTauxInputChecker implements InputChecker{
	
	@Override
	public void validate(String userInput) throws InputException {
		// TODO Auto-generated method stub
		try {
			double taux = Double.parseDouble(userInput);
			if (taux < 0.01) {
				throw new InputException("Your taux has to be more than 0.01.");
			}
		}catch (NumberFormatException nfe) {
			throw new InputException("Please write a number for you taux.");
		}
	}
	
	
}
