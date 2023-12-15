package calculatorExceptions;

/**
 *
 * @author group_07
 */
public class ScientificCalculatorException extends RuntimeException{

    /**
     * Creates a new instance of <code>ScientificCalculatorException</code>
     * without detail message.
     */
    public ScientificCalculatorException() {
    }

    /**
     * Constructs an instance of <code>ScientificCalculatorException</code> with
     * the specified detail message.
     *
     * @param msg the detail message.
     */
    public ScientificCalculatorException(String msg) {
        super(msg);
    }
}
