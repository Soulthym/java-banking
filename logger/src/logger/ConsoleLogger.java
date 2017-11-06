package logger;

public class ConsoleLogger implements Logger {
	public void info (String message) {
		System.out.println("Info : " + message);
	}
	public void error (String message) {
		System.out.println("Error : " + message);
	}
}