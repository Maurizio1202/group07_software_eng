package calculatorExceptions;

/**
 *
 * @author group_07
 */
public class NotEnoughElementException extends RuntimeException{

    /**
     * Creates a new instance of <code>NotEnoughElementException</code> without
     * detail message.
     */
    public NotEnoughElementException() {
    }

    /**
     * Constructs an instance of <code>NotEnoughElementException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public NotEnoughElementException(String msg) {
        super(msg);
    }
}
