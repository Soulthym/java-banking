package _logger;

public class WritingException extends Exception {

	private String message;
	public WritingException(String message) {
		this.message=message;
	}
	public String getMessage() {
		return this.message;
	}
	
}
