package scientificCalculatorTest;

import calculatorExceptions.DivideByZeroException;
import calculatorExceptions.NotEnoughElementException;
import calculatorExceptions.EmptyStackException;
import calculatorExceptions.WrongArgumentLogException;
import java.util.Deque;
import java.util.LinkedList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import scientificCalculator.ComplexNumber;
import scientificCalculator.MathematicalOperations;

/**
 *  Class used to test ComplexNumOperations 
 *
 * @author Group 7
 *
 */

public class MathematicalOperationsTest {

    /**
     * Definition of the stack and of an instance of
     * ComplexNumOperation
     */
    private MathematicalOperations mathematicalOperations;
    private Deque<ComplexNumber> stack;

    /**
     * Method to initialize the fixture
     */
    @BeforeEach
    public void setUp() {
        stack = new LinkedList<>();
        mathematicalOperations = new MathematicalOperations(stack);
    }
    
    /**
     * Tests the insertion method
     */
    @Test
    public void testInsertion() {
        
        System.out.println("Testing the insertion method");
        mathematicalOperations.insertion(new ComplexNumber(14.36, 81.81));
        assertEquals(new ComplexNumber(14.36, 81.81), stack.getFirst());

        mathematicalOperations.insertion(new ComplexNumber(2, 8));
        assertEquals(new ComplexNumber(2, 8), stack.removeFirst());
        assertEquals(new ComplexNumber(14.36, 81.81), stack.removeFirst());
    }
    

    /**
     * Tests the sum method with two real numbers
     */
    @Test
    public void testSum1() {
        
        System.out.println("Testing the sum method with two real numbers");        
        ComplexNumber c1 = new ComplexNumber(12.165, 0);
        mathematicalOperations.insertion(c1);
        ComplexNumber c2 = new ComplexNumber(-2.87, 0);
        mathematicalOperations.insertion(c2);
        mathematicalOperations.sum ();
        ComplexNumber result = new ComplexNumber(9.295, 0);
        assertEquals(result, stack.getFirst());
        assertEquals(1, stack.size());

        ComplexNumber c3 = new ComplexNumber(1186, 0);
        mathematicalOperations.insertion(c3);
        ComplexNumber c4 = new ComplexNumber(1180, 0);
        mathematicalOperations.insertion(c4);
        ComplexNumber c5 = new ComplexNumber(-5695, 0);
        mathematicalOperations.insertion(c5);
        mathematicalOperations.sum();
        assertEquals(3, stack.size());
        assertEquals(new ComplexNumber(-4515, 0), stack.removeFirst());
        assertEquals(new ComplexNumber(1186, 0), stack.removeFirst());
        assertEquals(new ComplexNumber(9.295, 0), stack.removeFirst());

    }
    
    
        /**
     * Tests the sum method with two pure complex numbers
     */
    @Test
    public void testSum2() {
        
        System.out.println("Testing the sum method with two pure complex numbers");        
        ComplexNumber c1 = new ComplexNumber(0, 17);
        mathematicalOperations.insertion(c1);
        ComplexNumber c2 = new ComplexNumber(0, 163);
        mathematicalOperations.insertion(c2);
        mathematicalOperations.sum();
        ComplexNumber result = new ComplexNumber(0, 180);
        assertEquals(result, stack.getFirst());
        assertEquals(1, stack.size());

        ComplexNumber c3 = new ComplexNumber(0, 1);
        mathematicalOperations.insertion(c3);
        ComplexNumber c4 = new ComplexNumber(0, 2);
        mathematicalOperations.insertion(c4);
        ComplexNumber c5 = new ComplexNumber(0, 3);
        mathematicalOperations.insertion(c5);
        mathematicalOperations.sum();
        assertEquals(3, stack.size());
        assertEquals(new ComplexNumber(0, 5), stack.removeFirst());
        assertEquals(new ComplexNumber(0, 1), stack.removeFirst());
        assertEquals(new ComplexNumber(0, 180), stack.removeFirst());

    }
    
    
        /**
     * Tests the sum method with two real numbers
     */
    @Test
    public void testSum3() {
        
        System.out.println("Testing the sum method with two real numbers");
        ComplexNumber c1 = new ComplexNumber(1, 4.8);
        mathematicalOperations.insertion(c1);
        ComplexNumber c2 = new ComplexNumber(5, 17.33);
        mathematicalOperations.insertion(c2);
        mathematicalOperations.sum();
        ComplexNumber result = new ComplexNumber(6, 22.13);
        assertEquals(result, stack.getFirst());
        assertEquals(1, stack.size());

        ComplexNumber c3 = new ComplexNumber(3, 1);
        mathematicalOperations.insertion(c3);
        ComplexNumber c4 = new ComplexNumber(10, 10);
        mathematicalOperations.insertion(c4);
        ComplexNumber c5 = new ComplexNumber(5, 8);
        mathematicalOperations.insertion(c5);
        mathematicalOperations.sum();
        assertEquals(3, stack.size());
        assertEquals(new ComplexNumber(15, 18), stack.removeFirst());
        assertEquals(new ComplexNumber(3, 1), stack.removeFirst());
        assertEquals(new ComplexNumber(6, 22.13), stack.removeFirst());

    }

