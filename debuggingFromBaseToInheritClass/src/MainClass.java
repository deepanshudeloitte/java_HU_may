import java.util.*;
import java.util.logging.Logger;

class BaseClass{
    private static Logger logger = Logger.getLogger(BaseClass.class.getName());

    public void debugg(){
        logger.info("debugging.............");

    }
}
class newClass1 extends BaseClass{
//class implementation
}

class newClass2 extends BaseClass{
//class implementation
}
class newClass3 extends BaseClass{
//class implementation
}

public class MainClass {
    public static void main(String[] args) {
        newClass1 object1 = new newClass1();
        newClass2 object2 = new newClass2();
        newClass3 object3= new newClass3();

        object1.debugg();
        object2.debugg();
        object3.debugg();


    }
}
