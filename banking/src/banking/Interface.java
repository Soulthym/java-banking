package banking;

import java.util.Scanner;

import banking.InputChecker;
import banking.InputException;
import logger.ConsoleLogger;
import logger.FileLogger;
import logger.LoggerFactory;
import logger.WritingException;

public class Interface {

	private ConsoleLogger _consoleLogger;
	private FileLogger _fileLogger;
	private Scanner _scan;

	public Interface () throws WritingException {
		_consoleLogger = LoggerFactory.getConsoleLogger();
		_fileLogger = LoggerFactory.getFileLogger();
		_scan = new Scanner (System.in);
	}

	public String askUser (String message, InputChecker checker) throws WritingException {
		while (true) {
			try {
				_consoleLogger.info ("OUTPUT", message);
				_fileLogger.info ("OUTPUT", message);
				String input=_scan.next();
				checker.validate(input);
				_fileLogger.info ("INPUT", input);
				return input;
			}catch (InputException ie) {
				_consoleLogger.error("OUTPUT", ie.getMessage());
				_fileLogger.error ("OUTPUT", ie.getMessage());
			}
		}
	}

	public void informUser (String message) throws WritingException {
		_consoleLogger.info("OUTPUT", message);
		_fileLogger.info ("OUTPUT", message);

	}

}