    /**
     * Tests the sum method fail calling the NotEnoughElementException
     */
    @Test
    public void testSumFail() {
        System.out.println("Testing the sum method fail calling the NotEnoughElementException");
        ComplexNumber c1 = new ComplexNumber(5, -15);
        mathematicalOperations.insertion(c1);
        assertThrows(NotEnoughElementException.class, () -> {
            mathematicalOperations.sum();
        });
    }

    
    /**
     * Tests sub method with two real numbers
     */
    @Test
    public void testSub1() {
        
        System.out.println("Testing sub method with two real numbers");
        ComplexNumber c1 = new ComplexNumber(100, 0);
        mathematicalOperations.insertion(c1);
        ComplexNumber c2 = new ComplexNumber(8657.45, 0);
        mathematicalOperations.insertion(c2);
        mathematicalOperations.sub();
        assertEquals(new ComplexNumber(-8557.45, 0), stack.getFirst());
        assertEquals(1, stack.size());

        ComplexNumber c3 = new ComplexNumber(12.2010, 0);
        mathematicalOperations.insertion(c3);
        ComplexNumber c4 = new ComplexNumber(-89, 0);
        mathematicalOperations.insertion(c4);
        ComplexNumber c5 = new ComplexNumber(-9, 0);
        mathematicalOperations.insertion(c5);
        mathematicalOperations.sub();
        assertEquals(new ComplexNumber(-80, 0), stack.removeFirst());
        assertEquals(new ComplexNumber(12.2010, 0), stack.removeFirst());
        assertEquals(new ComplexNumber(-8557.45, 0), stack.removeFirst());

    }
    
    
    /**
     * Tests sub method with two pure imaginary numbers 
     */
    @Test
    public void testSub2() {
        
        System.out.println("Testing sub method with two pure imaginary numbers");
        ComplexNumber c1 = new ComplexNumber(0, 8);
        mathematicalOperations.insertion(c1);
        ComplexNumber c2 = new ComplexNumber(0, 10);
        mathematicalOperations.insertion(c2);
        mathematicalOperations.sub();
        assertEquals(new ComplexNumber(0, -2), stack.getFirst());
        assertEquals(1, stack.size());

        ComplexNumber c3 = new ComplexNumber(0, 1);
        mathematicalOperations.insertion(c3);
        ComplexNumber c4 = new ComplexNumber(0, 4);
        mathematicalOperations.insertion(c4);
        ComplexNumber c5 = new ComplexNumber(0, 15);
        mathematicalOperations.insertion(c5);
        mathematicalOperations.sub();
        assertEquals(3, stack.size());
        assertEquals(new ComplexNumber(0, -11), stack.removeFirst());
        assertEquals(new ComplexNumber(0, 1), stack.removeFirst());
        assertEquals(new ComplexNumber(0, -2), stack.removeFirst());

    }
    
    
        /**
     * Tests sub method with two complex numbers
     */
    @Test
    public void testSub3() {
        
        System.out.println("Testing sub method with two complex numbers");
        ComplexNumber c1 = new ComplexNumber(5, 6);
        mathematicalOperations.insertion(c1);
        ComplexNumber c2 = new ComplexNumber(3, 8);
        mathematicalOperations.insertion(c2);
        mathematicalOperations.sub();
        assertEquals(new ComplexNumber(2, -2), stack.getFirst());
        assertEquals(1, stack.size());

        ComplexNumber c3 = new ComplexNumber(-10, 11);
        mathematicalOperations.insertion(c3);
        ComplexNumber c4 = new ComplexNumber(1, 8.39);
        mathematicalOperations.insertion(c4);
        ComplexNumber c5 = new ComplexNumber(6, 5);
        mathematicalOperations.insertion(c5);
        mathematicalOperations.sub();
        assertEquals(new ComplexNumber(-5, 3.39), stack.removeFirst());
        assertEquals(new ComplexNumber(-10, 11), stack.removeFirst());
        assertEquals(new ComplexNumber(2, -2), stack.removeFirst());

    }
    

