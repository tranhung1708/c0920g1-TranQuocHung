package session_6.BaiTap;

import java.awt.*;

public class MoveablePoint extends point {
    private float xSpeed = 0.2f;
    private float ySpeed = 0.4f;

    public MoveablePoint(float x, float y, float xSpeed, float ySpeed) {
        super(x, y);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public MoveablePoint(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public MoveablePoint() {
    }

    public float getxSpeed() {
        return xSpeed;
    }

    public void setxSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }

    public float getySpeed() {
        return ySpeed;
    }

    public void setySpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }
    public MoveablePoint move(){
        setX(getX()+ xSpeed);
        setY(getY()+ySpeed);
        return this;
    }

    @Override
    public String toString() {
        return "MoveablePoint{" +
                "xSpeed=" + xSpeed +
                ", ySpeed=" + ySpeed +
                "   "+super.toString()+
                '}';
    }

    public static void main(String[] args) {
        MoveablePoint moveablePoint = new MoveablePoint(0.7f,0.4f,0.2f,0.5f);
        System.out.println(moveablePoint);
        System.out.println(moveablePoint.move());
    }
}
