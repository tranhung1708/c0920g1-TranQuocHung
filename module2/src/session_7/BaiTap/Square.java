package session_7.BaiTap;

public class Square extends Shape implements Resizeable , Colorable{
    public double side;
    public Square() {
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    public Square(double side) {
        this.side = side;
    }

    public Square(String color, boolean filled, double side) {
        super(color, filled);
        this.side = side;
    }
    public double getArea() {
        return this.side * this.side;
    }

    @Override
    public String toString() {
        return "Area Square : " + getArea();
    }

    @Override
    public void resize(double percent) {
        setSide(getSide()*percent);
    }

    @Override
    public String howToColor() {
        return "Color all four sides";
    }
}
