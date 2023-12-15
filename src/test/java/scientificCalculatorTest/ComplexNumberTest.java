package scientificCalculatorTest;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import scientificCalculator.ComplexNumber;

/**
 *
 * @author group_07
 */
public class ComplexNumberTest {
    
    private ComplexNumber c;
    
    public ComplexNumberTest() {
    }
    
    @BeforeEach
    public void setUp(){
        c = new ComplexNumber(0,0);
    }
    
    /**
     * Test of getRealPart method, with positive real part.
     */
    @Test
    public void testGetRealPart1(){
        System.out.println("Testing getRealPart method");
        c = new ComplexNumber(10,5);
        double re = c.getRealPart();
        assertEquals(10,re);
    }
    /**
     * Test of getRealPart method, with negative real part.
     */
    @Test
    public void testGetRealPart2(){
        System.out.println("Testing getRealPart method");
        c = new ComplexNumber(-10,5);
        double re = c.getRealPart();
        assertEquals(-10,re);
    }
    /**
     * Test of getRealPart method, with 0 real part.
     */
    @Test
    public void testGetRealPart3(){
        System.out.println("Testing getRealPart method");
        c = new ComplexNumber(0,5);
        double re = c.getRealPart();
        assertEquals(0,re);
    }
    /**
     * Test of getRealPart method, with a double real part.
     */
    @Test
    public void testGetRealPart4(){
        System.out.println("Testing getRealPart method");
        c = new ComplexNumber(2.6,5);
        double re = c.getRealPart();
        assertEquals(2.6,re);
    }

    /**
     * Test of getImgPart method, with positive img part.
     */
    @Test
    public void testGetImgPart1() {
        System.out.println("Testing getImgPart method");
        c = new ComplexNumber(10,5);
        double im = c.getImgPart();
        assertEquals(5,im);
    }
    /**
     * Test of getImgPart method, with negative img part.
     */
    @Test
    public void testGetImgPart2() {
        System.out.println("Testing getImgPart method");
        c = new ComplexNumber(10,-5);
        double im = c.getImgPart();
        assertEquals(-5,im);
    }
    /**
     * Test of getImgPart method, with zero img part.
     */
    @Test
    public void testGetImgPart3() {
        System.out.println("Testing getImgPart method");
        c = new ComplexNumber(10,0);
        double im = c.getImgPart();
        assertEquals(0,im);
    }
    /**
     * Test of getImgPart method, with double img part.
     */
    @Test
    public void testGetImgPart4() {
        System.out.println("Testing getImgPart method");
        c = new ComplexNumber(10,5.8);
        double im = c.getImgPart();
        assertEquals(5.8,im);
    }
    
    /**
     * Test of convertToComplexOnlyJ method, for j.
     */
    @Test
    public void testConvertToComplexOnlyJ1() {
        System.out.println("Testing ConvertToComplexOnlyJ method");
        c.convertToComplexOnlyJ("j");
        assertEquals(c.getRealPart(),0.0);
        assertEquals(c.getImgPart(),1.0);
    }
    /**
     * Test of convertToComplexOnlyJ method, for +j.
     */
    @Test
    public void testConvertToComplexOnlyJ2() {
        System.out.println("Testing ConvertToComplexOnlyJ method");
        c.convertToComplexOnlyJ("+j");
        assertEquals(c.getRealPart(),0.0);
        assertEquals(c.getImgPart(),1.0);
    }
    /**
     * Test of convertToComplexOnlyJ method, for -j.
     */
    @Test
    public void testConvertToComplexOnlyJ3() {
        System.out.println("Testing ConvertToComplexOnlyJ method");
        c.convertToComplexOnlyJ("-j");
        assertEquals(c.getRealPart(),0.0);
        assertEquals(c.getImgPart(),-1.0);
    }
    /**
     * Test of convertToComplexOnlyImg method, with 3j as input.

     */
    @Test
    public void testConvertToComplexOnlyImg1() {
        System.out.println("Testing ConvertToComplexOnlyImg method");
        c.convertToComplexOnlyImg("3j");
        assertEquals(3.0,c.getImgPart());
        assertEquals(0,c.getRealPart());
    }
    /**
     * Test of convertToComplexOnlyImg method, with a double as an input.

     */
    @Test
    public void testConvertToComplexOnlyImg2() {
        System.out.println("Testing ConvertToComplexOnlyImg method");
        c.convertToComplexOnlyImg("53.9j");
        assertEquals(53.9,c.getImgPart());
        assertEquals(0,c.getRealPart());
    }
    /**
     * Test of convertToComplexOnlyImg method, with negative double number as an input.

     */
    @Test
    public void testConvertToComplexOnlyImg3() {
        System.out.println("Testing ConvertToComplexOnlyImg method");
        c.convertToComplexOnlyImg("-3.6j");
        assertEquals(-3.6,c.getImgPart());
        assertEquals(0,c.getRealPart());
    }
    /**
     * Test of convertToComplex method, positive number with only real part.
     */
    @Test
    public void testConvertToComplex1() {
        System.out.println("Testing ConvertToComplex method");
        c.convertToComplex("30");
        assertEquals(30,c.getRealPart());
        assertEquals(0,c.getImgPart());
    }
    /**
     * Test of convertToComplex method, negative number with only real part.
     */
    @Test
    public void testConvertToComplex2() {
        System.out.println("Testing ConvertToComplex method");
        c.convertToComplex("-30");
        assertEquals(-30,c.getRealPart());
        assertEquals(0,c.getImgPart());
    }
    /**
     * Test of convertToComplex method, double number with only real part.
     */
    @Test
    public void testConvertToComplex3() {
        System.out.println("Testing ConvertToComplex method");
        c.convertToComplex("30.25");
        assertEquals(30.25,c.getRealPart());
        assertEquals(0,c.getImgPart());
    }
    /**
     * Test of convertToComplex method, negative double number with only real part.
     */
    @Test
    public void testConvertToComplex4() {
        System.out.println("Testing ConvertToComplex method");
        c.convertToComplex("-30.25");
        assertEquals(-30.25,c.getRealPart());
        assertEquals(0,c.getImgPart());
    }
    
