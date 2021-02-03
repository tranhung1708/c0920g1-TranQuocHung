package session_6.BaiTap;

public class CircleLayer {
    private String color = "red";
    private double radius = 10.0;

    public CircleLayer(String color, double radius) {
        this.color = color;
        this.radius = radius;
    }

    public CircleLayer() {
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return this.radius * this.radius *Math.PI;
    }

    @Override
    public String toString() {
        return "CircleLayerAndCylinderLayer{" +
                "color='" + color + '\'' +
                ", radius=" + radius +
                '}';
    }
}
