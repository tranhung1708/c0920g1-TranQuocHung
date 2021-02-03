package session_6.BaiTap;

import java.util.Arrays;

public class Point3d extends Point2d{
    private float z = 0.0f;


    public Point3d(float z ) {
        this.z = z;
    }


    public Point3d() {
    }

    public float getZ() {
        return z;
    } 

    public void setZ(float z) {
        this.z = z;
    }
    public float[] getXYZ(){
      return new float[]{getX(), getY(),this.z};
    }

    @Override
    public String toString() {
        return "Point3d{" +
                "z=" + z +
                ", XYZ=" + Arrays.toString(getXYZ()) +
                super.toString()+
                '}';
    }

    public static void main(String[] args) {
        Point3d point3d = new Point3d(0.1f);
        System.out.println(point3d);
        Point3d point3d1 = new Point3d(0.1f);
    }
}
