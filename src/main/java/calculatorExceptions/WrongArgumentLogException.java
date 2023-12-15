package calculatorExceptions;

/**
 *
 * @author group_07
 */
public class WrongArgumentLogException extends RuntimeException{

    /**
     * Creates a new instance of <code>WrongArgumentLogException</code> without
     * detail message.
     */
    public WrongArgumentLogException() {
    }

    /**
     * Constructs an instance of <code>WrongArgumentLogException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public WrongArgumentLogException(String msg) {
        super(msg);
    }
}
