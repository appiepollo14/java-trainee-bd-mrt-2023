package nl.avasten.H4.hourglass;

public class EvenNumberException extends Throwable {

    private String message;

    public EvenNumberException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
