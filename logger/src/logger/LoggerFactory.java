package _logger;

public class LoggerFactory {
	
	//Creation d'un logger qui ecrit dans la console
	public static ConsoleLogger getConsoleLogger() {
		ConsoleLogger console_logger = new ConsoleLogger();
		return console_logger;
	}
	
	//Creation d'un logger qui ecrit dans un fichier.
	public static FileLogger getFileLogger() throws WritingException {
		FileLogger file_logger = new FileLogger();
		return file_logger;
	}
}
