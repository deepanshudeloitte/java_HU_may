import java.util.logging.Logger;

public class usingCallByValue {
    static final Logger logger = Logger.getLogger(usingCallByValue.class.getName());


   public static void callingValueFunction(int data){
        data = data+100;
       logger.info("while  calling function = " + data + '\n'); //value changes only in local variable
    }

    public static void main(String[] args) {
        int number =50;
       logger.info("Before calling function = " + number + "\n");
        callingValueFunction(number);
       logger.info("After calling function = " + number);
    }
}
