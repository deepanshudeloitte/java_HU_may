import java.util.logging.Logger;

class Intwrapper{
    int value;
     public Intwrapper(int value){
         this.value=value;
     }
}


public class usingCallByReference {
    public static void main(String[] args) {
       final Logger logger = Logger.getLogger(usingCallByValue.class.getName());
        Intwrapper wrapper = new Intwrapper(10);

      logger.info("Before calling value = " + wrapper.value );
        increment(wrapper);
       logger.info("After calling Value = " + wrapper.value);


    }
    public static void increment(Intwrapper wrapper){
        wrapper.value++;
        final Logger logger = Logger.getLogger(usingCallByValue.class.getName());
      logger.info("while calling function value = " + wrapper.value);

    }
}
