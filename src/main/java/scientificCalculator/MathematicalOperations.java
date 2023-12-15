package scientificCalculator;

import calculatorExceptions.*;
import java.util.Deque;

/**
 *
 * @author group_07
 * 
 * This class defines all the mathematical operations of the calculator:
 * sum, sub, product, division, squareRoot, signReversal, sin, cos, tan,
 * log, ln, exp.
 * 
 */
public class MathematicalOperations {
    
    private Deque<ComplexNumber> stack;

    
    public MathematicalOperations(Deque<ComplexNumber> stack) {
        
        this.stack = stack;
    }
    
    
    // Adds a ComplexNumber onto the stack    
    public void insertion(ComplexNumber z) {
        
        stack.addFirst(z);
    }
    
    
    //Sums the last two ComplexNumbers of the stack
    //Throws NotEnoughElementException if there are less than
    //two numbers in the stack    
    public void sum(){
        
        if(stack.size() < 2 )
            throw new NotEnoughElementException();
        
        ComplexNumber n1 = stack.removeFirst();
        ComplexNumber n2 = stack.removeFirst();
        
        stack.addFirst(new ComplexNumber(n1.getRealPart() + n2.getRealPart(), n1.getImgPart() + n2.getImgPart()));
        
    }
    
    
    //Subtracts the last two ComplexNumbers of the stack
    //Throws NotEnoughElementException if there are less than
    //two numbers in the stack    
    public void sub(){
        
        if(stack.size() < 2 )
            throw new NotEnoughElementException();
        
        ComplexNumber n1 = stack.removeFirst();
        ComplexNumber n2 = stack.removeFirst();
        
        stack.addFirst(new ComplexNumber(n2.getRealPart() - n1.getRealPart(), n2.getImgPart() - n1.getImgPart()));
        
    }
    
    
    //Multiplies the last two ComplexNumbers of the stack
    //Throws NotEnoughElementException if there are less than
    //two numbers in the stack   
    public void product() {
        if (stack.size() < 2) {
        throw new NotEnoughElementException();
    }

        ComplexNumber n1 = stack.removeFirst();
        ComplexNumber n2 = stack.removeFirst();

        double re = n1.getRealPart() * n2.getRealPart() - n1.getImgPart() * n2.getImgPart();
        double im = n1.getRealPart() * n2.getImgPart() + n1.getImgPart() * n2.getRealPart();

        ComplexNumber result = new ComplexNumber(re, im);

        stack.addFirst(result);
    }
    
    
    //Divides the last two ComplexNumbers of the stack
    //Throws NotEnoughElementException if there are less than
    //two numbers in the stack
    //Throws DivideByZeroException if thre is a division by zero   
    public void division() {
        if (stack.size() < 2) {
            throw new NotEnoughElementException();
        }

        ComplexNumber divisor = stack.removeFirst();
        ComplexNumber dividend = stack.removeFirst();

        double divisorSquared = divisor.getRealPart() * divisor.getRealPart() + divisor.getImgPart() * divisor.getImgPart();

        if (divisorSquared == 0) {
            throw new DivideByZeroException();
        }

        double re = (dividend.getRealPart() * divisor.getRealPart() + dividend.getImgPart() * divisor.getImgPart()) / divisorSquared;
        double im = (dividend.getImgPart() * divisor.getRealPart() - dividend.getRealPart() * divisor.getImgPart()) / divisorSquared;

        ComplexNumber result = new ComplexNumber(re, im);
        stack.addFirst(result);
    }

    
    
