package org.bank;

import java.util.Scanner;

import org.check.InputChecker;
import org.check.InputException;
import org.check.RuleChecker;
import org.check.RuleException;
import org.logger.ConsoleLogger;
import org.logger.FileLogger;
import org.logger.LoggerFactory;
import org.logger.WritingException;

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
	
	public void checkUserPossibilities (RuleChecker checker) throws WritingException {
		try {
			checker.validate();
		}catch (RuleException re) {
			_consoleLogger.error("OUTPUT", re.getMessage());
			_fileLogger.error ("OUTPUT", re.getMessage());
		}
	}
}
