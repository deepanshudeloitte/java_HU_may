interface test {
    int Square(int side);
}
class Arithmetic implements test{  //implemented interface in the class


    public int Square(int side) {
        return side*side;
    }
}


public class ToTestInt {  // created a new class which used implemented classes
    public static void main(String[] args) {
     Arithmetic arithmetic = new Arithmetic();
     int number =5;
     int result = arithmetic.Square(number);
        System.out.println("square of the "+ number + " is " + result);
    }
}
