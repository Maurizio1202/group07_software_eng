package calculatorExceptions;

/**
 *
 * @author group_07
 */
public class NullArgumentsException extends RuntimeException{

    /**
     * Creates a new instance of <code>NullArgumentsException</code> without
     * detail message.
     */
    public NullArgumentsException() {
    }

    /**
     * Constructs an instance of <code>NullArgumentsException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public NullArgumentsException(String msg) {
        super(msg);
    }
}
