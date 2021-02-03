package Test3;

import org.omg.CORBA.MARSHAL;

import java.util.Scanner;

public class MainManager1 {
    public static Scanner scanner = new Scanner(System.in);
    public static String choose = "0";
    public static String choose1 = "0";

    public static void main(String[] args) {
        menu();
    }
    public static void menu(){
        do {
            System.out.println("1.Thêm");
            System.out.println("2.Xóa");
            System.out.println("3.Sửa");
            System.out.println("4.Hiển thị");
            System.out.println("5.Exit");
            choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    System.out.println("1.Thêm giáo viên ");
                    System.out.println("2.Thêm học sinh");
                    choose1 = scanner.nextLine();
                    switch (choose1) {
                        case "1":
                            Manager.addNewGiaoVien();
                            break;
                        case "2":
                            Manager.addNewHocSinh();
                    }
                    break;
                case "2":
                    System.out.println("1.Xóa tên giáo viên");
                    System.out.println("2.Xóa tên học viên");
                    choose1 = scanner.nextLine();
                    switch (choose1) {
                        case "1":
                            Manager.deleteGiaoVien();
                            break;
                        case "2":
                            Manager.deleteHocSinh();
                            break;
                    }
                    break;
                case "3":
                    System.out.println("1.Tên giáo viên muốn sửa");
                    System.out.println("2.Tên học viên muốn sửa");
                    choose1 = scanner.nextLine();
                    switch (choose1){
                        case "1":Manager.editGiaoVien();
                            break;
                        case "2":Manager.editHocSinh();
                            break;
                    }
                    break;
                case "4":
                    System.out.println("1.Hiển thị danh sách giáo viên");
                    System.out.println("2.Hiển thị danh sách học sinh ");
                    System.out.println("3.Hiển thị danh sách giáo viên TreeSet ");
                    System.out.println("4.Hiển thị danh sách học sinh TreeSet ");
                    choose1 = scanner.nextLine();
                    switch (choose1){
                        case "1":Manager.hienThiDanhSachGV();
                            break;
                        case "2":Manager.hienThiDanhSachHS();
                            break;
                        case "3":Manager.hienThiDanhSachTreeSet();
                            break;
                        case "4":Manager.hienThiDanhSachHocSinhTS();
                            break;
                    }
                    break;
                case "5":System.exit(4);
            }
        } while (true);
    }
}
