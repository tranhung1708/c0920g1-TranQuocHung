package Test2;

import java.util.Scanner;

public class MainManager {
    public static String choose = "0";
    public static String choose1 = "0";
    public static String choose2 = "0";
    public static String choose3 = "0";
    public static String choose4 = "0";
    public static String choose5 = "0";
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        do {
            System.out.println("1.Thêm sản phẩm");
            System.out.println("2.Sửa id sản phẩm");
            System.out.println("3.Xóa sản phẩm");
            System.out.println("4.Hiển thị sản phẩm");
            System.out.println("5.Tìm kiếm sản phẩm");
            System.out.println("6.Exit");
            choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    System.out.println("Mời bạn chọn 1 hoặc 2");
                    System.out.println("1.Thêm sản phẩm nhập khẩu");
                    System.out.println("2.Thêm sản phẩm xuất khẩu");
                    choose1 = scanner.nextLine();
                    switch (choose1) {
                        case "1":
                            Manager.themSanPhamNhapKhau();
                            break;
                        case "2":
                            Manager.themSanPhamXuatKhau();
                            break;
                    }
                    break;
                case "2":
                    System.out.println("Mời bạn chọn 1 hoặc 2");
                    System.out.println("1.Sửa ID sản phẩm nhập khẩu");
                    System.out.println("2.Sửa ID sản phẩm xuất khẩu");
                    choose2 = scanner.nextLine();
                    switch (choose2) {
                        case "1":
                            Manager.suaIdSanPhamNK();
                            break;
                        case "2":
                            Manager.suaIdSanPhamXK();
                            break;
                    }
                    break;
                case "3":
                    System.out.println("Mời bạn chọn 1 hoặc 2");
                    System.out.println("1.Xóa ID sản phẩm nhập khẩu");
                    System.out.println("2.Xóa ID sản phẩm xuất khẩu");
                    choose3 = scanner.nextLine();
                    switch (choose3) {
                        case "1":
                            Manager.xoaSanPhamNK();
                            break;
                        case "2":
                            Manager.xoaSanPhamXk();
                            break;
                    }
                    break;
                case "4":
                    System.out.println("Mời bạn chọn 1 hoặc 2");
                    System.out.println("1.Hiển thị sản phẩm nhập khẩu");
                    System.out.println("2.Hiển thị sản phẩm xuất khẩu");
                    choose5 = scanner.nextLine();
                    switch (choose5) {
                        case "1":
                            Manager.hienThiDanhSachNk();
                            break;
                        case "2":
                            Manager.hienThiDanhSachXK();
                            break;
                    }
                    break;
                case "5":
                    System.out.println("Mời bạn chọn 1 hoặc 2");
                    System.out.println("1.Tìm ID sản phẩm nhập khẩu");
                    System.out.println("2.Tìm ID sản phẩm xuất khẩu");
                    choose4 = scanner.nextLine();
                    switch (choose4) {
                        case "1":
                            Manager.timKiemSanPhamNK();
                            break;
                        case "2":
                            Manager.timKiemSanPhamXK();
                            break;
                    }
                    break;
                case "6":
                    System.exit(5);
            }
        } while (true);
    }
}
