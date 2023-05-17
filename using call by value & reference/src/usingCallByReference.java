class Intwrapper{
    int value;
     public Intwrapper(int value){
         this.value=value;
     }
}


public class usingCallByReference {
    public static void main(String[] args) {
        Intwrapper wrapper = new Intwrapper(10);
        System.out.println("Before calling value = " + wrapper.value );
        increment(wrapper);
        System.out.println("After calling Value = " + wrapper.value);


    }
    public static void increment(Intwrapper wrapper){
        wrapper.value++;
        System.out.println("while calling function value = " + wrapper.value);

    }
}
