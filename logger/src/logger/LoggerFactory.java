package logger;

public class LoggerFactory {
	public static Logger getLogger() {
		return new ConsoleLogger();
	}
}