package session_5;

public class StaticMethod {
    public static class Student {
        private int rollno;
        private String name;
        private static String college = "BBDIT";

        //hàm tạo để khởi tạo biến
        Student(int r, String n) {
            rollno = r;
            name = n;
        }

        //phương thức static để thay đổi giá trị của biến static
        static void change() {
            college = "CODEGYM";
        }

        //phương pháp hiển thị giá trị
        void display() {
            System.out.println(rollno + " " + name + " " + college);
        }
    }

    public static class TestStaticMethod {
        public static void main(String args[]) {
            Student.change();
            //gọi phương thức thay đổi

            //tạo đối tượng
            Student s1 = new Student(111, "Hoang");
            Student s2 = new Student(222, "Khanh");
            Student s3 = new Student(333, "Nam");

            //gọi phương thức hiển thị
            s1.display();
            s2.display();
            s3.display();
        }
    }
}