    /**
     * Tests the sub method fail calling the NotEnoughElementException
     */
    @Test
    public void testSubFail() {
        System.out.println("Testing the sum method fail calling the NotEnoughElementException");
        assertThrows(NotEnoughElementException.class, () -> {
            mathematicalOperations.sub();
        });
    }
    
    
        /**
     * tests product method with two real numbers
     */
    @Test
    public void testProduct1() {
        
        System.out.println("Testing product method with two real numbers");
        ComplexNumber c1 = new ComplexNumber(8.49, 0);
        mathematicalOperations.insertion(c1);
        ComplexNumber c2 = new ComplexNumber(-6.653, 0);
        mathematicalOperations.insertion(c2);
        mathematicalOperations.product();
        assertEquals(new ComplexNumber(-56.48397,  0), stack.getFirst());
        assertEquals(1, stack.size());

        ComplexNumber c3 = new ComplexNumber( 12, 0);
        mathematicalOperations.insertion(c3);
        ComplexNumber c4 = new ComplexNumber( -1, 0);
        mathematicalOperations.insertion(c4);
        ComplexNumber c5 = new ComplexNumber(  6, 0);
        mathematicalOperations.insertion(c5);
        mathematicalOperations.product();
        assertEquals(3, stack.size());
        assertEquals(new ComplexNumber(-6, 0), stack.removeFirst());
        assertEquals(new ComplexNumber(12, 0), stack.removeFirst());
        assertEquals(new ComplexNumber(-56.48397, 0), stack.removeFirst());
    }
    
    
            /**
     * tests product method with two pure imaginary numbers
     */
    @Test
    public void testProduct2() {
        
        System.out.println("Testing product method with two pure imaginary numbers");
        ComplexNumber c1 = new ComplexNumber(0, -895.36);
        mathematicalOperations.insertion(c1);
        ComplexNumber c2 = new ComplexNumber(0, 0.5698);
        mathematicalOperations.insertion(c2);
        mathematicalOperations.product();
        assertEquals(new ComplexNumber(510.176128,  0), stack.getFirst());
        assertEquals(1, stack.size());

        ComplexNumber c3 = new ComplexNumber( 1, 15);
        mathematicalOperations.insertion(c3);
        ComplexNumber c4 = new ComplexNumber( 0, -12);
        mathematicalOperations.insertion(c4);
        ComplexNumber c5 = new ComplexNumber(  0, -458.96);
        mathematicalOperations.insertion(c5);
        mathematicalOperations.product();
        assertEquals(3, stack.size());
        assertEquals(new ComplexNumber(-5507.52, 0), stack.removeFirst());
        assertEquals(new ComplexNumber(1, 15), stack.removeFirst());
        assertEquals(new ComplexNumber(510.176128, 0), stack.removeFirst());
    }
    
    
    /**
     * tests product method with two complex numbers
     */
    @Test
    public void testProduct3() {
        
        System.out.println("Testing product method with two complex numbers");
        ComplexNumber c1 = new ComplexNumber(2, 5);
        mathematicalOperations.insertion(c1);
        ComplexNumber c2 = new ComplexNumber(7, 4);
        mathematicalOperations.insertion(c2);
        mathematicalOperations.product();
        assertEquals(new ComplexNumber(-6,  43), stack.getFirst());
        assertEquals(1, stack.size());

        ComplexNumber c3 = new ComplexNumber(4, 2);
        mathematicalOperations.insertion(c3);
        ComplexNumber c4 = new ComplexNumber(5, 8);
        mathematicalOperations.insertion(c4);
        ComplexNumber c5 = new ComplexNumber(3, 9);
        mathematicalOperations.insertion(c5);
        mathematicalOperations.product();
        assertEquals(3, stack.size());
        assertEquals(new ComplexNumber(-57, 69), stack.removeFirst());
        assertEquals(new ComplexNumber(4, 2), stack.removeFirst());
        assertEquals(new ComplexNumber(-6, 43), stack.removeFirst());
    }
    

