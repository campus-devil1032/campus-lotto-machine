package exception;

public class IllegalMoneyException extends Throwable {
    public IllegalMoneyException() {
    }

    public IllegalMoneyException(String message) {
        super(message);
    }
}
