package _logger;

public class LoggerFactory {
	
	public static ConsoleLogger getConsoleLogger() {
		ConsoleLogger console_logger = new ConsoleLogger();
		return console_logger;
	}
	
	public static FileLogger getFileLogger(String category, String message) {
		FileLogger file_logger = new FileLogger();
		return file_logger;
	}
}
