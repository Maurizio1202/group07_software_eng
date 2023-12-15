package scientificCalculator;

import calculatorExceptions.*;
import java.util.Deque;

/**
 *
 * @author group_07
 * 
 * This class defines the data structure used to implement the calculator
 * and defines the operation on the stack of complex numbers performed by the user
 */

public class StackOperations {
    
    private Deque <ComplexNumber> stack;

    
    public StackOperations(Deque<ComplexNumber> stack) {
        
        this.stack = stack;
    }
    
    
    //Empties the stack
    
    public void clear(){
        
        stack.clear();
    }
    
    
    //Removes the last element from the stack. Throws EmptyStackException if
    //stack is empty
    
    public void drop(){
        
        if(stack.size() < 1)
            throw new EmptyStackException();
        
        stack.removeFirst();                                
    }
    
    
    //Gives a copy of the last element of the stack. Throws EmptyStackException if
    //stack is empty
    
    public void dup(){
        
        if(stack.size() < 1)
            throw new EmptyStackException();
        
        ComplexNumber n1 = stack.removeFirst();
        
        stack.addFirst(n1);
        stack.addFirst(n1);
        
    }
    
    
    //Swap the first two elements of the stack. Throws EmptyStackException if
    //there are less than two elements in the stack
    
    public void swap(){
        
        if(stack.size() < 2)
            throw new NotEnoughElementException(); 
        
        ComplexNumber n1 = stack.removeFirst();
        ComplexNumber n2 = stack.removeFirst();
        
        stack.addFirst(n1);
        stack.addFirst(n2);
   
    }
    
    
    //Gives a copy of the second-last element of the stack. Throws 
    //EmptyStackException if there are less than two elements in the stack
    
        public void over(){
            
        if(stack.size() < 2)
            throw new NotEnoughElementException(); 
        
        ComplexNumber n1 = stack.removeFirst();
        ComplexNumber n2 = stack.removeFirst();
        
            stack.addFirst(n2);
            stack.addFirst(n1);
            stack.addFirst(n2);
   
    } 
    
}
