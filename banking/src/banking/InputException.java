package banking;

public class InputException extends Exception {

	private String _message;

	public InputException (String message) {
		_message = message;
	}

	public String getMessage () {
		return _message;
	}
}
