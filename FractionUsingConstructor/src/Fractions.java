import java.util.logging.Logger;

class Fraction {
    private int numerator;
    private int denominator;
     private static final Logger logger=Logger.getLogger(Fractions.class.getName());

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Fraction(int numerator) {
        this(numerator, 1); // Sets denominator to 1 by default
    }

    public Fraction() {
        this(0, 1); // Sets numerator to 0 and denominator to 1 by default
    }

    public void displayFraction() {
        //logger.info(numerator + "/" + denominator);
        double decimalValue = (double) numerator / denominator;
        logger.info( numerator + "/" + denominator + " = " + decimalValue);
    }

    public void displayDecimalValue() {
        double decimalValue = (double) numerator / denominator;
       logger.info( numerator + "/" + denominator + " = " + decimalValue);
    }
}

public class Fractions {
    public static void main(String[] args) {
        Fraction fraction1 = new Fraction(3, 4);
        Fraction fraction2 = new Fraction(5);
        Fraction fraction3 = new Fraction();

        fraction1.displayFraction();
        fraction2.displayFraction();
        fraction3.displayFraction();


    }
}
