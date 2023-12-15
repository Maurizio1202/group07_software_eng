package calculatorExceptions;

/**
 *
 * @author group_07
 */
public class DivideByZeroException extends RuntimeException{

    /**
     * Creates a new instance of <code>DivideByZeroException</code> without
     * detail message.
     */
    public DivideByZeroException() {
    }

    /**
     * Constructs an instance of <code>DivideByZeroException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public DivideByZeroException(String msg) {
        super(msg);
    }
}
