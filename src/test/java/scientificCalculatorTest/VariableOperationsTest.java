package scientificCalculatorTest;

import calculatorExceptions.EmptyStackException;
import calculatorExceptions.NullArgumentsException;
import calculatorExceptions.VarOutOfRangeException;
import java.util.Deque;
import java.util.LinkedList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import scientificCalculator.ComplexNumber;
import scientificCalculator.VariableOperations;

/**
 *
 * @author group_07
 */
public class VariableOperationsTest {
    
    private Deque<ComplexNumber> stack;
    private VariableOperations varStack;
    
    public VariableOperationsTest() {
    }

    /**
     * Test of assignToVar method, of class VariableOperations.
     */
    
    
    @BeforeEach
    public void setUp(){
        stack = new LinkedList<>();
        varStack = new VariableOperations(stack);
    }
    
    @Test
    public void testAssignToVar1() {
        System.out.println("Testing AssignToVar method");
        ComplexNumber c1 = new ComplexNumber(3, 3);
        ComplexNumber c2 = new ComplexNumber(3, 5);
        stack.addFirst(c1);
        stack.addFirst(c2);
        int s1 = stack.size();
        varStack.assignToVar('x');

        // Checking stack size and if c2 has effectively been removed from stack 
        assertEquals(s1 - 1, stack.size());
        assertEquals(c1, stack.peekFirst());

        // Checking if c2 has effectively been assigned to varStack
        varStack.copyFromVar('x');
        assertEquals(c2, stack.peekFirst());
    }
    
    
    /* Testing assignToVar method, in a case that all the numbers in the stack 
    * will be saved in a variable, and then go back in the stack. 
    */
    @Test
    public void testAssignToVar2() {
        System.out.println("Testing AssignToVar method");
        ComplexNumber c1 = new ComplexNumber(3, 7);
        ComplexNumber c2 = new ComplexNumber(6, 99);
        stack.addFirst(c1);
        stack.addFirst(c2);
        int s1 = stack.size();
        varStack.assignToVar('x');
        assertEquals(s1 - 1, stack.size());
        assertEquals(c1, stack.peekFirst());
        varStack.assignToVar('y');
        assertEquals(0, stack.size());
        assertEquals(null, stack.peekFirst());
        varStack.copyFromVar('x');
        assertEquals(c2, stack.peekFirst());
        varStack.copyFromVar('y');
        assertEquals(c1, stack.peekFirst());
    }
    /*
    * Test assignToVar method, all the variables all variables are initialized
    */
    @Test
    public void testAssignToVar3() {
        System.out.println("Testing AssignToVar method");
        for (int i = 0; i < 26; i++) {
            stack.addFirst(new ComplexNumber(3,6));
        }

        for (char car = 'a'; car <= 'z'; car++) {
            varStack.assignToVar(car);
        }

        assertEquals(0, stack.size());

        for (char car = 'a'; car <= 'z'; car++) {
            varStack.copyFromVar(car);
        }

        assertEquals(26, stack.size());

        for (int i = 0; i < 26; i++) {
            assertEquals(new ComplexNumber(3,6), stack.removeFirst());
        }
    }
    
    //Test Fail if the stack is Empty but the input is correct 
    @Test 
    public void assignToVarFail1(){
        System.out.println("Testing AssignToVar method in case of Exception");
        assertThrows(EmptyStackException.class, () -> {
            varStack.assignToVar('x');
        });
        
    }
    
    //Test Fail if the user put a variable not accepted but there are numbers in the stack  
    @Test 
    public void assignToVarFail2(){
        System.out.println("Testing AssignToVar method in case of Exception");
        ComplexNumber c1 = new ComplexNumber(3, 7);
        ComplexNumber c2 = new ComplexNumber(6, 99);
        stack.addFirst(c1);
        stack.addFirst(c2);
        assertThrows(VarOutOfRangeException.class, () -> {
            varStack.assignToVar(',');
        });
        
    }
    
