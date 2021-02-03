package session_6.BaiTap;

public class Shape extends Triangle {
    private String color = "blue";
    private String color1 = "red";

    public Shape(String color, String color1) {
        this.color = color;
        this.color1 = color1;
    }

    public Shape(double size1, double size2, double size3, String color, String color1) {
        super(size1, size2, size3);
        this.color = color;
        this.color1 = color1;
    }

    public Shape() {
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor1() {
        return color1;
    }

    public void setColor1(String color1) {
        this.color1 = color1;
    }

    @Override
    public String toString() {
        return "Shape{" +
                "color='" + color + '\'' +
                ", color1='" + color1 + '\'' +
                  " chu vi  " + getPerimeter()
                  +" , diện tích " +getArea()+
                "   "+super.toString()+
                '}';
    }

    public static void main(String[] args) {
        Shape shape = new Shape("yellow","black");
        System.out.println(shape);
    }
}