    /**
     * Tests the product method fail calling the NotEnoughElementException
     */
    @Test
    public void testProductFail() {
        System.out.println("Testing the product method fail calling NotEnoughElementException");
        ComplexNumber c1 = new ComplexNumber(-2, 1);
        mathematicalOperations.insertion(c1);

        assertThrows(NotEnoughElementException.class, () -> {
            mathematicalOperations.product();
        });
    }
    

        /**
     * Method to test the division method with two real numbers 
     */
    @Test
    public void testDivision1() {
        System.out.println("Testing division method with two real numbers");
        ComplexNumber c1 = new ComplexNumber(1593.5421, 0);
        mathematicalOperations.insertion(c1);
        ComplexNumber c2 = new ComplexNumber(1154.6941, 0);
        mathematicalOperations.insertion(c2);
        mathematicalOperations.division();
        assertEquals(new ComplexNumber(1.38005564, 0), stack.getFirst());
        assertEquals(1, stack.size());

        ComplexNumber c3 = new ComplexNumber(105, 0.01);
        mathematicalOperations.insertion(c3);
        ComplexNumber c4 = new ComplexNumber(-86, 0);
        mathematicalOperations.insertion(c4);
        ComplexNumber c5 = new ComplexNumber(10, 0);
        mathematicalOperations.insertion(c5);
        mathematicalOperations.division();
        assertEquals(3, stack.size());
        assertEquals(new ComplexNumber(-8.60, 0), stack.removeFirst());
        assertEquals(new ComplexNumber(105, 0.01), stack.removeFirst());
        assertEquals(new ComplexNumber(1.38005564, 0), stack.removeFirst());
    } 
    
    
        /**
     * Method to test the division method with two real numbers 
     */
    @Test
    public void testDivision2() {
        System.out.println("Testing division method with two pure imaginary numbers");
        ComplexNumber c1 = new ComplexNumber(0, 15);
        mathematicalOperations.insertion(c1);
        ComplexNumber c2 = new ComplexNumber(0, -13);
        mathematicalOperations.insertion(c2);
        mathematicalOperations.division();
        assertEquals(new ComplexNumber(-1.15384615, 0), stack.getFirst());
        assertEquals(1, stack.size());

        ComplexNumber c3 = new ComplexNumber(10, 458);
        mathematicalOperations.insertion(c3);
        ComplexNumber c4 = new ComplexNumber(0, -8);
        mathematicalOperations.insertion(c4);
        ComplexNumber c5 = new ComplexNumber(0, -44);
        mathematicalOperations.insertion(c5);
        mathematicalOperations.division();
        assertEquals(3, stack.size());
        assertEquals(new ComplexNumber(0.18181818, 0.0), stack.removeFirst());
        assertEquals(new ComplexNumber(10, 458), stack.removeFirst());
        assertEquals(new ComplexNumber(-1.15384615, 0), stack.removeFirst());
    }


