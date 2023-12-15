package scientificCalculator;

import calculatorExceptions.ScientificCalculatorException;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 *
 * @author group_07
 */

public class ScientificCalculator {
    
   private MathematicalOperations mathOp;
    private StackOperations stackOp;
    private VariableOperations varOp;
    

    public ScientificCalculator(Deque<ComplexNumber> stack) {
        mathOp = new MathematicalOperations(stack);
        stackOp = new StackOperations(stack);
        varOp = new VariableOperations(stack);
    }
    
    
    
//     The isComplex method returns true if the string is a complex operand
//     Does not accept Strings of the the following types: isOnlyJPart, 
//     isImaginary. Returns true with real numbers (12, +14, -15.2...) 
    private boolean isComplex(String s) {                   
        return s.matches("^(?=[j.\\d+-])([+-]?(?:\\d+(?:\\.\\d*)?|\\.\\d+)(?![j.\\d]))([+-]?(?:(?:\\d+(?:\\.\\d*)?|\\.\\d+))?[j])?$");
    }

 
//    Returns true if the string is a pure complex number
//    Format accepted sign+number+j (j, -2j, 2j, +1j, -1j)
//    Does not accept "j", "+j", "-j"
    private boolean isImaginary(String s) {                
        return s.matches("^[+-]?(?:\\d+(?:\\.\\d*)?|\\.\\d+)[j]$");
    }

    /**
     * Returns true only if the string is "j","+j","-j"
     */
    private boolean isOnlyJPart(String s) {         
        return s.matches("^(?=[j])?([+-]?[j])$");
    }


//     Used to separate the input string in tokens that are
//     complex numbers or operators. This method calls each method of
//     the class ComplexNumOperation to calculate basic operations, each method
//     of the class StackManipulation, each method of the class Variables.
//     It calls the InterpreterException if there are wrong operators or wrong operands 
//     It calls the ZeroDivisionException if there is a division by 0
//     @param s is the content of the text field (display)
    public void parse(String s) {
        
        StringTokenizer ops = new StringTokenizer(s, " ");
        
        while (ops.hasMoreTokens()) {
            String op = ops.nextToken();
            ComplexNumber c = new ComplexNumber(0,0);                         
            if(isOnlyJPart(op)){
                c.convertToComplexOnlyJ(op);
                mathOp.insertion(c);
            }
            else if(isImaginary(op)){
                c.convertToComplexOnlyImg(op);
                mathOp.insertion(c);
            }
            else if(isComplex(op)){
                c.convertToComplex(op);
                mathOp.insertion(c);
            }
            else if (op.equals("+")) {
                mathOp.sum();
            } else if (op.equals("-")) {
                mathOp.sub();
            } else if (op.equals("x") || op.equals("*")) {
                mathOp.product();
            } else if (op.equals("÷") || op.equals("/")) {
                mathOp.division();
            } else if (op.equals("(-)")) {
                mathOp.signReversal();
            } else if (op.equals("√") || op.equals("sqrt")) {
                mathOp.squareRoot();
            } else if (op.equals("sin")) {
                mathOp.sin();
            } else if (op.equals("cos")) {
                mathOp.cos();
            } else if (op.equals("tan")) {
                mathOp.tan();
            } else if (op.equals("ln")) {
                mathOp.ln();
            } else if (op.equals("log")) {
                mathOp.log();
            } else if (op.equals("exp")) {
                mathOp.exp();
            } else if (op.equals("clear")){
                stackOp.clear();
            }else if (op.equals("dup")) {
                stackOp.dup();
            } else if (op.equals("drop")) {
                stackOp.drop();
            } else if (op.equals("over")) {
                stackOp.over();
            } else if (op.equals("swap")) {
                stackOp.swap();
            } else if (op.length() == 2 && op.charAt(0) == '>') {
                varOp.assignToVar(op.charAt(1));
            } else if (op.length() == 2 && op.charAt(0) == '<') {
                varOp.copyFromVar(op.charAt(1));
            } else if (op.length() == 2 && op.charAt(0) == '+') {
                varOp.sumToVar(op.charAt(1));
            } else if (op.length() == 2 && op.charAt(0) == '-') {
                varOp.subtractToVar(op.charAt(1));
            }
            else{
                throw new ScientificCalculatorException();
            }
        }

    }
}
    
