package logger;

public class Launcher {
	public static void main(String[] args) throws WritingException {
		ConsoleLogger mon_logger = LoggerFactory.getConsoleLogger();
		mon_logger.info("OUTPUT", "Hello World");
		FileLogger mon_file_logger = LoggerFactory.getFileLogger();
		mon_file_logger.info("OUTPUT", "Second test...");
	}
}