    /**
     * Method to test the division method with two complex numbers 
     */
    @Test
    public void testDivision3() {
        System.out.println("Testing division method with two complex numbers");
        ComplexNumber c1 = new ComplexNumber(6, 9);
        mathematicalOperations.insertion(c1);
        ComplexNumber c2 = new ComplexNumber(2, 2);
        mathematicalOperations.insertion(c2);
        mathematicalOperations.division();
        assertEquals(new ComplexNumber(3.75, 0.75), stack.getFirst());
        assertEquals(1, stack.size());

        ComplexNumber c3 = new ComplexNumber(24, 9);
        mathematicalOperations.insertion(c3);
        ComplexNumber c4 = new ComplexNumber(31, 21);
        mathematicalOperations.insertion(c4);
        ComplexNumber c5 = new ComplexNumber(15, 5);
        mathematicalOperations.insertion(c5);
        mathematicalOperations.division();
        assertEquals(3, stack.size());
        assertEquals(new ComplexNumber(2.28, 0.64), stack.removeFirst());
        assertEquals(new ComplexNumber(24, 9), stack.removeFirst());
        assertEquals(new ComplexNumber(3.75, 0.75), stack.removeFirst());
    }

    
    /**
     * Tests the division method fail calling the
     * NotEnoughElementException
     */
    @Test
    public void testDivisionFail1() {
        System.out.println("Testing the division method fail calling NotEnoughElementException");
        ComplexNumber c1 = new ComplexNumber(2, 3);
        mathematicalOperations.insertion(c1);

        assertThrows(NotEnoughElementException.class, () -> {
            mathematicalOperations.division();
        });
    }
    
    

    /**
     * Tests method division fail calling the DivideByZeroException
     */
    @Test
    public void testDivideByZeroFail2() {
        System.out.println("Testing the division method fail calling DivsionBy0Exception");
        ComplexNumber c1 = new ComplexNumber(2, 3);
        mathematicalOperations.insertion(c1);
        ComplexNumber c2 = new ComplexNumber(0, 0);
        mathematicalOperations.insertion(c2);

        assertThrows(DivideByZeroException.class, () -> {
            mathematicalOperations.division();
        });
    }

    
    /**
     * tests sqrt method with a positive real number
     */
    @Test
    public void testSquareRoot1() {
        System.out.println("Testing square root method with a positive real number");
        ComplexNumber c1 = new ComplexNumber(546, 0);
        mathematicalOperations.insertion(c1);
        mathematicalOperations.squareRoot();
        assertEquals(new ComplexNumber(23.36664289, 0), stack.getFirst());
        assertEquals(1, stack.size());

    }
    
    
    /**
     * tests sqrt method with a negative real number
     */
    @Test
    public void testSquareRoot2() {
        System.out.println("Testing square root method with a negative real number");
        ComplexNumber c1 = new ComplexNumber(-4, 0);
        mathematicalOperations.insertion(c1);
        mathematicalOperations.squareRoot();
        assertEquals(new ComplexNumber(0, 2), stack.getFirst());
        assertEquals(1, stack.size());

    }    
    
    
    
