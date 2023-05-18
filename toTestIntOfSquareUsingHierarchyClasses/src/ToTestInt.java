import java.util.*;
import java.util.logging.Logger;

interface test {
    double Square(double side);
}
class Arithmetic implements test {  //implemented interface in the class
    private static Logger logger = Logger.getLogger(Arithmetic.class.getName());

    @Override
    public double Square(double side) {
        double result = side * side;
        logger.info("Square of side " + side +" is " + result );
        return result;
    }
}



public class ToTestInt {  // created a new class which used implemented classes
    public static void main(String[] args) {
     Arithmetic arithmetic = new Arithmetic();
     double number =5.25;
     double result = arithmetic.Square(number);

    }
}
