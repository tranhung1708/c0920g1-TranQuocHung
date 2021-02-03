package session_7.BaiTap;

public class ResizeableTest {
    public static void main(String[] args) {
        double percent = Math.random() * 100;
        Resizeable[] resizeable = new Resizeable[3];
        resizeable[0] = new Circle();
        resizeable[1] = new Square();
        resizeable[2] = new Rectangle();
        System.out.println("Mảng trước khi tăng : ");
        for (Resizeable Circle : resizeable) {
            System.out.println(Circle);
        }
        System.out.println("Mảng sau khi tăng : ");
        for (Resizeable Circle : resizeable) {
            Circle.resize(percent);
            System.out.println(Circle);

        }
    }
}
