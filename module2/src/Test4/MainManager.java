package Test4;

import java.util.Scanner;

public class MainManager {
    public static Scanner scanner = new Scanner(System.in);
    public static String choose = "0";

    public static void main(String[] args) {
        do {
            System.out.println("1.Thêm thông tin");
            System.out.println("2.Xóa thông tin");
            System.out.println("3.Sửa thông tin");
            System.out.println("4.Tìm thông tin");
            System.out.println("5.Hiển thị thông tin");
            System.out.println("6.Exit");
            choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    System.out.println("1.Thêm thông tin bố");
                    System.out.println("2.Thêm thông tin mẹ");
                    choose = scanner.nextLine();
                    switch (choose) {
                        case "1":
                            ServiceManager.addNewMan();
                            break;
                        case "2":
                            ServiceManager.addNewWomen();
                            break;
                    }
                    break;
                case "2":
                    System.out.println("1.Xóa thông tin bố");
                    System.out.println("2.Xóa thông tin mẹ");
                    choose = scanner.nextLine();
                    switch (choose){
                        case "1":ServiceManager.deleteCustomer(ServiceManager.FILE_MAN);
                        break;
                        case "2":ServiceManager.deleteCustomer(ServiceManager.FILE_WOMEN);
                        break;
                    }
                    break;
                case "3":
                case "4":
                case "5":
                case "6":System.exit(6);
            }
        } while (true);
    }
}
