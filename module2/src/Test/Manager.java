package Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Manager {
    public static Scanner scanner = new Scanner(System.in);
    public static String line = null;
    public static final String COMMA = ",";
    public static final String FILE_HANG_NK = "src/Test/SanPhamNhapKhau1.csv";
    public static final String FILE_HANG_XK = "src/Test/SanPhamXuatKhau.csv";

    public static void addProductNK() {
        System.out.println("Mời bạn nhập tên sản phẩm");
        String hoTen = scanner.nextLine();
        System.out.println("Mời bạn nhập loại hàng");
        String loaiHang = scanner.nextLine();
        System.out.println("Mời bạn nhập nơi di chuyển đồ");
        String hangNk = scanner.nextLine();
        System.out.println("Mời bạn nhập nơi lấy đồ về");
        String hangXk = scanner.nextLine();
        line = hoTen + COMMA + loaiHang + COMMA + hangNk + COMMA + hangXk;
        FileUtils.writeFile1(FILE_HANG_NK, line, true);
    }

    public static void addProductXk() {
        System.out.println("Mời bạn nhập tên sản phẩm");
        String hoTen = scanner.nextLine();
        System.out.println("Mời bạn nhập loại hàng");
        String loaiHang = scanner.nextLine();
        System.out.println("Mời bạn nhập nơi di chuyển đồ");
        String hangNk = scanner.nextLine();
        System.out.println("Mời bạn nhập nơi lấy đồ về");
        String hangXk = scanner.nextLine();
        line = hoTen + COMMA + loaiHang + COMMA + hangNk + COMMA + hangXk;
        FileUtils.writeFile1(FILE_HANG_XK, line, true);
    }

    public static void hienThiNK() {
        List<String> stringList = FileUtils.read(FILE_HANG_NK);
        for (String s : stringList) {
            System.out.println(s);
        }
    }

    public static void hienThiXK() {
        List<String> stringList = FileUtils.read(FILE_HANG_XK);
        for (String s : stringList) {
            System.out.println(s);
        }
    }

    public static void deleteNk() {
        List<String> stringList = FileUtils.read(FILE_HANG_NK);
        List<Product> productList = new ArrayList<>();
        for (int i = 0; i < stringList.size(); i++) {
            String[] array = stringList.get(i).split(",");
            String hoTen = array[0];
            String loaiHang = array[1];
            String hangNk = array[2];
            String hangXk = array[3];
            Product product = new Product(hoTen, loaiHang, hangNk, hangXk);
            productList.add(product);
        }
        System.out.println("Nhap tên cần xóa");
        String hoTenXoa = scanner.nextLine();
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getTen().equals(hoTenXoa)) {
                productList.remove(i);
                break;
            }
        }
        System.out.println("Xóa thành công");
        List<String> list1 = new ArrayList<>();
        String temp = "";
        for (Product product : productList) {
            temp = product.getTen() + COMMA + product.getLoaiHang() + COMMA + product.getHangNk() + COMMA + product.getHangXk();
            list1.add(temp);
        }
        String temp1 = "";
        for (String s : list1) {
            if (temp1.equals("")) {
                temp1 += s;
            } else {
                temp1 += "\n" + s;
            }
        }
        FileUtils.writeFile1(FILE_HANG_NK, temp1, false);
    }

    public static void deleteXk() {
        List<String> stringList = FileUtils.read(FILE_HANG_XK);
        List<Product> productList = new ArrayList<>();
        for (int i = 0; i < stringList.size(); i++) {
            String[] array = stringList.get(i).split(",");
            String hoTen = array[0];
            String loaiHang = array[1];
            String hangNk = array[2];
            String hangXk = array[3];
            Product product = new Product(hoTen, loaiHang, hangNk, hangXk);
            productList.add(product);
        }
        System.out.println("Nhap tên cần xóa");
        String hoTenXoa = scanner.nextLine();
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getTen().equals(hoTenXoa)) {
                productList.remove(i);
                break;
            }
        }
        System.out.println("Xóa thành công");
        List<String> list1 = new ArrayList<>();
        String temp = "";
        for (Product product : productList) {
            temp = product.getTen() + COMMA + product.getLoaiHang() + COMMA + product.getHangNk() + COMMA + product.getHangXk();
            list1.add(temp);
        }
        String temp1 = "";
        for (String s : list1) {
            if (temp1.equals("")) {
                temp1 += s;
            } else {
                temp1 += "\n" + s;
            }
        }
        FileUtils.writeFile1(FILE_HANG_XK, temp1, false);
    }

    public static void searchProductNk() {
        List<String> stringList = FileUtils.read(FILE_HANG_NK);
        List<Product> productList = new ArrayList<>();
        for (int i = 0; i < stringList.size(); i++) {
            String[] array = stringList.get(i).split(",");
            String Ten = array[0];
            String loaiHang = array[1];
            String hangNk = array[2];
            String hangXk = array[3];
            Product product = new Product(Ten, loaiHang, hangNk, hangXk);
            productList.add(product);
        }
        System.out.println("Nhập tên cần tìm");
        String hoTenTim = scanner.nextLine();
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getTen().equals(hoTenTim)) {
                System.out.println(productList.get(i));
            }
        }
    }

    public static void searchProductXk() {
        List<String> stringList = FileUtils.read(FILE_HANG_XK);
        List<Product> productList = new ArrayList<>();
        for (int i = 0; i < stringList.size(); i++) {
            String[] array = stringList.get(i).split(",");
            String Ten = array[0];
            String loaiHang = array[1];
            String hangNk = array[2];
            String hangXk = array[3];
            Product product = new Product(Ten, loaiHang, hangNk, hangXk);
            productList.add(product);
        }
        System.out.println("Nhập tên cần tìm");
        String hoTenTim = scanner.nextLine();
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getTen().equals(hoTenTim)) {
                System.out.println(productList.get(i));
            }
        }
    }

    public static void editProduct() {
        List<String> stringList = FileUtils.read(FILE_HANG_XK);
        List<Product> productList = new ArrayList<>();
        for (int i = 0; i < stringList.size(); i++) {
            String[] array = stringList.get(i).split(",");
            String hoTen = array[0];
            String loaiHang = array[1];
            String hangNk = array[2];
            String hangXk = array[3];
            Product product = new Product(hoTen, loaiHang, hangNk, hangXk);
            productList.add(product);
        }
        System.out.println("Nhap tên cần edit");
        String hoTenEdit = scanner.nextLine();
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getTen().equals(hoTenEdit)) {
                System.out.println("Ten sua la ; ");
                String chooseValue = scanner.nextLine();
                productList.get(i).setTen(chooseValue);
                System.out.println(productList.get(i).getTen());
            }
        }
        List<String> stringList1 = new ArrayList<>();
        String temp = "";
        for (Product product : productList){
            temp = product.getTen()+COMMA+product.getLoaiHang()+COMMA+product.getHangNk()+COMMA+product.getHangXk();
            stringList1.add(temp);
        }
       String temp1 = "";
        for (String s: stringList1){
            if (temp1.equals("")){
                temp1 += s;
            }else {
                temp1+= "\n"+s;
            }
        }
        FileUtils.writeFile(FILE_HANG_XK,temp1,true);
    }
}