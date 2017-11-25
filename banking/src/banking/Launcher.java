package banking;

// import banking.InputException;
// import banking.QuitProgramInputException;
// import banking.RuleException;

public class Launcher {

	public static void main (String [] args) throws RuleException, InputException {
		Program _program = new Program ();
		Interface _interface = new Interface();

		Account userAccount = _program.connexion();
		String running = "c";
		while (running.equals("c")) {
			try {
				_program.menu (userAccount);
				running = _interface.askUser("Would you like to continue (c) or to quit (q)?", new QuitProgramInputException());
			}catch (RuleException re) {
				_interface.informUser("Please respect the bank's rules.");
			}
		}
	}

}