    /**
     * Test of convertToComplex method, with a complex number that start with +.
     */
    @Test
    public void testConvertToComplex5() {
        System.out.println("Testing ConvertToComplex method");
        c.convertToComplex("+2+4j");
        assertEquals(2,c.getRealPart());
        assertEquals(4,c.getImgPart());
        
    }
    
    /**
     * Test of convertToComplex method, with a complex number that start with -.
     */
    @Test
    public void testConvertToComplex6() {
        System.out.println("Testing ConvertToComplex method");
        c.convertToComplex("-2+4j");
        assertEquals(-2,c.getRealPart());
        assertEquals(4,c.getImgPart());
        
    }
    /**
     * Test of convertToComplex method, with a complex number that start with out a sign.
     */
    @Test
    public void testConvertToComplex7() {
        System.out.println("Testing ConvertToComplex method");
        c.convertToComplex("2+4j");
        assertEquals(2,c.getRealPart());
        assertEquals(4,c.getImgPart());
        
    }
    /**
     * Test of convertToComplex method, with a complex number that has negative img part.
     */
    @Test
    public void testConvertToComplex8() {
        System.out.println("Testing ConvertToComplex method");
        c.convertToComplex("+2-4j");
        assertEquals(2,c.getRealPart());
        assertEquals(-4,c.getImgPart());
        
    }
    /**
     * Test of convertToComplex method, with a complex number that has negative img and real part.
     */
    @Test
    public void testConvertToComplex9() {
        System.out.println("Testing ConvertToComplex method");
        c.convertToComplex("-2-4j");
        assertEquals(-2,c.getRealPart());
        assertEquals(-4,c.getImgPart());
        
    }
    /**
     * Test of convertToComplex method, with a complex number that has only +j as img part.
     */
    @Test
    public void testConvertToComplex10() {
        System.out.println("Testing ConvertToComplex method");
        c.convertToComplex("2+j");
        assertEquals(2,c.getRealPart());
        assertEquals(1,c.getImgPart());
        
    }
    /**
     * Test of convertToComplex method, with a complex number that has only -j as img part.
     */
    @Test
    public void testConvertToComplex11() {
        System.out.println("Testing ConvertToComplex method");
        c.convertToComplex("2-j");
        assertEquals(2,c.getRealPart());
        assertEquals(-1,c.getImgPart());
        
    }
    /**
     * Test of equals method, with 2 equals numbers.
     */
    @Test
    public void testEquals1(){
        System.out.println("Testing Equals method");
        ComplexNumber c1 = new ComplexNumber(1,1);
        ComplexNumber c2 = new ComplexNumber(1,1);
        boolean bool = c1.equals(c2); 
        assertEquals(bool,true);
    }
    
    /**
     * Test of equals method, with 2 differents numbers.
     */
    @Test
    public void testEquals2(){
        System.out.println("Testing Equals method");
        ComplexNumber c1 = new ComplexNumber(1,1);
        ComplexNumber c2 = new ComplexNumber(1,0);
        boolean bool = c1.equals(c2); 
        assertEquals(bool,false);
    }
    /**
     * Test of equals method, with 2 equals numbers.
     */
    @Test
    public void testEquals3(){
        System.out.println("Testing Equals method");
        ComplexNumber c1 = new ComplexNumber(-1,-1);
        ComplexNumber c2 = new ComplexNumber(-1,-1);
        boolean bool = c1.equals(c2); 
        assertEquals(bool,true);
    }
    /**
     * Test of equals method, with 2 differents numbers.
     */
    @Test
    public void testEquals4(){
        System.out.println("Testing Equals method");
        ComplexNumber c1 = new ComplexNumber(-1,-1);
        ComplexNumber c2 = new ComplexNumber(1,1);
        boolean bool = c1.equals(c2); 
        assertEquals(bool,false);
    }
    
}
