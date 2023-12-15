/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package scientificCalculatorTest;

import calculatorExceptions.ScientificCalculatorException;
import java.util.Deque;
import java.util.LinkedList;
import org.junit.jupiter.api.Test;
import scientificCalculator.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

/**
 *
 * @author salva
 */
public class ScientificCalculatorTest {
    
    private ScientificCalculator scientificCalculator;
    private Deque<ComplexNumber> stack;    
    
    public ScientificCalculatorTest() {
    }
    
    @BeforeEach
    public void setUp() {
        stack = new LinkedList<>();
        scientificCalculator = new ScientificCalculator(stack);
    }

    /**
     * Test of parse method, of class ScientificCalculator. 
     * Verifies if a complex number consisting in "j" "+j" "-j"
     * in the textfiled is inserted in the stack once enter is pressed
     */
    @Test
    public void testParseInsertion1() {
        System.out.println("Testing parse method with insertion of j +j -j");
        scientificCalculator.parse("j");
        assertEquals(new ComplexNumber(0, 1), stack.getFirst());
        scientificCalculator.parse("+j");
        assertEquals(new ComplexNumber(0, 1), stack.getFirst());
        scientificCalculator.parse("-j");
        assertEquals(new ComplexNumber(0, -1), stack.getFirst());
    }
    
    
    /**
     * Test of parse method, of class ScientificCalculator. 
     * Verifies if a complex number consisting in a pure imaginary 
     * number in the textfiled is inserted in the stack once enter 
     * is pressed
     */  
    @Test
    public void testParseInsertion2(){
         System.out.println("Testing parse method with insertion of a pure imaginary number");
         scientificCalculator.parse("3j");
         assertEquals(new ComplexNumber(0, 3), stack.getFirst());
         scientificCalculator.parse("+53.9j");
         assertEquals(new ComplexNumber(0, 53.9), stack.getFirst());
         scientificCalculator.parse("-3.6j");
         assertEquals(new ComplexNumber(0, -3.6), stack.getFirst());
         scientificCalculator.parse("-8418j");
         assertEquals(new ComplexNumber(0, -8418), stack.getFirst());
         scientificCalculator.parse("-1j");
         assertEquals(new ComplexNumber(0, -1), stack.getFirst());
         scientificCalculator.parse("+1j");
         assertEquals(new ComplexNumber(0, +1), stack.getFirst());
    }
    
    
    /**
     * Test of parse method, of class ScientificCalculator. 
     * Verifies if a complex number consisting in a complex number 
     * number in the textfiled is inserted in the stack once enter 
     * is pressed
     */  
    @Test
    public void testParseInsertion3(){
         System.out.println("Testing parse method with insertion of a complex number number");
         scientificCalculator.parse("78.420-j");
         assertEquals(new ComplexNumber(78.420, -1), stack.getFirst());
         scientificCalculator.parse("0+j");
         assertEquals(new ComplexNumber(0, 1), stack.getFirst());
         scientificCalculator.parse("0-j");
         assertEquals(new ComplexNumber(0, -1), stack.getFirst());
         scientificCalculator.parse("3+j");
         assertEquals(new ComplexNumber(3, 1), stack.getFirst());
         scientificCalculator.parse("+12+j");
         assertEquals(new ComplexNumber(12, 1), stack.getFirst());
         scientificCalculator.parse("145+41j");
         assertEquals(new ComplexNumber(145, 41), stack.getFirst());
         scientificCalculator.parse("780-j");
         assertEquals(new ComplexNumber(780, -1), stack.getFirst());
         scientificCalculator.parse("-10+j");
         assertEquals(new ComplexNumber(-10, 1), stack.getFirst());
         scientificCalculator.parse("-11-j");
         assertEquals(new ComplexNumber(-11, -1), stack.getFirst());
         scientificCalculator.parse("12-1j");
         assertEquals(new ComplexNumber(12, -1), stack.getFirst());
         scientificCalculator.parse("13.10+2j");
         assertEquals(new ComplexNumber(13.10, 2), stack.getFirst());
         scientificCalculator.parse("14+3.23j");
         assertEquals(new ComplexNumber(14, 3.23), stack.getFirst());
         scientificCalculator.parse("+15-4j");
         assertEquals(new ComplexNumber(15, -4), stack.getFirst());
         scientificCalculator.parse("145+41j");
         assertEquals(new ComplexNumber(145, 41), stack.getFirst());
         scientificCalculator.parse("-16.010+5.420j");
         assertEquals(new ComplexNumber(-16.010, 5.420), stack.getFirst());
         scientificCalculator.parse("-17-6.55j");
         assertEquals(new ComplexNumber(-17, -6.55), stack.getFirst());
         scientificCalculator.parse("20.202");
         assertEquals(new ComplexNumber(20.202, 0), stack.getFirst());
         scientificCalculator.parse("+18.23");
         assertEquals(new ComplexNumber(18.23, 0), stack.getFirst());
         scientificCalculator.parse("-404");
         assertEquals(new ComplexNumber(-404, 0), stack.getFirst());
    }    
    
    
    /**
     * The testParseAssignToVar method verifies if the interpreter recognizes
     * that it has to call the assignToVar method of the class Variables. To test
     * this operation, the content of the variable is pushed onto the stack 
     */
    @Test
    public void testParseAssignCopyToVar() {
        System.out.println("Testing assignToVar and CopyToVar inserted from input");
        scientificCalculator.parse("10+5j");
        scientificCalculator.parse(">x");
        scientificCalculator.parse("<x");
        assertEquals(new ComplexNumber(10, 5), stack.getFirst());
    } 
    
    
    /**
     * testParseAssignCopyToVarFail1 verifies that an ScientificCalculatorException is
     * thrown if there is a wrong insertion of the operation by keyboard 
     */
    @Test
    public void testParseAssignCopyToVarFail1() {
        System.out.println("Testing to verify ScientificCalculatorException with a wrong assignToVar input ");
        assertThrows(ScientificCalculatorException.class, () -> {
            scientificCalculator.parse(">ds");
        });
    }
    
    
    /**
     * testParseAssignCopyToVarFail1 verifies that an ScientificCalculatorException is
     * thrown if there is a wrong insertion of the operation by keyboard 
     */
    @Test
    public void testParseAssignCopyToVarFail2() {
        System.out.println("Testing to verify ScientificCalculatorException with a wrong copyToVar input ");
        assertThrows(ScientificCalculatorException.class, () -> {
            scientificCalculator.parse("<xC");
        });
    }
    
    
    
    
    
