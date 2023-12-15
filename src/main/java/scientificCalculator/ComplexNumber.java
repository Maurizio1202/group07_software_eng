package scientificCalculator;

/**
 *
 * @author group_07
 * 
 * ComplexNumber defines the entity of the complex number for the
 * scientific calculator. Also defines the parsing methods to be
 * used in class ScientificCalculator
 */

public class ComplexNumber {
    
    private double realPart;
    private double imgPart;
    

    public ComplexNumber(double realPart, double imgPart) {
        this.realPart = realPart;
        this.imgPart = imgPart;
    }

    
    public double getRealPart() {
        return realPart;
    }

    
    public double getImgPart() {
        return imgPart;
    }
    
    
    //parsing for onlyJ_number
    public void convertToComplexOnlyJ(String input) {

        if (input.equals("j")) {
            this.imgPart = 1.0;
            this.realPart = 0.0;

        } else if (input.equals("+j")) { 
            this.imgPart = 1.0;
            this.realPart = 0.0;

        } else if (input.equals("-j")) {
            this.imgPart = -1.0;
            this.realPart = 0.0;
        }
        
    }
    
    
    //parsing for onlyImg_pat
    public void convertToComplexOnlyImg(String input) {
        
        //RealPart = 0 
        this.realPart = 0;        
        
        //removes j
        input = input.replace("j", "");
        
        //converts in double
        this.imgPart = Double.parseDouble(input);
        
    }
    
    
    //parsing for complex_number 
    //does not include imaginary_number and onlyJ_number
    public void convertToComplex(String input) {
        
        //if the number has only the real part
        if(! input.contains("j")){       
            this.realPart = Double.parseDouble(input);
            this.imgPart = 0.0;
        }
        //the number has both imaginary and real part
        else{ 
            //verifies the presence of + o - at the begining of the string
            boolean hasPlus = input.startsWith("+");
            boolean hasMinus = input.startsWith("-");
            
            //removes sign in the real part if present
            if(hasPlus || hasMinus){
                input = input.substring(1);
            }
            
            //divides input into real part and imaginary part
            // splits the string from the +,- ("2+3j" becomes "2" e "+3j")
            String[] parts = input.split("(?=[+-])", 2);   
            
            //converts real part in double  (pats[0])
            double realPart = Double.parseDouble(parts[0]);
                        
            //if imaginary part is only composed by j changes j with 1
            if( parts[1].matches("^[j]$"))
                parts[1] = parts[1].replace("j", "1");
            //if imaginary part is only +j changes +j with 1
            else if(parts[1].matches("^[+][j]$")) 
                parts[1] = parts[1].replace("+j", "1");
            //if imaginary part is only -j changes -j with -1
            else if(parts[1].matches("^[-][j]$")) 
                parts[1] = parts[1].replace("-j", "-1");
            //otherwise changes j in ""
            else    
                parts[1] = parts[1].replace("j", "");
            
            //assigns sign to the real part if present
            if(hasMinus)
                this.realPart = -(realPart);
            else
                this.realPart = realPart;
            
            //converts in double imaginary part
            this.imgPart = Double.parseDouble(parts[1]);           
        }
        
    }
    

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ComplexNumber other = (ComplexNumber) obj;

        // Use a small epsilon value for comparison
        double epsilon = 1e-8;

        return Math.abs(this.realPart - other.realPart) < epsilon && Math.abs(this.imgPart - other.imgPart) < epsilon;
    }
    
}
