package session_14.BaiTap;

import java.io.IOException;

public class test2 {
    public static void main(String[] args) throws IllegalTriangleException {
        Triangle triangle = null;
        try {
            triangle =new Triangle(1,3,3);
        }catch (NullPointerException e){
            System.out.println(e);
        }finally {
            System.out.println(triangle.getCanhA()+triangle.getCanhB());
        }
        System.out.println("Hello work");
    }
}
