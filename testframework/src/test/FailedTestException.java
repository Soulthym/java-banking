package test;

public class FailedTestException extends Exception {
    public FailedTestException() {}
    public FailedTestException(String message) {
        super(message);
    }
}
