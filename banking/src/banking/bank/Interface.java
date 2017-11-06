package org.bank;

import java.util.Scanner;

import org.check.InputChecker;
import org.check.InputException;
import org.check.RuleChecker;
import org.check.RuleException;
import org.logger.Logger;
import org.logger.SystemLogger;

public class Interface {
	
	private Logger _logger; //instancier le logger avec la methode du prof
	private Scanner _scan;
	
	public Interface () {
		_logger = new SystemLogger();
		_scan = new Scanner (System.in);
	}
	
	public String askUser (String message, InputChecker checker) {
		while (true) {
			try {
				_logger.info ("OUTPUT", message);
				String input=_scan.next();
				checker.validate(input);
				return input;
			}catch (InputException ie) {
				_logger.error("OUTPUT", ie.getMessage());
			}
		}
	}
	
	public void informUser (String message) {
		_logger.info("OUTPUT", message);
	}
	
	public void checkUserPossibilities (RuleChecker checker) {
		try {
			checker.validate();
		}catch (RuleException re) {
			_logger.error("OUTPUT", re.getMessage());
		}
	}
}
