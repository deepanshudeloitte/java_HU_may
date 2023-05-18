import java.util.logging.Logger;

class Box{
    private double length;
    private double breadth;

    private static final Logger logger = Logger.getLogger(Box.class.getName());

    public Box(double length, double breadth){
        this.length=length;
        this.breadth=breadth;
    }
    public void setLength(double length){
        this.length=length;
    }
    public void setBreadth(double breadth){
        this.breadth=breadth;
    }
    public double getLength(){
        return length;
    }
    public double getBreadth(){
        return breadth;
    }
    public double calculateArea(){
     double area = length*breadth;
     logger.info("the area of box is " + area);
     return area;
    }
}

class box3d extends Box{

   private double height;
    public box3d(double length, double breadth,double height) {
        super(length, breadth);
        this.height=height;
    }
    public void setheight(){
        this.height=height;
    }
    public double getheight(){
        return height;
    }

    public double calculateVolume(){
        double volume = getLength() *getBreadth() *height;
        Logger.getLogger(box3d.class.getName()).info("volume of box is " + volume);
        return volume;
    }
}
public class MainClass {
    public static void main(String[] args) {
        box3d box3dObject = new box3d(5.0,2.0,3.3);

        box3dObject.calculateArea();
        box3dObject.calculateVolume();
    }
}
