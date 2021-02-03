package session_4.BaiTap;

public class XayDungLopFan {
    final int SLOW = 1;
    final int MEDIUM = 2;
    final int FAST = 3;
    private int SPEED = SLOW;
    private boolean on = false;
    private double radius = 5;
    private String color = "blue";

    public XayDungLopFan(int SPEED, boolean on, double radius, String color) {
        this.SPEED = SPEED;
        this.on = on;
        this.radius = radius;
        this.color = color;
    }

    public XayDungLopFan() {
    }

    public int getSPEED() {
        return SPEED;
    }

    public boolean isOn() {
        return on;
    }

    public double getRadius() {
        return radius;
    }

    public String getColor() {
        return color;
    }

    public void setSPEED() {
        this.SPEED = SPEED;
    }

    public void setOn() {
        this.on = on;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String toString() {
        if (this.on == true) {
            return "fan is on " + " toc do " + this.SPEED + " mau sac " + this.color + " radius " + this.radius;
        } else {
            return "fan is off " + " mau sac " + this.color + " radius " + this.radius;
        }
    }

    public static void main(String[] args) {
        XayDungLopFan xayDungLopFan1 = new XayDungLopFan(1, true, 10, "yellow");
        xayDungLopFan1.isOn();
        System.out.println(xayDungLopFan1.toString());
        XayDungLopFan xayDungLopFan = new XayDungLopFan(2, false, 5, "blue");
        xayDungLopFan.isOn();
        System.out.println(xayDungLopFan.toString());
    }
}
