package Test;
import java.util.Scanner;

public class Main {
    public static String choose = "0";
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        do {
            System.out.println("1.Thêm hàng nhập khẩu");
            System.out.println("2.Thêm hàng xuất khẩu");
            System.out.println("3.xóa hàng nk");
            System.out.println("4.xóa hàng xk");
            System.out.println("5.hiển thị hàng nk");
            System.out.println("6.hiển thị hàng xk");
            System.out.println("7.Tìm tên  hàng nk");
            System.out.println("8.tìm tên  hàng xk");
            System.out.println("9.edit sản phẩm");
            System.out.println("10.exit");
            choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    Manager.addProductNK();
                    break;
                case "2":
                    Manager.addProductXk();
                    break;
                case "3":
                    Manager.deleteNk();
                    break;
                case "4":
                    Manager.deleteXk();
                    break;
                case "5":
                    Manager.hienThiNK();
                    break;
                case "6":
                    Manager.hienThiXK();
                    break;
                case "7":
                    Manager.searchProductNk();
                    break;
                case "8":
                    Manager.searchProductXk();
                    break;
                case "9":
                    Manager.editProduct();
                    break;
                case "10":
                    System.exit(9);
            }
        } while (true);
    }
}
