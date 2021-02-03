package session_7.BaiTap;

public class TestColorable {
    public static void main(String[] args) {
   Shape[] shapes = new Shape[3];
    shapes[0] = new Circle();
    shapes[1] = new Rectangle();
    shapes[2] = new Square();
    for (Shape circle : shapes){
        if (circle instanceof Rectangle){
            Shape shape = (Rectangle) circle;
            System.out.println(shape.howToColor());
        }
    }
    }
}
