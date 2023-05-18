package exception;

public class LackOfMoneyException extends Throwable {
    public LackOfMoneyException() {
    }

    public LackOfMoneyException(String message) {
        super(message);
    }
}

