import java.util.logging.*;

public class Number {
    private  double value;
    private static final Logger logger = Logger.getLogger(Number.class.getName());

    public Number(double value) {
    this.value=value;
        logger.log(Level.INFO, "Number object created with value: " + value);
    }

    public boolean isZero(){

        return value==0;
    }

    public boolean isPositive(){
        return value >0;
    }

    public boolean isNegative(){
        return value<0;

    }

    public  boolean isOdd(){

        return value % 2 != 0;
    }

    public  boolean isEven(){
        return  value %2 ==0;

    }

    public boolean isPrime(){

        if (value <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(value); i++) {
            if (value % i == 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isAmstrong() {
        double sum = 0;
        double temp = value;
        while (temp != 0) {
            double digit = temp % 10;
            sum += Math.pow(digit, 3);
            temp /= 10;
        }
        return sum == value;
    }
    public double getFactorial() {
        double result = 1;
        for (int i = 2; i <= value; i++) {
            result *= i;
        }
        return result;
    }

    public double getSqrt() {
        return Math.sqrt(value);
    }

    public double getSqr() {
        return value * value;
    }

    public double sumDigits() {
        double sum = 0;
        double temp = value;
        while (temp != 0) {
            double digit = temp % 10;
            sum += digit;
            temp /= 10;
        }
        return sum;
    }

    public double getReverse() {
        String valueStr = String.valueOf(value);
        String reversedStr = new StringBuilder(valueStr).reverse().toString();
        return Double.parseDouble(reversedStr);
    }






    public static void main(String[] args) {
 Number num = new Number(111.24);
        logger.log(Level.INFO, "isZero: " + num.isZero());
        logger.log(Level.INFO, "isPositive: " + num.isPositive());
        logger.log(Level.INFO, "isNegative: " + num.isNegative());
        logger.log(Level.INFO, "isOdd: " + num.isOdd());
        logger.log(Level.INFO, "isEven: " + num.isEven());
        logger.log(Level.INFO, "isPrime: " + num.isPrime());
        logger.log(Level.INFO, "isAmstrong: " + num.isAmstrong());
        logger.log(Level.INFO, "getFactorial: " + num.getFactorial());
        logger.log(Level.INFO, "getSqrt: " + num.getSqrt());
        logger.log(Level.INFO, "getSqr: " + num.getSqr());
        logger.log(Level.INFO, "sumDigits: " + num.sumDigits());
        logger.log(Level.INFO, "getReverse: " + num.getReverse());

    }
}
