package scientificCalculator;

import calculatorExceptions.EmptyStackException;
import java.util.Deque;
import java.util.LinkedList;
import calculatorExceptions.VarOutOfRangeException;
import calculatorExceptions.NullArgumentsException;

/*
 *
 * @author group_07
 *
 * This class manages the variables and 
 * defines the operations on the variables
 * 
 */

public class VariableOperations {
    
    private Deque<ComplexNumber> stack;
    private LinkedList<ComplexNumber> stackVar;

    
    public VariableOperations(Deque<ComplexNumber> stack) {
        this.stack = stack;
        stackVar = new LinkedList<>();
        for (int i = 0; i < 26; i++) {
            stackVar.add(null);
        }
    }

    
//    Gives at every varaible its position in stackVar. 
//    Throws VarOutOfRangeException if the variable is not contained in [a,..., z]
    private int charToCode(char var) {
        
        if (var < 'a' || var > 'z') {
            throw new VarOutOfRangeException();
        }
        return (int) var - 97;
    }
    
    
//    Takes a ComplexNumber from the top of the stack and assign it to a variable (>X).
//    Throws VarOutOfRangeException if the variable is not contained in [a,..., z]
//    Throws EmptyStackException if the stack is empty
    public void assignToVar(char var){
        
         if(stack.isEmpty()){
             throw new EmptyStackException();
         }
         if(var<'a'&&var>'z'){
             throw new VarOutOfRangeException();
         }
         int pos = charToCode(var);
         
         stackVar.set(pos, stack.removeFirst());
    } 
    
    
//    Copies the value of a variable and push it onto the stack.  (<X)
//    Throws VarOutOfRangeException if the variable is not contained in [a.... z]
//    Throws NullArgumentsException if the val is null 

    public void copyFromVar(char var) {
        
        if(var<'a'&&var>'z'){
             throw new VarOutOfRangeException();
        }
        int pos = charToCode(var);
        
        ComplexNumber val = stackVar.get(pos);
        if (val == null) {
            throw new NullArgumentsException();
        }
        
        stack.addFirst(new ComplexNumber(val.getRealPart(), val.getImgPart()));
    }
    


//     Takes a complex number from the stack and sum it to the variable
//     value and save the result into the variable itself. 
//     Throws VarOutOfRangeException if the variable is not contained in [a, ... z]
//     Throws EmptyStackException if the stack is empty

    public void sumToVar(char var) {
        
        if(var<'a'&&var>'z'){
             throw new VarOutOfRangeException();
        }
        
        if(stack.size() < 1)
            throw new EmptyStackException();
        
        int pos = charToCode(var);

        ComplexNumber val = stackVar.get(pos);
        if (val == null) {
            throw new NullArgumentsException();
        }
        ComplexNumber stackElem = stack.removeFirst();
        stackVar.set(pos, add(stackElem, val));

    }
    
    
//     Takes a ComplexNumber from the top of the stack and subtract it to the
//     variable value and save the result into the variable itself. 
//     ThrowsVarOutOfRangeException if the variable is not contained in [a,..., z]
//     Throws EmptyStackException if the stack is empty
    public void subtractToVar(char var) {
        
        if(var<'a'&&var>'z'){
             throw new VarOutOfRangeException();
        }
        
        if(stack.size() < 1)
            throw new EmptyStackException();
        
        int pos = charToCode(var);

        ComplexNumber val = stackVar.get(pos);
        if (val == null) {
            throw new NullArgumentsException();
        }
        
        ComplexNumber stackElem = stack.removeFirst();
        stackVar.set(pos, sub(stackElem, val) );

    }
    
    
    //Takes two ComplexNumbers and returns their subtraction
    private ComplexNumber sub(ComplexNumber z1, ComplexNumber z2){
        
        double re = z2.getRealPart() - z1.getRealPart();
        double im = z2.getImgPart() - z1.getImgPart();
        
        return new ComplexNumber(re, im);
        
    }
    
    
    //Takes two ComplexNumbers and returns their sum
    private ComplexNumber add(ComplexNumber z1, ComplexNumber z2){
        
        double re = z1.getRealPart() + z2.getRealPart();
        double im = z1.getImgPart() + z2.getImgPart();
        
        return new ComplexNumber(re, im);
        
    }
    
    
    
    
    
}