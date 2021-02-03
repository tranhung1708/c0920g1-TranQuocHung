package Test2;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Manager {
    public static final String FILE_SAN_PHAM_NHAP_KHAU = "src/Test2/SanPhamNhapKhau.csv";
    public static final String FILE_SAN_PHAM_XUAT_KHAU = "src/Test2/SanPhamXuatKhau.csv";
    public static Scanner scanner = new Scanner(System.in);
    public static String line;
    public static String choose = "0";
    public static final String COMMA = ",";
    public static String idSanPham;
    public static String maSanPham;
    public static String tenSanPham;
    public static String giaBan;
    public static String soLuong;
    public static String nhaSanXuat;

    public static void themSanPham() {
        System.out.println("Mời bạn nhập id sản phẩm");
        idSanPham = scanner.nextLine();
        System.out.println("Mời bạn nhập mã sản phẩm");
        maSanPham = scanner.nextLine();
        do {
            System.out.println("Mời bạn nhập tên sản phẩm");
            tenSanPham = scanner.nextLine();
        } while (!Validate.isTenSanPham(tenSanPham));
        do {
            System.out.println("Mời bạn nhập giá bán");
            giaBan = scanner.nextLine();
        } while (!Validate.isGiaBan(giaBan));
        do {
            System.out.println("Mời bạn nhập số lượng");
            soLuong = scanner.nextLine();
        } while (!Validate.isSoLuong(soLuong));
        do {
            System.out.println("Mời bạn nhập nhà sản xuất");
            nhaSanXuat = scanner.nextLine();
        } while (!Validate.isNoiSanXuat(nhaSanXuat));
    }

    public static void themSanPhamNhapKhau() {
        themSanPham();
        System.out.println("Mời bạn nhập giá nhập khẩu");
        String giaNhapKhau = scanner.nextLine();
        System.out.println("Mời bạn nhập tỉnh thành nhập");
        String tinhThanhNhap = scanner.nextLine();
        System.out.println("Mời bạn nhập thuế nhập khẩu");
        String thueNhapKkhau = scanner.nextLine();
        line = idSanPham + COMMA + maSanPham + COMMA + tenSanPham + COMMA + giaBan + COMMA +
                soLuong + COMMA + nhaSanXuat + COMMA +
                giaNhapKhau + COMMA + tinhThanhNhap + COMMA + thueNhapKkhau;
        FileUtils.themSanPham(FILE_SAN_PHAM_NHAP_KHAU, line, true);
    }

    public static void themSanPhamXuatKhau() {
        themSanPham();
        System.out.println("Mời bạn nhập giá xuất khẩu");
        String giaXuatKhau = scanner.nextLine();
        System.out.println("Mời bạn nhập quốc gia nhập khẩu");
        String quocGiaXuatKhau = scanner.nextLine();
        line = idSanPham + COMMA + maSanPham + COMMA + tenSanPham + COMMA + giaBan +
                COMMA + soLuong + COMMA + nhaSanXuat + COMMA +
                giaXuatKhau + COMMA + quocGiaXuatKhau;
        FileUtils.themSanPham(FILE_SAN_PHAM_XUAT_KHAU, line, true);
    }

    public static void suaIdSanPhamNK() {
        boolean isExits = false;
        List<String> listString = FileUtils.read(FILE_SAN_PHAM_NHAP_KHAU);
        List<SanPhamNhapKhau> sanPhamList = new ArrayList<>();
        for (int i = 0; i < listString.size(); i++) {
            String[] arraySanPham = listString.get(i).split(",");
            String idSanPham = arraySanPham[0];
            String maSanPham = arraySanPham[1];
            String tenSanPham = arraySanPham[2];
            String giaBan = arraySanPham[3];
            String soLuong = arraySanPham[4];
            String nhaSanXuat = arraySanPham[5];
            String giaNhapKhau = arraySanPham[6];
            String tinhThanhNhap = arraySanPham[7];
            String thueNhapKkhau = arraySanPham[8];
            SanPhamNhapKhau sanPham = new SanPhamNhapKhau(idSanPham, maSanPham, tenSanPham,
                    giaBan, soLuong, nhaSanXuat, giaNhapKhau, tinhThanhNhap, thueNhapKkhau);
            sanPhamList.add(sanPham);
        }
        System.out.println("Mời bạn nhập id cần sửa");
        String idCanSua = scanner.nextLine();
        for (int j = 0; j < sanPhamList.size(); j++) {
            if (sanPhamList.get(j).getIdSanPham().equals(idCanSua)) {
                isExits = true;
                System.out.println("1.Yes\n" +
                        "2.No");
                choose = scanner.nextLine();
                switch (choose) {
                    case "1":
                        for (int i = 0; i < sanPhamList.size(); i++) {
                            if (sanPhamList.get(i).getIdSanPham().equals(idCanSua)) {
                                System.out.println("ID cần sửa là : ");
                                String idValue = scanner.nextLine();
                                sanPhamList.get(i).setIdSanPham(idValue);
                                System.out.println("Id đã sửa là : " + sanPhamList.get(i).getIdSanPham());
                                break;
                            }
                        }
                        List<String> stringList = new ArrayList<>();
                        String temp = "";
                        for (SanPhamNhapKhau sanPhamNhapKhau : sanPhamList) {
                            temp = sanPhamNhapKhau.idSanPham + COMMA + sanPhamNhapKhau.getMaSanPham()
                                    + COMMA + sanPhamNhapKhau.getTenSanPham() + COMMA +
                                    sanPhamNhapKhau.getGiaBan() + COMMA + sanPhamNhapKhau.getSoLuong()
                                    + COMMA + sanPhamNhapKhau.getNhaSanXuat() + COMMA +
                                    sanPhamNhapKhau.getGiaNhapKhau() + COMMA +
                                    sanPhamNhapKhau.getTinhThanhNhap() + COMMA +
                                    sanPhamNhapKhau.getThueNhapKkhau();
                            stringList.add(temp);
                        }
                        String temp1 = "";
                        for (String s : stringList) {
                            if (temp1.equals("")) {
                                temp1 += s;
                            } else {
                                temp1 += "\n" + s;
                            }
                        }
                        FileUtils.suaSanPham(FILE_SAN_PHAM_NHAP_KHAU, temp1, true);
                }
            }
        }
        if (!isExits) {
            System.out.println("Tên bạn nhập không có trong danh sách");
        }
    }

    public static void suaIdSanPhamXK() {
        boolean isExits = false;
        List<String> listString = FileUtils.read(FILE_SAN_PHAM_XUAT_KHAU);
        List<SanPhamXuatKhau> sanPhamList = new ArrayList<>();
        for (int i = 0; i < listString.size(); i++) {
            String[] arraySanPham = listString.get(i).split(",");
            String idSanPham = arraySanPham[0];
            String maSanPham = arraySanPham[1];
            String tenSanPham = arraySanPham[2];
            String giaBan = arraySanPham[3];
            String soLuong = arraySanPham[4];
            String nhaSanXuat = arraySanPham[5];
            String giaXuatKhau = arraySanPham[6];
            String quocGiaNhapSanPham = arraySanPham[7];
            SanPhamXuatKhau sanPham = new SanPhamXuatKhau(idSanPham, maSanPham, tenSanPham,
                    giaBan, soLuong, nhaSanXuat, giaXuatKhau, quocGiaNhapSanPham);
            sanPhamList.add(sanPham);
        }
        System.out.println("Mời bạn nhập id cần sửa");
        String idCanSua = scanner.nextLine();
        for (int j = 0; j < sanPhamList.size(); j++) {
            if (sanPhamList.get(j).getIdSanPham().equals(idCanSua)) {
                isExits = true;
                System.out.println("1.Yes\n" +
                        "2.No");
                choose = scanner.nextLine();
                switch (choose) {
                    case "1":
                        for (int i = 0; i < sanPhamList.size(); i++) {
                            if (sanPhamList.get(i).getIdSanPham().equals(idCanSua)) {
                                System.out.println("ID cần sửa là : ");
                                String idValue = scanner.nextLine();
                                sanPhamList.get(i).setIdSanPham(idValue);
                                System.out.println(sanPhamList.get(i).getIdSanPham());
                                break;
                            }
                        }
                        List<String> stringList = new ArrayList<>();
                        String temp = "";
                        for (SanPhamXuatKhau sanPhamXuatKhau : sanPhamList) {
                            temp = sanPhamXuatKhau.idSanPham + COMMA + sanPhamXuatKhau.getMaSanPham()
                                    + COMMA + sanPhamXuatKhau.getTenSanPham() + COMMA +
                                    sanPhamXuatKhau.getGiaBan() + COMMA + sanPhamXuatKhau.getSoLuong()
                                    + COMMA + sanPhamXuatKhau.getNhaSanXuat() + COMMA +
                                    sanPhamXuatKhau.getGiaXuatKhau() + COMMA +
                                    sanPhamXuatKhau.getQuocGiaNhapSanPham();
                            stringList.add(temp);
                        }
                        String temp1 = "";
                        for (String s : stringList) {
                            if (temp1.equals("")) {
                                temp1 += s;
                            } else {
                                temp1 += "\n" + s;
                            }
                        }
                        FileUtils.suaSanPham(FILE_SAN_PHAM_XUAT_KHAU, temp1, true);
                }
            }
        }
        if (!isExits) {
            System.out.println("Tên bạn nhập không có trong danh sách");
        }
    }

    public static void xoaSanPhamNK() {
        boolean isExits = false;
        List<String> listString = FileUtils.read(FILE_SAN_PHAM_NHAP_KHAU);
        List<SanPhamNhapKhau> sanPhamList = new ArrayList<>();
        for (int i = 0; i < listString.size(); i++) {
            String[] arraySanPham = listString.get(i).split(",");
            String idSanPham = arraySanPham[0];
            String maSanPham = arraySanPham[1];
            String tenSanPham = arraySanPham[2];
            String giaBan = arraySanPham[3];
            String soLuong = arraySanPham[4];
            String nhaSanXuat = arraySanPham[5];
            String giaNhapKhau = arraySanPham[6];
            String tinhThanhNhap = arraySanPham[7];
            String thueNhapKkhau = arraySanPham[8];
            SanPhamNhapKhau sanPham = new SanPhamNhapKhau(idSanPham, maSanPham,
                    tenSanPham, giaBan, soLuong, nhaSanXuat, giaNhapKhau, tinhThanhNhap, thueNhapKkhau);
            sanPhamList.add(sanPham);
        }
        System.out.println("Mời bạn nhập id cần xóa");
        String idCanXoa = scanner.nextLine();
        for (int j = 0; j < sanPhamList.size(); j++) {
            if (sanPhamList.get(j).getIdSanPham().equals(idCanXoa)) {
                isExits = true;
                System.out.println("1.yes\n" +
                        "2.no");
                choose = scanner.nextLine();
                switch (choose) {
                    case "1":
                        for (int i = 0; i < sanPhamList.size(); i++) {
                            if (sanPhamList.get(i).getIdSanPham().equals(idCanXoa)) {
                                sanPhamList.remove(i);
                                System.out.println("Bạn đã xóa thành công " + idCanXoa);
                            }
                        }
                        List<String> stringList = new ArrayList<>();
                        String temp = "";
                        for (SanPhamNhapKhau sanPhamNhapKhau : sanPhamList) {
                            temp = sanPhamNhapKhau.idSanPham + COMMA +
                                    sanPhamNhapKhau.getMaSanPham() + COMMA +
                                    sanPhamNhapKhau.getTenSanPham() + COMMA +
                                    sanPhamNhapKhau.getGiaBan() + COMMA + sanPhamNhapKhau.getSoLuong() +
                                    COMMA + sanPhamNhapKhau.getNhaSanXuat() + COMMA +
                                    sanPhamNhapKhau.getGiaNhapKhau() + COMMA +
                                    sanPhamNhapKhau.getTinhThanhNhap() + COMMA +
                                    sanPhamNhapKhau.getThueNhapKkhau();
                            stringList.add(temp);
                        }
                        String temp1 = "";
                        for (String s : stringList) {
                            if (temp1.equals("")) {
                                temp1 += s;
                            } else {
                                temp1 += "\n" + s;
                            }
                        }
                        FileUtils.xoaSanPham(FILE_SAN_PHAM_NHAP_KHAU, temp1, false);
                        break;
                }
            }
        }
        if (!isExits) {
            System.out.println("Khong co");
        }
    }

    public static void xoaSanPhamXk() {
        Boolean isExist = false;

        List<String> listString = FileUtils.read(FILE_SAN_PHAM_XUAT_KHAU);
        List<SanPhamXuatKhau> sanPhamList = new ArrayList<>();
        for (int i = 0; i < listString.size(); i++) {
            String[] arraySanPham = listString.get(i).split(",");
            String idSanPham = arraySanPham[0];
            String maSanPham = arraySanPham[1];
            String tenSanPham = arraySanPham[2];
            String giaBan = arraySanPham[3];
            String soLuong = arraySanPham[4];
            String nhaSanXuat = arraySanPham[5];
            String giaXuatKhau = arraySanPham[6];
            String quocGiaNhapSanPham = arraySanPham[7];
            SanPhamXuatKhau sanPham = new SanPhamXuatKhau(idSanPham, maSanPham, tenSanPham,
                    giaBan, soLuong, nhaSanXuat, giaXuatKhau, quocGiaNhapSanPham);
            sanPhamList.add(sanPham);
        }
        System.out.println("Mời bạn nhập id cần xóa");
        String idCanXoa = scanner.nextLine();
        for (int j = 0; j < sanPhamList.size(); j++) {
            if (sanPhamList.get(j).getIdSanPham().equals(idCanXoa)) {
                isExist = true;
                System.out.println("1.Yes\n" +
                        "2.No");
                choose = scanner.nextLine();
                switch (choose) {
                    case "1":
                        for (int i = 0; i < sanPhamList.size(); i++) {
                            if (sanPhamList.get(i).getIdSanPham().equals(idCanXoa)) {
                                sanPhamList.remove(i);
                                i--;
                                System.out.println("Bạn đẫ xóa thành công " + idCanXoa);
                            }
                        }
                        List<String> stringList = new ArrayList<>();
                        String temp = "";
                        for (SanPhamXuatKhau sanPhamXuatKhau : sanPhamList) {
                            temp = sanPhamXuatKhau.idSanPham + COMMA + sanPhamXuatKhau.getMaSanPham()
                                    + COMMA + sanPhamXuatKhau.getTenSanPham() + COMMA +
                                    sanPhamXuatKhau.getGiaBan() + COMMA + sanPhamXuatKhau.getSoLuong()
                                    + COMMA + sanPhamXuatKhau.getNhaSanXuat() + COMMA +
                                    sanPhamXuatKhau.getGiaXuatKhau() + COMMA +
                                    sanPhamXuatKhau.getQuocGiaNhapSanPham();
                            stringList.add(temp);
                        }
                        String temp1 = "";
                        for (String s1 : stringList) {
                            if (temp1.equals("")) {
                                temp1 += s1;
                            } else {
                                temp1 += "\n" + s1;
                            }
                        }
                        FileUtils.xoaSanPham(FILE_SAN_PHAM_XUAT_KHAU, temp1, false);
                        break;
                    case "2":
                        System.exit(2);
                }
            }
        }
        if (!isExist) {
            System.out.println("Khong cos");
        }
    }

    public static void timKiemSanPhamNK() {
        boolean isExits = false;
        List<String> listString = FileUtils.read(FILE_SAN_PHAM_NHAP_KHAU);
        List<SanPhamNhapKhau> sanPhamList = new ArrayList<>();
        for (int i = 0; i < listString.size(); i++) {
            String[] arraySanPham = listString.get(i).split(",");
            String idSanPham = arraySanPham[0];
            String maSanPham = arraySanPham[1];
            String tenSanPham = arraySanPham[2];
            String giaBan = arraySanPham[3];
            String soLuong = arraySanPham[4];
            String nhaSanXuat = arraySanPham[5];
            String giaNhapKhau = arraySanPham[6];
            String tinhThanhNhap = arraySanPham[7];
            String thueNhapKkhau = arraySanPham[8];
            SanPhamNhapKhau sanPham = new SanPhamNhapKhau(idSanPham, maSanPham, tenSanPham,
                    giaBan, soLuong, nhaSanXuat, giaNhapKhau, tinhThanhNhap, thueNhapKkhau);
            sanPhamList.add(sanPham);
        }
        System.out.println("Mời bạn nhập id cần tìm");
        String idCanTim = scanner.nextLine();
        for (int i = 0; i < sanPhamList.size(); i++) {
            if (sanPhamList.get(i).getIdSanPham().contains(idCanTim)) {
                isExits = true;
                System.out.println(sanPhamList.get(i));
            }
        }
        if (!isExits) {
            System.out.println("Tên bạn vừa nhập không có trong danh sách");
        }
    }

    public static void timKiemSanPhamXK() {
        boolean isExits = false;
        List<String> listString = FileUtils.read(FILE_SAN_PHAM_XUAT_KHAU);
        List<SanPhamXuatKhau> sanPhamList = new ArrayList<>();
        for (int i = 0; i < listString.size(); i++) {
            String[] arraySanPham = listString.get(i).split(",");
            String idSanPham = arraySanPham[0];
            String maSanPham = arraySanPham[1];
            String tenSanPham = arraySanPham[2];
            String giaBan = arraySanPham[3];
            String soLuong = arraySanPham[4];
            String nhaSanXuat = arraySanPham[5];
            String giaXuatKhau = arraySanPham[6];
            String quocGiaNhapSanPham = arraySanPham[7];
            SanPhamXuatKhau sanPham = new SanPhamXuatKhau(idSanPham, maSanPham, tenSanPham, giaBan,
                    soLuong, nhaSanXuat, giaXuatKhau, quocGiaNhapSanPham);
            sanPhamList.add(sanPham);
        }
        System.out.println("Mời bạn nhập id cần tìm");
        String idCanTim = scanner.nextLine();
        for (int i = 0; i < sanPhamList.size(); i++) {
            if (sanPhamList.get(i).getIdSanPham().contains(idCanTim)) {
                isExits = true;
                System.out.println(sanPhamList.get(i));
            }
        }
        if (!isExits) {
            System.out.println("Tên bạn nhập không cso trong danh sách");
        }
    }

    public static void hienThiDanhSachNk() {
        List<String> list = FileUtils.read(FILE_SAN_PHAM_NHAP_KHAU);
        for (String s : list) {
            System.out.println(s);
        }
    }

    public static void hienThiDanhSachXK() {
        List<String> stringList = FileUtils.read(FILE_SAN_PHAM_XUAT_KHAU);
        for (String s : stringList) {
            System.out.println(s);
        }
    }
}