    //Evaluetes the square root of the last element of the stack
    //throws EmptyStackException if the stack is empty 
    public void squareRoot(){
        
        if(stack.size() < 1)
            throw new EmptyStackException();
        
        ComplexNumber n1 = stack.removeFirst();
        
        double modulo = Math.sqrt(n1.getRealPart() * n1.getRealPart() + n1.getImgPart() * n1.getImgPart());
        double re = Math.sqrt((modulo + n1.getRealPart() ) / 2);
        double im = (n1.getImgPart() >= 0) ? Math.sqrt((modulo - n1.getRealPart()) / 2) : -Math.sqrt((modulo - n1.getRealPart()) / 2);

        ComplexNumber result = new ComplexNumber(re, im);  
        
        stack.addFirst(result);
        
    }
    
    
    //Inverts the sign of a complex number pulled from the top of the stack.
    //Throws EmptyStackException if the stack is empty
    public void signReversal(){
        
        if(stack.size() < 1)
            throw new EmptyStackException();
        
        ComplexNumber n1 = stack.removeFirst();
        
        stack.addFirst(new ComplexNumber(-n1.getRealPart(), -n1.getImgPart()));
        
    }
    
    
    //Evaluates the sin of the complex number pulled from the top of the stack
    //Throws EmptyStackException if the stack is empty
    public void sin(){
        
        if(stack.size() < 1)
            throw new EmptyStackException();
        
        ComplexNumber n1 = stack.removeFirst();
        
        double re = n1.getRealPart();
        double im = n1.getImgPart();

        double sinRe = Math.sin(re);
        double coshIm = Math.cosh(im);
        double cosRe = Math.cos(re);
        double sinhIm = Math.sinh(im);

        double reSin = sinRe * coshIm;
        double imSin = cosRe * sinhIm;

        ComplexNumber result = new ComplexNumber(reSin, imSin); 
        
        stack.addFirst(result);
        
    }
    
    
    //Evaluates the cos of the complex number pulled from the top of the stack
    //Throws EmptyStackException if the stack is empty.
    public void cos(){
        
        if(stack.size() < 1)
            throw new EmptyStackException();
        
        ComplexNumber n1 = stack.removeFirst();
        
        double cosRe = Math.cos(n1.getRealPart());
        double coshIm = Math.cosh(n1.getImgPart());
        double sinRe = Math.sin(n1.getRealPart());
        double sinhIm = Math.sinh(n1.getImgPart());

        double reCos = cosRe * coshIm;
        double imCos = -sinRe * sinhIm;

        ComplexNumber result = new ComplexNumber(reCos, imCos);  
        
        stack.addFirst(result);
        
    } 
    
    
    //Evaluates the cos of the complex number pulled from the top of the stack
    //Throws EmptyStackException if the stack is empty.
    //Throws DivideByZeroException if there is a division by zero
    //Throws 
    public void tan(){
        
        if(stack.size() < 1)
            throw new EmptyStackException();
        
        ComplexNumber n1 = stack.removeFirst();
        stack.addFirst(n1);
        stack.addFirst(n1);
        sin();
        ComplexNumber sin = stack.removeFirst();
        cos();
        ComplexNumber cos = stack.removeFirst();

        if (cos.getRealPart() == 0 && cos.getImgPart() == 0) {
            throw new DivideByZeroException();          
        }
        try{
            stack.addFirst(sin);
            stack.addFirst(cos);
            division(); 
            ComplexNumber result = stack.removeFirst();
            stack.addFirst(result); 
            
        }catch(DivideByZeroException ex){            
            System.out.println("Errore " + ex.getMessage());
            return;
        }
    }
    
    
    //Returns the modulus of a complex number 
    private double modulus(ComplexNumber z){
        
        return Math.sqrt(z.getRealPart() * z.getRealPart() + z.getImgPart() * z.getImgPart());
        
    }
    
    
    //evaluates the ln of the ComplexNumber pulled from the top of the stack
    //Throws EmptyStackException if the stack is empty
    //Throws WrongArgumentLogException if the module of ComnplexNumber = 0
    public void ln(){
        
        if(stack.size() < 1)
            throw new EmptyStackException();
        
        ComplexNumber n1 = stack.removeFirst();
        
        if(modulus(n1) == 0)
            throw new WrongArgumentLogException();
        
        double re = n1.getRealPart();
        double im = n1.getImgPart();
        
        double mod = Math.sqrt(re * re + im * im);
        double arg = Math.atan2(im, re);

        double reLn = Math.log(mod);
        double imLn = arg;

        ComplexNumber result = new ComplexNumber(reLn, imLn);  
        stack.addFirst(result);               
        
    }
    
    
    //Evaluates the log base 10 of the ComplexNumber pulled from the top of the stack
    //Throws EmptyStackException if the stack is empty
    //Throws WrongArgumentLogException if imPart and rePart = 0
    public void log(){

            if (stack.size() < 1) {
        throw new EmptyStackException();
        }

        ComplexNumber n1 = stack.removeFirst();

        double re = n1.getRealPart();
        double im = n1.getImgPart();

        double mod = Math.sqrt(re * re + im * im);
        double arg = Math.atan2(im, re);

        double reLog, imLog;
        
        if(re == 0 && im == 0) {
            throw new WrongArgumentLogException();
        }
        
        else if (re == 0) {
            reLog = Math.log10(mod);
            imLog = Math.PI / 2.0; 
        }
                
        else if (re > 0) {
            reLog = Math.log10(mod);
            imLog = arg;
        } 
        else if (re < 0 && im == 0) {
            reLog = Math.log10(mod);
            imLog = Math.PI * 1.0;
        } 
        else if (re < 0 && im > 0) {
            reLog = Math.log10(mod);
            imLog = arg + 2 * Math.PI;
        } 
        else if (re < 0 && im < 0) {
            reLog = Math.log10(mod);
            imLog = arg - 2 * Math.PI;
        }
        else {
            reLog = Math.log10(mod);
            imLog = arg;
        }
        ComplexNumber result = new ComplexNumber(reLog, imLog);
        stack.addFirst(result);
    }    
    
    
    //Evaluates the exp of the ComplexNumber pulled from the top of the stack
    //Throws EmptyStackException if the stack is empty.
    public void exp(){
        
        if(stack.size() < 1)
            throw new EmptyStackException();
        
        ComplexNumber n1 = stack.removeFirst();
        
        double re = n1.getRealPart();
        double im = n1.getImgPart();

        double expRe = Math.exp(re);
        double cosIm = Math.cos(im);
        double sinIm = Math.sin(im);

        double reExp = expRe * cosIm;
        double imExp = expRe * sinIm;

        ComplexNumber result = new ComplexNumber(reExp, imExp);  
        stack.push(result);  
        
    }
    
 
}
