package org.logger;

public class SystemLogger implements Logger {

	@Override
	public void info(String category, String message) {
		// TODO Auto-generated method stub
		System.out.println(category+message);
	}

	@Override
	public void error(String category, String message) {
		// TODO Auto-generated method stub
		System.out.println(category+message);
	}
	
	
}
