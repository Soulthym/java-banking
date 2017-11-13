package org.bank;

import org.check.InputException;
import org.check.QuitProgramInputException;

public class Launcher {

	private Interface _interface;

	public Launcher() {
		_interface = new Interface();
	}
	
	public void launchProgram () {
		boolean running = true;
		while(running) {
			//try {
				String userChoice = _interface.askUser("Would you like to go on our site?", new QuitProgramInputException());
			//}catch (InputException ie) {
				//running = false;
			//}
		}
	}
	
	//TODO lancer Program et quitter quand demande par l utilisateur
	
}
