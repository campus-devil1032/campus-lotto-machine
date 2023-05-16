package exception;

public class InvalidateUserInput extends Throwable{
    public InvalidateUserInput() {
    }

    public InvalidateUserInput(String message) {
        super(message);
    }
}
