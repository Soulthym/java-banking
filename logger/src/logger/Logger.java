package logger;

public interface Logger {

	void info(String category, String message) throws WritingException;
	void error(String category, String message)throws WritingException;

}