     /**
     * The testParseSumToVar method verifies if there is "+var" operation in
     * the text field, then the scientificCalculator calls the sumToVar method of the class
     * Variable
     */
    @Test
    public void testParseSumToVar() {
        System.out.println("Testing sumToVar inserted from input");
        scientificCalculator.parse("1+1j");
        scientificCalculator.parse("2+2j");
        scientificCalculator.parse(">x"); 
        scientificCalculator.parse("+x");
        scientificCalculator.parse("<x");
        assertEquals(new ComplexNumber(3, 3), stack.getFirst());
    }
    
    
    /**
     * testParseAssignToVarFail1 verifies that an ScientificCalculatorException is
     * thrown if there is a wrong insertion of the operation by keyboard 
     */
    @Test
    public void testParseSumToVarFail() {
        System.out.println("Testing to verify ScientificCalculatorException with a wrong sumToVar input ");
        assertThrows(ScientificCalculatorException.class, () -> {
            scientificCalculator.parse("+x3");
        });
    }
    
    
    /**
     * The testParseSubctractionToVar method verifies if there is "-var"
     * operation in the text field, then the interpreter calls the subctractionToVar
     * method of the class Variable 
     */
    @Test
    public void testParseSubtractToVar() {
        System.out.println("Testing subtractToVar inserted from input");
        scientificCalculator.parse("2+2j");
        scientificCalculator.parse("1+1j");
        scientificCalculator.parse(">x"); 
        scientificCalculator.parse("-x");
        scientificCalculator.parse("<x");
        assertEquals(new ComplexNumber(-1, -1), stack.getFirst());

    }
    
    
     /**
     * testParseAssignToVarFail1 verifies that an ScientificCalculatorException is
     * thrown if there is a wrong insertion of the operation by keyboard 
     */
    @Test
    public void testParseSubtractToVarFail() {
        System.out.println("Testing to verify ScientificCalculatorException with a wrong subtractToVar input ");
        assertThrows(ScientificCalculatorException.class, () -> {
            scientificCalculator.parse("-x3");
        });
    }
    
    
    /*
    * Tests if the parserser recognises a clear command
    */
    @Test
    public void testParseClear(){
        System.out.println("Testing clean operation inserted from input");
        scientificCalculator.parse("1+j");
        scientificCalculator.parse("2+3j");
        assertEquals(2, stack.size());
        scientificCalculator.parse("clear");
        assertEquals(0, stack.size());      
    }
    
    
    /*
    * Tests if the ScioentificCalculatorException is thrown correctly with a 
    * wrong clear command string
    */
    @Test
    public void testParseClearFail() {
        System.out.println("Testing to verify ScientificCalculatorException with a wrong clear input ");
        assertThrows(ScientificCalculatorException.class, () -> {
            scientificCalculator.parse("Clear");
        });
    }
    
    
    /*
    * Tests if the parserser recognises a drop command
    */
    @Test
    public void testParseDrop(){
        System.out.println("Testing drop operation inserted from input");
        scientificCalculator.parse("1+j");
        assertEquals(1, stack.size());
        scientificCalculator.parse("drop");
        assertEquals(0, stack.size());      
    }
    
    
    /*
    * Tests if the ScientificCalculatorException is thrown correctly with a 
    * wrong drop command string
    */
    @Test
    public void testParseDropFail() {
        System.out.println("Testing to verify ScientificCalculatorException with a wrong drop input ");
        assertThrows(ScientificCalculatorException.class, () -> {
            scientificCalculator.parse("Droop");
        });
    }
    
    
    /*
    * Tests if the parserser recognises a dup command
    */
    @Test
    public void testParseDup(){
        System.out.println("Testing dup operation inserted from input");
        scientificCalculator.parse("1+j");
        assertEquals(1, stack.size());
        scientificCalculator.parse("dup");
        assertEquals(2, stack.size()); 
        assertEquals(new ComplexNumber (1,1), stack.getFirst());
    }
    
    
    /*
    * Tests if the ScientificCalculatorException is thrown correctly with a 
    * wrong dup command string
    */
    @Test
    public void testParseDupFail() {
        System.out.println("Testing to verify ScientificCalculatorException with a wrong dup input ");
        assertThrows(ScientificCalculatorException.class, () -> {
            scientificCalculator.parse("dupp");
        });
    }
    
    
    /*
    * Tests if the parserser recognises a swap command
    */
    @Test
    public void testParseSwap(){
        System.out.println("Testing swap operation inserted from input");
        scientificCalculator.parse("1+j");
        scientificCalculator.parse("2+2j");
        assertEquals(2, stack.size());
        scientificCalculator.parse("swap");
        assertEquals(2, stack.size()); 
        assertEquals(new ComplexNumber (1,1), stack.removeFirst());
        assertEquals(new ComplexNumber (2,2), stack.removeFirst());
    }
    
    
    /*
    * Tests if the ScientificCalculatorException is thrown correctly with a 
    * wrong swap command string
    */
    @Test
    public void testParseSwapFail() {
        System.out.println("Testing to verify ScientificCalculatorException with a wrong swap input ");
        assertThrows(ScientificCalculatorException.class, () -> {
            scientificCalculator.parse("swapp");
        });
    }    
    
    
    /*
    * Tests if the parserser recognises a swap command
    */
    @Test
    public void testParseOver(){
        System.out.println("Testing over operation inserted from input");
        scientificCalculator.parse("1+j");
        scientificCalculator.parse("2+2j");
        assertEquals(2, stack.size());
        scientificCalculator.parse("over");
        assertEquals(3, stack.size()); 
        assertEquals(new ComplexNumber (1,1), stack.removeFirst());
        assertEquals(new ComplexNumber (2,2), stack.removeFirst());
        assertEquals(new ComplexNumber (1,1), stack.removeFirst());
    }
    
    
    /*
    * Tests if the ScientificCalculatorException is thrown correctly with a 
    * wrong swap command string
    */
    @Test
    public void testParseOverFail() {
        System.out.println("Testing to verify ScientificCalculatorException with a wrong over input ");
        assertThrows(ScientificCalculatorException.class, () -> {
            scientificCalculator.parse("Over");
        });
    }
    
    
    /*
    *   Tests if the add method is recognised correctly
    */
    @Test
    public void testParseAdd(){
        System.out.println("Testing add operation inserted from input");
        scientificCalculator.parse("1+j");
        scientificCalculator.parse("2+2j");
        assertEquals(2, stack.size());
        scientificCalculator.parse("+");
        assertEquals(1, stack.size()); 
        assertEquals(new ComplexNumber (3,3), stack.removeFirst());
    }    
    
    
    /*
    *   Tests if the add method is recognised correctly
    */
    @Test
    public void testParseSub(){
        System.out.println("Testing sub operation inserted from input");
        scientificCalculator.parse("1+j");
        scientificCalculator.parse("2+2j");
        assertEquals(2, stack.size());
        scientificCalculator.parse("-");
        assertEquals(1, stack.size()); 
        assertEquals(new ComplexNumber (-1,-1), stack.removeFirst());
    }
    
    
    /*
    *   Tests if the product method is recognised correctly
    */
    @Test
    public void testParseProduct(){
        System.out.println("Testing product operation inserted from input");
        scientificCalculator.parse("1+j");
        scientificCalculator.parse("2+2j");
        assertEquals(2, stack.size());
        scientificCalculator.parse("*");
        assertEquals(1, stack.size()); 
        assertEquals(new ComplexNumber (0,4), stack.removeFirst());
    }
    
    
    /*
    *   Tests if the division method is recognised correctly
    */
    @Test
    public void testParseDivision(){
        System.out.println("Testing product operation inserted from input");
        scientificCalculator.parse("1+j");
        scientificCalculator.parse("2+2j");
        assertEquals(2, stack.size());
        scientificCalculator.parse("/");
        assertEquals(1, stack.size()); 
        assertEquals(new ComplexNumber (0.5,0), stack.removeFirst());
    }    
    
    
    /*
    *   Tests if the sqrt method is recognised correctly
    */
    @Test
    public void testParseSqrt(){
        System.out.println("Testing square root operation inserted from input");
        scientificCalculator.parse("4");
        assertEquals(1, stack.size());
        scientificCalculator.parse("sqrt");
        assertEquals(1, stack.size()); 
        assertEquals(new ComplexNumber (2,0), stack.removeFirst());
    } 
    
    
    /*
    *   Tests if the sqrt method is recognised correctly
    */
    @Test
    public void testParseSignReversal(){
        System.out.println("Testing Sign Reversal operation inserted from input");
        scientificCalculator.parse("4");
        assertEquals(1, stack.size());
        scientificCalculator.parse("(-)");
        assertEquals(1, stack.size()); 
        assertEquals(new ComplexNumber (-4,0), stack.removeFirst());
    } 
    
    
    /*
    *   Tests if the sin method is recognised correctly
    */
    @Test
    public void testParseSin(){
        System.out.println("Testing sin operation inserted from input");
        scientificCalculator.parse("60");
        assertEquals(1, stack.size());
        scientificCalculator.parse("sin");
        assertEquals(1, stack.size()); 
        assertEquals(new ComplexNumber (-0.3048106211,0), stack.removeFirst());
    } 
    
    
    /*
    *   Tests if the cos method is recognised correctly
    */
    @Test
    public void testParseCos(){
        System.out.println("Testing cos operation inserted from input");
        scientificCalculator.parse("558.054");
        assertEquals(1, stack.size());
        scientificCalculator.parse("cos");
        assertEquals(1, stack.size()); 
        assertEquals(new ComplexNumber (0.408950762896613,0), stack.removeFirst());
    }
    
    
    /*
    *   Tests if the tan method is recognised correctly
    */
    @Test
    public void testParseTan(){
        System.out.println("Testing tan operation inserted from input");
        scientificCalculator.parse("5");
        assertEquals(1, stack.size());
        scientificCalculator.parse("tan");
        assertEquals(1, stack.size()); 
        assertEquals(new ComplexNumber (-3.380515006246585,0), stack.removeFirst());
    }
    
    
    /*
    *   Tests if the ln method is recognised correctly
    */
    @Test
    public void testParseLn(){
        System.out.println("Testing ln operation inserted from input");
        scientificCalculator.parse("-181");
        assertEquals(1, stack.size());
        scientificCalculator.parse("ln");
        assertEquals(1, stack.size()); 
        assertEquals(new ComplexNumber (5.19849703 , 3.14159265), stack.removeFirst());
    }
    
    
    /*
    *   Tests if the log method is recognised correctly
    */
    @Test
    public void testParseLog(){
        System.out.println("Testing log operation inserted from input");
        scientificCalculator.parse("100");
        assertEquals(1, stack.size());
        scientificCalculator.parse("log");
        assertEquals(1, stack.size()); 
        assertEquals(new ComplexNumber (2,0), stack.removeFirst());
    }
    
    
    /*
    *   Tests if the ln method is recognised correctly
    */
    @Test
    public void testParseExp(){
        System.out.println("Testing exp operation inserted from input");
        scientificCalculator.parse("9.12");
        assertEquals(1, stack.size());
        scientificCalculator.parse("exp");
        assertEquals(1, stack.size()); 
        assertEquals(new ComplexNumber (9136.20161642 , 0), stack.removeFirst());
    }
    
    
    
    
    
    
    

}
