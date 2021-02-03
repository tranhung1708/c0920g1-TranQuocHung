package session_16.BaiTap;

import CaseStudy.common.FileUtils;

import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestProduct {
    public static List<Product> productList = new ArrayList<>();
    public static int choose ;
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        choose = 0;
        do {
            System.out.println("1.them\n" +
                    "2.Hiển thị\n" +
                    "3.xoa\n");
            choose = scanner.nextInt();
            switch (choose){
                case 1: them();
                break;
                case 2:
                    show();
                    break;
            }
        }while (true);
    }
    public static void them(){
        productList = new ArrayList<>();
        scanner.nextLine();
        System.out.println("Mời bạn mã sản phẩm");
        String maSanPham = scanner.nextLine();
        System.out.println("Mời bạn thêm tên sản phẩm");
        String tenSanPham = scanner.nextLine();
        System.out.println("Mời bạn nhập hãng sản xuất");
        String hangSanXuat = scanner.nextLine();
        System.out.println("Mời bạn nhập giá");
        String gia = scanner.nextLine();
        System.out.println("Mời bạn nhập các mô tả khác");
        String cacMoTaKhac = scanner.nextLine();
        Product product = new Product(maSanPham,tenSanPham,hangSanXuat,gia,cacMoTaKhac);
        productList.add(product);
        FunctionManager.writeProduct(productList);
    }
    public static void show(){
             productList = FunctionManager.readProduct();
            for (Product product : productList){
                System.out.println(product);
            }
        }
}
