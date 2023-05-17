public class usingCallByValue {


   public static void callingValueFunction(int data){
        data = data+100;
       System.out.println("while  calling function = " + data + '\n'); //value changes only in local variable
    }

    public static void main(String[] args) {
        int number =50;
        System.out.println("Before calling function = " + number + "\n");
        callingValueFunction(number);
        System.out.println("After calling function = " + number);
    }
}
