package session_5.BaiTap;

import session_5.BaiTap.AccsessModifier;

public class TestCircle {
    public static void main(String[] args) {
        AccsessModifier circle = new AccsessModifier("red", 1.0);
        System.out.println(circle.getArea() + " and " + circle.getRadius());
    }

}