    //Test Fail if the user put a variable not accepted but there are numbers in the stack  
    @Test 
    public void assignToVarFail3(){
        System.out.println("Testing AssignToVar method in case of Exception");
        ComplexNumber c1 = new ComplexNumber(3, 7);
        ComplexNumber c2 = new ComplexNumber(6, 99);
        stack.addFirst(c1);
        stack.addFirst(c2);
        assertThrows(VarOutOfRangeException.class, () -> {
            varStack.assignToVar('X');
        });
        
    }
    //Test Fail if the user put a variable that seems correct, like 'ù'  
    @Test 
    public void assignToVarFail4(){
        System.out.println("Testing AssignToVar method in case of Exception");
        ComplexNumber c1 = new ComplexNumber(3, 7);
        ComplexNumber c2 = new ComplexNumber(6, 99);
        stack.addFirst(c1);
        stack.addFirst(c2);
        assertThrows(VarOutOfRangeException.class, () -> {
            varStack.assignToVar('ù');
        });
        
    }
    
    //Test Fail if the user put as variable s number  
    @Test 
    public void assignToVarFail5(){
        System.out.println("Testing AssignToVar method in case of Exception");
        ComplexNumber c1 = new ComplexNumber(3, 7);
        ComplexNumber c2 = new ComplexNumber(6, 99);
        stack.addFirst(c1);
        stack.addFirst(c2);
        assertThrows(VarOutOfRangeException.class, () -> {
            varStack.assignToVar('5');
        });
        
    }
    /**
     * Test of copyFromVar method.
     */
    @Test
    public void testCopyFromVar() {
        System.out.println("Testing CopyFromVar method");
        ComplexNumber c1 = new ComplexNumber(4,5);
        ComplexNumber c2 = new ComplexNumber(6,7);
        stack.addFirst(c1);
        stack.addFirst(c2);
        varStack.assignToVar('x');
        int s = stack.size();
        varStack.copyFromVar('x');
        assertEquals(s+1,stack.size());
        assertEquals(c2,stack.peekFirst());
        
    }
    /*
    * Test copyFromVar method in case more then one variable is saved in the stack
    */
    @Test
    public void testcopyFromVar2() {
        System.out.println("Testing CopyFromVar method");
        ComplexNumber c1 = new ComplexNumber(4,5);
        ComplexNumber c2 = new ComplexNumber(6,7);
        stack.addFirst(c1);
        stack.addFirst(c2);
        varStack.assignToVar('x');
        varStack.assignToVar('y');
        int s = stack.size();
        varStack.copyFromVar('x');
        assertEquals(s+1,stack.size());
        assertEquals(c2,stack.peekFirst());
        varStack.copyFromVar('y');
        assertEquals(s+2,stack.size());
        assertEquals(c1,stack.peekFirst());
    }
    // Test that Fail if the variable passed is without a value 
    @Test 
    public void copyFromVarFail1(){
        System.out.println("Testing CopyFromVar method in case of Exception");
        assertThrows(NullArgumentsException.class, () -> {
            varStack.copyFromVar('x');
        });
    }
    
    // Test that Fail if the variable passed is out of range [a..z]
    @Test 
    public void copyFromVarFail2(){
        System.out.println("Testing CopyFromVar method in case of Exception");
        assertThrows(VarOutOfRangeException.class, () -> {
            varStack.copyFromVar('è');
        });
    }
    
    //Test Fail if the user put a variable not accepted but there is a value in the char  
    @Test 
    public void copyFromVarFail3(){
        System.out.println("Testing CopyFromVar method in case of Exception");
        ComplexNumber c1 = new ComplexNumber(4,5);
        stack.addFirst(c1);
        varStack.assignToVar('x');
        assertThrows(VarOutOfRangeException.class, () -> {
            varStack.copyFromVar('X');
        });   
    }
    

    /**
     * Test of sumToVar method, with one number in the stack.
     */
    @Test
    public void testSumToVar1() {
        System.out.println("Testing SumToVar method");
        ComplexNumber c1 = new ComplexNumber(55,66);
        stack.addFirst(c1);
        ComplexNumber c2 = new ComplexNumber(77,88);
        stack.addFirst(c2);
        varStack.assignToVar('x');
        int s = stack.size();
        varStack.sumToVar('x');
        // Need assertEquals because we have to check if the command stack.removeFirst() works correctly
        assertEquals(s-1,stack.size());
        
        
    }
    
