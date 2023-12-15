package scientificCalculatorTest;

import java.util.Deque;
import calculatorExceptions.EmptyStackException;
import calculatorExceptions.NotEnoughElementException;
import java.util.LinkedList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import scientificCalculator.*;

/**
 *
 * @author group_07
 */
public class StackOperationsTest {
    
    private Deque<ComplexNumber> stack;
    private StackOperations s;
    
    public StackOperationsTest() {
    }

    @BeforeEach
    public void setUp() {
        stack = new LinkedList<>();
        s = new StackOperations(stack);
    }
    
    /**
     * Test of clear method, without anything in the stack.
     */
    
    @Test
    public void testClear1() {
        System.out.println("Testing Clear method");
        s.clear();
        assertEquals(true, stack.isEmpty());
    }
    
    /**
     * Test of clear method, with something in the stack.
     */
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
     * Test of drop method, with two numbers in the stack.
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
        s.drop();
        assertEquals(0, stack.size());
        assertEquals(null, stack.peekFirst());
    }
    /**
     * Test of clear method, fail in case the stack is empty.
     */
    @Test
    public void testDropFail() {
        System.out.println("Testing Drop method in case of Exception");
        StackOperations t = new StackOperations(stack); // Assicurati di istanziare la tua classe s qui
        assertThrows(EmptyStackException.class, () -> {
            t.drop();
        });
    }

    /**
     * Test of dup method, with one number in the stack.
     */
    @Test
    public void testDup1() {
        System.out.println("Testing Dup method");
        ComplexNumber c1 = new ComplexNumber(54, 77);
        stack.addFirst(c1);
        int s1 = stack.size();
        s.dup();
        assertEquals(s1 + 1, stack.size());
        assertEquals(c1, stack.peekFirst());
        ComplexNumber copy1 = stack.removeFirst();
        ComplexNumber copy2 = stack.removeFirst();
        assertEquals(copy1, copy2);
    }
    
    /**
     * Test of dup method, with two number in the stack.
     */
    @Test
    public void testDup2() {
        System.out.println("Testing Dup method");
        ComplexNumber c1 = new ComplexNumber(54, 77);
        ComplexNumber c2 = new ComplexNumber(55, 78);
        stack.addFirst(c1);
        stack.addFirst(c2);
        int s1 = stack.size();
        s.dup();
        assertEquals(s1 + 1, stack.size());
        assertEquals(c2, stack.peekFirst());
        ComplexNumber copy1 = stack.removeFirst();
        ComplexNumber copy2 = stack.removeFirst();
        assertEquals(copy1, copy2);
        assertEquals(c1, stack.removeFirst());
    }
    
    /**
     * Test of dup method, fail in case the stack is empty.
     */
    @Test
    public void testDupFail(){
        System.out.println("Testing Dup method in case of Exception");
       StackOperations t = new StackOperations(stack);
        assertThrows(EmptyStackException.class, () -> {
           t.dup();
       });
    }

    /**
     * Test of swap method, .
     */
    @Test
    public void testSwap() {
        System.out.println("Testing Swap method");
        ComplexNumber c1 = new ComplexNumber(7, 8.5);
        ComplexNumber c2 = new ComplexNumber(4.2, 103.4);
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
     * Test of over method, .
     */
    @Test
    public void testOver() {
        System.out.println("Testing Over method");
        ComplexNumber c1 = new ComplexNumber(88.6, 34.6);
        ComplexNumber c2 = new ComplexNumber(50.6, 81.6);
        stack.addFirst(c1);
        stack.addFirst(c2);
        int s1 = stack.size();
        s.over();
        assertEquals(s1 + 1, stack.size());
        assertEquals(c1, stack.peekFirst());
        ComplexNumber d1 = stack.removeFirst();
        ComplexNumber d2 = stack.removeFirst();
        ComplexNumber d3 = stack.removeFirst();
        assertEquals(d1, d3);
        assertEquals(c1, d1);
        assertEquals(c2, d2);
        assertEquals(c1, d3);
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

