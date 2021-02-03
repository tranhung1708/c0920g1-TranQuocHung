package session_6.BaiTap;

public class Cylinder extends CircleLayer {
    private double height = 10.1;

    public Cylinder(String color, double radius, double height) {
        super(color, radius);
        this.height = height;
    }

    public Cylinder() {
    }

    public Cylinder(double height) {
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String toString (){
        return " A circle width radius =  "
                + getRadius()
                + " height "
                + getHeight()
                + " which is a cylinder "
                + super.toString();
    }

    public static void main(String[] args) {
        Cylinder cylinder = new Cylinder("black",70.1,90 );
        System.out.println(cylinder);
        cylinder = new Cylinder("blue",20,50);
        System.out.println(cylinder);;
        cylinder = new Cylinder("red",30.,20);
        System.out.println(cylinder);
    }
}
