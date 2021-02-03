package session_11.BaiTap;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choose = 0;
        do {
            System.out.println("Menu");
            System.out.println("1.Thêm sản phẩm");
            System.out.println("2.Sửa sản phẩm");
            System.out.println("3.Xóa sản phẩm");
            System.out.println("4.Tìm sẩn phẩm theo tên");
            System.out.println("5.Sắp xếp sản phẩm tăng dần");
            System.out.println("6.Hiển thị sản phẩm");
            System.out.println("Nhập sự lựa chọn :");
            choose = scanner.nextInt();
            switch (choose) {
                case 1:
                    ProductManager.addProduct();
                    break;
                case 2:
                    ProductManager.editProduct();
                    break;
                case 3:
                    ProductManager.deleteProduct();
                    break;
                case 4:
                    ProductManager.searchProduct();
                    break;
                case 5:
                    ProductManager.ascendingProduct();
                    break;
                case 6:
                    ProductManager.displayProduct();
                    break;
                default:
                    System.out.println("Mời bạn nhập lại : ");
            }
        } while (choose >= 0 || choose <= 4);
    }
}