    /**
     * tests sqrt method with a pure imaginary number
     */
    @Test
    public void testSquareRoot3() {
        System.out.println("Testing square root method with a pure imaginary number");
        ComplexNumber c1 = new ComplexNumber(0, -165);
        mathematicalOperations.insertion(c1);
        mathematicalOperations.squareRoot();
        assertEquals(new ComplexNumber(9.08295106, -9.08295106), stack.getFirst());
        assertEquals(1, stack.size());

    }
    
    
        /**
     * tests sqrt method with a complex number
     */
    @Test
    public void testSquareRoot4() {
        System.out.println("Testing square root method with a complex number");
        ComplexNumber c1 = new ComplexNumber(12.00, -10);
        mathematicalOperations.insertion(c1);
        mathematicalOperations.squareRoot();
        assertEquals(new ComplexNumber(3.71621443, -1.34545519), stack.getFirst());
        assertEquals(1, stack.size());

    }

    
    /**
     * Tests the sqrt root method fail calling the
     * EmptyStackException
     */
    @Test
    public void testSquareRootFail() {
        System.out.println("Testing the square root method fail calling EmptyStackException"); 
        assertThrows(EmptyStackException.class, () -> {
            mathematicalOperations.squareRoot();
        });
    }

    
    /**
     * Method to test the inverted sign method
     */
    @Test
    public void testInvertedSign() {
        System.out.println("Testing signReversal method");
        ComplexNumber c1 = new ComplexNumber(3, 2);
        mathematicalOperations.insertion(c1);
        mathematicalOperations.signReversal();
        assertEquals(new ComplexNumber(-3, -2), stack.getFirst());
        assertEquals(1, stack.size());

    }

    
    /**
     * Method to test the inverted sign method fail calling the
     * EmptyStackException
     */
    @Test 
    public void testInvertedSignFail() {
        System.out.println("Testing  signReversal method fail calling EmptyStackException");
        assertThrows(EmptyStackException.class, () -> {
           mathematicalOperations.signReversal();
       });
    }
    
    
    /*
    * Tests the sin method with a positive real number 
    */
    @Test
    public void testSin1(){
        System.out.println("Testing sin method with a positive real number");
        ComplexNumber c1 = new ComplexNumber(60,0 );
        mathematicalOperations.insertion(c1);
        mathematicalOperations.sin();
        assertEquals(new ComplexNumber(-0.3048106211, 0), stack.getFirst());
        assertEquals(1, stack.size());
    }
    
    
    /*
    * Tests the sin method with a negative real number 
    */
    @Test
    public void testSin2(){
        System.out.println("Testing sin method with a negative real number");
        ComplexNumber c1 = new ComplexNumber(-30,0 );
        mathematicalOperations.insertion(c1);
        mathematicalOperations.sin();
        assertEquals(new ComplexNumber(0.98803162409, 0), stack.getFirst());
        assertEquals(1, stack.size());
    }
    
    
    /*
    * Tests the sin method with a pure imaginary number 
    */
    @Test
    public void testSin3(){
        System.out.println("Testing sin method with a pure imaginary number");
        ComplexNumber c1 = new ComplexNumber(0,17.3 );
        mathematicalOperations.insertion(c1);
        mathematicalOperations.sin();
        assertEquals(new ComplexNumber(0.0, 1.630288786049792E7), stack.getFirst());
        assertEquals(1, stack.size());
    }
    
    
    /*
    * Tests the sin method with a complex number 
    */
    @Test
    public void testSin4(){
        System.out.println("Testing sin method with a complex number");
        ComplexNumber c1 = new ComplexNumber(6,-5 );
        mathematicalOperations.insertion(c1);
        mathematicalOperations.sin();
        assertEquals(new ComplexNumber(-20.73540973837024,  -71.24771797085289), stack.getFirst());
        assertEquals(1, stack.size());
    }
    
    
    /**
     * Method to test the sin method fail calling the
     * EmptyStackException
     */
    @Test 
    public void testSinFail() {
        System.out.println("Testing sin method fail calling EmptyStackException");
        assertThrows(EmptyStackException.class, () -> {
           mathematicalOperations.sin();
       });
    }
    
    
    /*
    * Tests the cos method with a positive real number 
    */
    @Test
    public void testCos1(){
        System.out.println("Testing cos method with a positive real number");
        ComplexNumber c1 = new ComplexNumber(558.054,0 );
        mathematicalOperations.insertion(c1);
        mathematicalOperations.cos();
        assertEquals(new ComplexNumber(0.408950762896613, 0), stack.getFirst());
        assertEquals(1, stack.size());
    }
    
    
    /*
    * Tests the sin method with a negative real number 
    */
    @Test
    public void testCos2(){
        System.out.println("Testing cos method with a negative real number");
        ComplexNumber c1 = new ComplexNumber(-15,0 );
        mathematicalOperations.insertion(c1);
        mathematicalOperations.cos();
        assertEquals(new ComplexNumber(-0.759687912858821, 0), stack.getFirst());
        assertEquals(1, stack.size());
    }
    
    
    /*
    * Tests the sin method with a pure imaginary number 
    */
    @Test
    public void testCos3(){
        System.out.println("Testing cos method with a pure imaginary number");
        ComplexNumber c1 = new ComplexNumber(0,-89 );
        mathematicalOperations.insertion(c1);
        mathematicalOperations.cos();
        assertEquals(new ComplexNumber(2.2448064095871724E38, 0.0), stack.getFirst());
        assertEquals(1, stack.size());
    }
    
    
    /*
    * Tests the sin method with a complex number 
    */
    @Test
    public void testCos4(){
        System.out.println("Testing cos method with a complex number");
        ComplexNumber c1 = new ComplexNumber(10,1 );
        mathematicalOperations.insertion(c1);
        mathematicalOperations.cos();
        assertEquals(new ComplexNumber(-1.294755027742689,  0.639334258884614), stack.getFirst());
        assertEquals(1, stack.size());
    }
    
    
    /**
     * Method to test the cos method fail calling the
     * EmptyStackException
     */
    @Test 
    public void testCosFail() {
        System.out.println("Testing cos method fail calling EmptyStackException");
        assertThrows(EmptyStackException.class, () -> {
           mathematicalOperations.cos();
       });
    }
    
    
    /*
    * Tests the tan method with a positive real number 
    */
    @Test
    public void testTan1(){
        System.out.println("Testing tan method with a positive real number");
        ComplexNumber c1 = new ComplexNumber(5,0 );
        mathematicalOperations.insertion(c1);
        mathematicalOperations.tan();
        assertEquals(new ComplexNumber(-3.380515006246585, 0), stack.getFirst());
        assertEquals(1, stack.size());
    }
    
    
    /*
    * Tests the tan method with a negative real number 
    */
    @Test
    public void testTan2(){
        System.out.println("Testing tan method with a negative real number");
        ComplexNumber c1 = new ComplexNumber(-1,0 );
        mathematicalOperations.insertion(c1);
        mathematicalOperations.tan();
        assertEquals(new ComplexNumber(-1.557407724, 0), stack.getFirst());
        assertEquals(1, stack.size());
    }
    
    
    /*
    * Tests the tan method with a pure imaginary number 
    */
    @Test
    public void testTan3(){
        System.out.println("Testing tan method with a pure imaginary number");
        ComplexNumber c1 = new ComplexNumber(0,-12.3 );
        mathematicalOperations.insertion(c1);
        mathematicalOperations.tan();
        assertEquals(new ComplexNumber(0, -0.99999999958563), stack.getFirst());
        assertEquals(1, stack.size());
    }
    
    
    /*
    * Tests the sin method with a complex number 
    */
    @Test
    public void testTan4(){
        System.out.println("Testing tan method with a complex number");
        ComplexNumber c1 = new ComplexNumber(10,1 );
        mathematicalOperations.insertion(c1);
        mathematicalOperations.tan();
        assertEquals(new ComplexNumber(0.218917133299675,  0.8696927693), stack.getFirst());
        assertEquals(1, stack.size());
    }
    
    
    /**
     * Method to test the tan method fail calling the
     * EmptyStackException
     */
    @Test 
    public void testTanFail() {
        System.out.println("Testing tan method fail calling EmptyStackException");
        assertThrows(EmptyStackException.class, () -> {
           mathematicalOperations.tan();
       });
    }
    
    
    /*
    * Tests ln method with a real number 
    */
    @Test
    public void testLn1(){
        System.out.println("Testing ln with a real number");
        ComplexNumber c1 = new ComplexNumber(-181,0);
        mathematicalOperations.insertion(c1);
        mathematicalOperations.ln();
        assertEquals(new ComplexNumber(5.19849703 , 3.14159265), stack.getFirst());
        assertEquals(1, stack.size());
    }
    
    
    /*
    * Tests ln method with a pure imaginary number 
    */
    @Test
    public void testLn2(){
        System.out.println("Testing ln with a pure imaginary number");
        ComplexNumber c1 = new ComplexNumber(0,1);
        mathematicalOperations.insertion(c1);
        mathematicalOperations.ln();
        assertEquals(new ComplexNumber(0 , 1.570796326794897), stack.getFirst());
        assertEquals(1, stack.size());
    }
    
    
    /*
    * Tests ln method with a complex number 
    */
    @Test
    public void testLn3(){
        System.out.println("Testing ln with a complex number");
        ComplexNumber c1 = new ComplexNumber(7,12);
        mathematicalOperations.insertion(c1);
        mathematicalOperations.ln();
        assertEquals(new ComplexNumber(2.631345094452 , 1.0427218783), stack.getFirst());
        assertEquals(1, stack.size());
    }
    
    
    /**
     * Method to test the ln method fail calling the
     * EmptyStackException
     */
    @Test 
    public void testLnFail1() {
        System.out.println("Testing ln method fail calling EmptyStackException");
        assertThrows(EmptyStackException.class, () -> {
           mathematicalOperations.ln();
       });
    }
    
    
   /**
     * Method to test the ln method fail calling the
     * WrongArgumentLogException
     */
    @Test 
    public void testLnFail2() {
        System.out.println("Testing ln method fail calling WrongArgumentLogException");
        ComplexNumber n1 = new ComplexNumber(0.0,0.0);
        mathematicalOperations.insertion(n1);
        assertThrows(WrongArgumentLogException.class, () -> {
           mathematicalOperations.ln();
       });
    } 
    
    
    /*
    * Tests log method with a real number 
    */
    @Test
    public void testLog1(){
        System.out.println("Testing log with a real number");
        ComplexNumber c1 = new ComplexNumber(100,0);
        mathematicalOperations.insertion(c1);
        mathematicalOperations.log();
        assertEquals(new ComplexNumber(2.0 , 0.0), stack.getFirst());
        assertEquals(1, stack.size());
    }
    
    
    /*
    * Tests log method with a pure imaginary number 
    */
    @Test
    public void testLog2(){
        System.out.println("Testing log with a pure imaginary number");
        ComplexNumber c1 = new ComplexNumber(0,50);
        mathematicalOperations.insertion(c1);
        mathematicalOperations.log();
        assertEquals(new ComplexNumber(1.698970004360187, 1.5707963268), stack.getFirst());
        assertEquals(1, stack.size());
    }
    
    
    /*
    * Tests log method with a pure imaginary number 
    */
    @Test
    public void testLog3(){
        System.out.println("Testing log with a pure imaginary number");
        ComplexNumber c1 = new ComplexNumber(10,30);
        mathematicalOperations.insertion(c1);
        mathematicalOperations.log();
        assertEquals(new ComplexNumber(1.50, 1.24904577), stack.getFirst());
        assertEquals(1, stack.size());
    }
    
    
        /**
     * Method to test the ln method fail calling the
     * EmptyStackException
     */
    @Test 
    public void testLogFail1() {
        System.out.println("Testing log method fail calling EmptyStackException");
        assertThrows(EmptyStackException.class, () -> {
           mathematicalOperations.log();
       });
    }
    
    
   /**
     * Method to test the ln method fail calling the
     * WrongArgumentLogException
     */
    @Test 
    public void testLogFail2() {
        System.out.println("Testing log method fail calling WrongArgumentLogException");
        ComplexNumber n1 = new ComplexNumber(0.0,0.0);
        mathematicalOperations.insertion(n1);
        assertThrows(WrongArgumentLogException.class, () -> {
           mathematicalOperations.log();
       });
    }
    
    
    /*
    * Tests exp method with a real number 
    */
    @Test
    public void testExp1(){
        System.out.println("Testing exp with a real number");
        ComplexNumber c1 = new ComplexNumber(9.12,0);
        mathematicalOperations.insertion(c1);
        mathematicalOperations.exp();
        assertEquals(new ComplexNumber(9136.20161642, 0.0), stack.getFirst());
        assertEquals(1, stack.size());
    }
    
    
    /*
    * Tests exp method with a pure imaginary number 
    */
    @Test
    public void testExp2(){
        System.out.println("Testing exp with a pure imaginary number");
        ComplexNumber c1 = new ComplexNumber(0,0.89);
        mathematicalOperations.insertion(c1);
        mathematicalOperations.exp();
        assertEquals(new ComplexNumber(0.6294120265 , 0.777071747), stack.getFirst());
        assertEquals(1, stack.size());
    }
    
    
    /*
    * Tests exp method with a complex number 
    */
    @Test
    public void testExp3(){
        System.out.println("Testing exp with a complex number");
        ComplexNumber c1 = new ComplexNumber(7.15,-54);
        mathematicalOperations.insertion(c1);
        mathematicalOperations.exp();
        assertEquals(new ComplexNumber(-1056.6285967348 ,  711.9564548275), stack.getFirst());
        assertEquals(1, stack.size());
    }
    

}