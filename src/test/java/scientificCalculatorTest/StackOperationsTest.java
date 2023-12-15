package scientificCalculatorTest;

import java.util.Deque;
import calculatorExceptions.EmptyStackException;
import calculatorExceptions.NotEnoughElementException;
import java.util.LinkedList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import scientificCalculator.ComplexNumber;
import scientificCalculator.StackOperations;

/**
 *
 * @author group_07
 */
public class StackOperationsTest {
    
    private Deque<ComplexNumber> stack;
    private StackOperations s;
    
    public StackOperationsTest() {
    }

    /**
     * Test of clear method, of class StackOperations.
     */
    
    @BeforeEach
    public void setUp() {
        stack = new LinkedList<>();
        s = new StackOperations(stack);
    }
    
    
    @Test
    public void testClear1() {
        System.out.println("Testing Clear method");
        s.clear();
        assertEquals(true, stack.isEmpty());
    }
    
    @Test
    public void testClear2() {
        System.out.println("Testing Clear method");
        ComplexNumber c1 = new ComplexNumber(10, 8);
        ComplexNumber c2 = new ComplexNumber(7, 1);
        ComplexNumber c3 = new ComplexNumber(9, 8);
        stack.addFirst(c1);
        stack.addFirst(c2);
        stack.addFirst(c3);
        s.clear();
        assertEquals(true, stack.isEmpty());
    }

    /**
     * Test of drop method, of class StackOperations.
     */
    @Test
    public void testDrop() {
        System.out.println("Testing Drop method");
        ComplexNumber c1 = new ComplexNumber(10, 8);
        ComplexNumber c2 = new ComplexNumber(7, 1);
        stack.addFirst(c1);
        stack.addFirst(c2);
        int s1 = stack.size();
        s.drop();
        assertEquals(s1 - 1, stack.size());
        assertEquals(c1, stack.peekFirst());

        // Checking the drop removing also the last element into the stack
        s.drop();
        assertEquals(0, stack.size());
        assertEquals(null, stack.peekFirst());
    }
    
    @Test
    public void testDropFail() {
        System.out.println("Testing Drop method in case of Exception");
        StackOperations t = new StackOperations(stack); // Assicurati di istanziare la tua classe s qui
        assertThrows(EmptyStackException.class, () -> {
            t.drop();
        });
    }

    /**
     * Test of dup method, of class StackOperations.
     */
    @Test
    public void testDup() {
        System.out.println("Testing Dup method");
        ComplexNumber c = new ComplexNumber(54, 77);
        stack.addFirst(c);
        int s1 = stack.size();
        s.dup();
        assertEquals(s1 + 1, stack.size());
        assertEquals(c, stack.peekFirst());

        // Additional check: verify if the last element is actually the copy of the second-last one
        ComplexNumber out1 = stack.removeFirst();
        ComplexNumber out2 = stack.removeFirst();
        assertEquals(out1, out2);
    }
    
    
    @Test
    public void testDupFail(){
        System.out.println("Testing Dup method in case of Exception");
       StackOperations t = new StackOperations(stack);
        assertThrows(EmptyStackException.class, () -> {
           t.dup();
       });
    }

    /**
     * Test of swap method, of class StackOperations.
     */
    @Test
    public void testSwap() {
        System.out.println("Testing Swap method");
        ComplexNumber c1 = new ComplexNumber(3, 3);
        ComplexNumber c2 = new ComplexNumber(5, 5);
        stack.addFirst(c1);
        stack.addFirst(c2);
        int s1 = stack.size();
        s.swap();
        assertEquals(s1, stack.size());
        assertEquals(c1, stack.peekFirst());

        // Additional check: verify the order of the swapped elements
        assertEquals(c1, stack.removeFirst());
        assertEquals(c2, stack.removeFirst());
    }
    //Test with zero element in the stack
    @Test
    public void testSwapFailZero(){
        System.out.println("Testing Swap method in case of Exception");
        StackOperations t = new StackOperations(stack);
        assertThrows(NotEnoughElementException.class, () -> {
           t.swap();
       });
    }
    
    //Test with one element in the stack
    @Test
    public void testSwapFailOne(){
        System.out.println("Testing Swap method in case of Exception");
        stack.addFirst(new ComplexNumber(8,9));
        StackOperations t = new StackOperations(stack);
        assertThrows(NotEnoughElementException.class, () -> {
           t.swap();
       });
    }
    
    
    /**
     * Test of over method, of class StackOperations.
     */
    @Test
    public void testOver() {
        System.out.println("Testing Over method");
        ComplexNumber c1 = new ComplexNumber(3, 3);
        ComplexNumber c2 = new ComplexNumber(5, 5);
        stack.addFirst(c1);
        stack.addFirst(c2);
        int s1 = stack.size();
        s.over();
        assertEquals(s1 + 1, stack.size());
        assertEquals(c1, stack.peekFirst());

        // Additional check: verify if the last element is actually the copy of the third-last one
        ComplexNumber out1 = stack.removeFirst();
        ComplexNumber out2 = stack.removeFirst();
        ComplexNumber out3 = stack.removeFirst();
        assertEquals(out1, out3);

        // Additional check: verify the general order of the elements
        assertEquals(c1, out1);
        assertEquals(c2, out2);
        assertEquals(c1, out3);
    }
    
    //Test with zero element in the stack
    @Test
    public void testOverFailZero(){
        System.out.println("Testing Over method in case of Exception");
        StackOperations t = new StackOperations(stack);
        assertThrows(NotEnoughElementException.class, () -> {
           t.over();
       });
    }
    
    //Test with one element in the stack
    @Test
    public void testOverFailOne(){
        System.out.println("Testing Over method in case of Exception");
        stack.addFirst(new ComplexNumber(8,9));
        StackOperations t = new StackOperations(stack);
        assertThrows(NotEnoughElementException.class, () -> {
           t.over();
       });
    }
    
    
    
}