    /**
     * Test of sumToVar method, with two numbers in the stack.
     */
    @Test
    public void testSumToVar2() {
        System.out.println("Testing SumToVar method");
        ComplexNumber c1 = new ComplexNumber(55,66);
        stack.addFirst(c1);
        ComplexNumber c2 = new ComplexNumber(77,88);
        stack.addFirst(c2);
        ComplexNumber c3 = new ComplexNumber(99,1);
        stack.addFirst(c3);
        varStack.assignToVar('x');
        int s = stack.size();
        varStack.sumToVar('x');
        // Need assertEquals because we have to check if the command stack.removeFirst() works correctly
        assertEquals(s-1,stack.size());
    }
    
    // Test Fail in case the user gives a value to the variable but there are enough element in the stack for the sum    
    @Test 
    public void sumToVarFail1(){
        System.out.println("Testing SumToVar method in case of Exception");
        ComplexNumber c1 = new ComplexNumber(55,66);
        stack.addFirst(c1);
        varStack.assignToVar('x');
        assertThrows(EmptyStackException.class, () -> {
            varStack.sumToVar('x');
        });
    }
    
    // Test Fail in case the user gives a variable out of the range [a..z]    
    @Test 
    public void sumToVarFail2(){
        System.out.println("Testing SumToVar method in case of Exception");
        ComplexNumber c1 = new ComplexNumber(55,66);
        ComplexNumber c2 = new ComplexNumber(55,77);
        stack.addFirst(c1);
        stack.addFirst(c2);
        assertThrows(VarOutOfRangeException.class, () -> {
            varStack.sumToVar('S');
        });
    }
    
    // Test Fail in case the user gives a correct variable but this one is not initialized    
    @Test 
    public void sumToVarFail3(){
        System.out.println("Testing SumToVar method in case of Exception");
        ComplexNumber c1 = new ComplexNumber(55,66);
        ComplexNumber c2 = new ComplexNumber(33,77);
        stack.addFirst(c1);
        stack.addFirst(c2);
        assertThrows(NullArgumentsException.class, () -> {
            varStack.sumToVar('x');
        });
    }
    
    

    /**
     * Test of subtractToVar method, of class VariableOperations.
     */
    @Test
    public void testSubtractToVar1() {
        System.out.println("Testing SubtractToVar method");
        ComplexNumber c1 = new ComplexNumber(55,66);
        stack.addFirst(c1);
        ComplexNumber c2 = new ComplexNumber(77,88);
        stack.addFirst(c2);
        varStack.assignToVar('x');
        int s = stack.size();
        varStack.subtractToVar('x');
        // Need assertEquals because we have to check if the command stack.removeFirst() works correctly
        assertEquals(s-1,stack.size());
        
    }
    
    //Test
    @Test
    public void testSubtractToVar2() {
        System.out.println("Testing SubtractToVar method");
        ComplexNumber c1 = new ComplexNumber(55,66);
        stack.addFirst(c1);
        ComplexNumber c2 = new ComplexNumber(77,88);
        stack.addFirst(c2);
        ComplexNumber c3 = new ComplexNumber(99,1);
        stack.addFirst(c3);
        varStack.assignToVar('x');
        int s = stack.size();
        varStack.subtractToVar('x');
        // Need assertEquals because we have to check if the command stack.removeFirst() works correctly
        assertEquals(s-1,stack.size());
    }
    // Test Fail in case the user gives a value to the variable but there are enough element in the stack for the sum    
    @Test 
    public void subtractToVarFail1(){
        System.out.println("Testing SubtractToVar method in case of Exception");
        ComplexNumber c1 = new ComplexNumber(55,66);
        stack.addFirst(c1);
        varStack.assignToVar('x');
        assertThrows(EmptyStackException.class, () -> {
            varStack.subtractToVar('x');
        });
    }
    
    @Test 
    public void subtractToVarFail2(){
        System.out.println("Testing SubtractToVar method in case of Exception");
        ComplexNumber c1 = new ComplexNumber(55,66);
        ComplexNumber c2 = new ComplexNumber(55,77);
        stack.addFirst(c1);
        stack.addFirst(c2);
        assertThrows(VarOutOfRangeException.class, () -> {
            varStack.subtractToVar('S');
        });
    }
    
}