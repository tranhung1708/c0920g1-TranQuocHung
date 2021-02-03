package session_11.BaiTap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ProductManager {
    public static final ArrayList<Product> productList = new ArrayList<>();
    public static final Scanner scanner = new Scanner(System.in);

    public static void addProduct() {
        System.out.println("Nhập id : ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Nhập tên sản phẩm : ");
        String productName = scanner.nextLine();
        System.out.println("Nhập giá tiền : ");
        long price = scanner.nextLong();
        Product product = new Product(id, productName, price);
        productList.add(product);
        for (Product product1 : productList) {
            System.out.println(product1);
        }
    }

    public static void editProduct() {
        System.out.println("Nhập id cần sửa : ");
        int editID = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < productList.size(); i++) {
            if (editID == productList.get(i).getId()) {
                System.out.println("Nhập tên sản phẩm muốn sửa : ");
                String name = scanner.nextLine();
                productList.get(i).setProductName(name);
            }
        }
        for (Product product1 : productList) {
            System.out.println(product1);
        }
    }

    public static void deleteProduct() {
        System.out.println("Nhập id cần xóa : ");
        int deleteID = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < productList.size(); i++) {
            if (deleteID == productList.get(i).getId()) {
                productList.remove(i);
            }
        }
        for (Product product1 : productList) {
            System.out.println(product1);
        }
    }

    public static void searchProduct() {
        scanner.nextLine();
        System.out.println("Nhập tên sản phẩm cần tìm : ");
        String searchProduct = scanner.nextLine();
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getProductName().equals(searchProduct)) {
                System.out.println(productList.get(i));
            }
        }
    }

    public static void ascendingProduct() {
        Collections.sort(productList, new Product());
        displayProduct();
    }

    public static void displayProduct() {
        for (Product product1 : productList) {
            System.out.println(product1);
        }
    }
}
