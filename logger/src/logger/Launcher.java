package _logger;

public class Launcher {
	public static void main(String args) {
		ConsoleLogger mon_logger = LoggerFactory.getConsoleLogger();
		mon_logger.info("OUTPUT", "Hello World");
	}
}
