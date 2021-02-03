package session_5.BaiTap;

public class AccsessModifier {
    private String color = "red";
    private double radius = 1.0;

    public AccsessModifier(String color, double radius) {
        this.color = color;
        this.radius = radius;
    }

    public AccsessModifier() {
    }

    public double getRadius() {
        return radius;
    }

    public String getColor() {
        return color;
    }
    public void setRadius(double radius){
        this.radius = radius;
    }
    public double getArea(){
        return this.radius * 2 * Math.PI;
    }
}
