package banking;

import banking.InputException;
import banking.QuitProgramInputException;
import logger.WritingException;

public class Launcher {

	public static void main (String [] args) throws InputException, WritingException {
		Program _program = new Program ();
		String running = "c";

		Account userAccount = _program.connexion();

		while (running.equals("c")) {
			Interface _interface = new Interface();
			_program.menu (userAccount);
			running = _interface.askUser("Would you like to continue (c) or to quit (q)?", new QuitProgramInputException());
			if (running.equals("q"))
				System.out.println("Good bye");
		}
	}

}
