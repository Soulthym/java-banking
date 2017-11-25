package banking;

public class RuleException extends Exception {

	private String _message;

	public RuleException (String message) {
		_message = message;
	}

	public String getMessage () {
		return _message;
	}
}
