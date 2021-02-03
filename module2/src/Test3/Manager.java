package Test3;

import com.sun.corba.se.spi.ior.iiop.GIOPVersion;

import javax.sql.rowset.serial.SerialStruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

public class Manager {
    public static final String FILE_GIAO_VIEN = "src/Test3/GiaoVien.csv";
    public static final String FILE_HOC_SINH = "src/Test3/HocSinh.csv";
    public static final String COMMA = ",";
    public static String line;
    public static String choose = "0";
    public static Scanner scanner = new Scanner(System.in);
    public static List<String> stringList = new ArrayList<>();

    public static void addNewGiaoVien() {
        stringList = FileUtils.read(FILE_GIAO_VIEN);
        String tenGiaoVien;
        int idGiaoVien = (stringList.size() > 0) ? (stringList.size() + 1) : 1;
        do {
            System.out.println("Mời bạn nhập tên giáo viên");
            tenGiaoVien = scanner.nextLine();
        } while (!Validate.isTen(tenGiaoVien));

        System.out.println("Mời bạn nhập lớp chủ nhiệm");
        String lopChuNhiem = scanner.nextLine();
        System.out.println("Mơi bạn nhập địa chỉ");
        String diaChi = scanner.nextLine();
        System.out.println("Mời bạn nhập ngày sinh");
        String ngaySinh = scanner.nextLine();
        line = idGiaoVien + COMMA + tenGiaoVien + COMMA + lopChuNhiem + COMMA + diaChi + COMMA + ngaySinh;
        FileUtils.themSanPham(FILE_GIAO_VIEN, line, true);
    }

    public static void addNewHocSinh() {
        String tenHocSinh;
        System.out.println("Mời bạn nhập id học sinh");
        int idHocSinh = scanner.nextInt();
        scanner.nextLine();
        do {
            System.out.println("Mời bạn nhập tên học sinh");
            tenHocSinh = scanner.nextLine();
        } while (!Validate.isTen(tenHocSinh));

        System.out.println("Mời bạn nhập lớp học");
        String lopHoc = scanner.nextLine();
        System.out.println("Mời bạn nhập địa chỉ");
        String ngaySinh = scanner.nextLine();
        System.out.println("Mời bạn nhập số điện thoại");
        String soDienThoai = scanner.nextLine();
        System.out.println("Mời bạn nhập giới tính");
        String gioiTinh = scanner.nextLine();
        System.out.println("Mời bạn nhập gmail");
        String email = scanner.nextLine();
        System.out.println("Mời bạn nhập địa chỉ");
        String diaChi = scanner.nextLine();
        line = idHocSinh + COMMA + tenHocSinh + COMMA + lopHoc + COMMA + ngaySinh + COMMA + soDienThoai + COMMA + gioiTinh + COMMA + email + COMMA + diaChi;
        FileUtils.themSanPham(FILE_HOC_SINH, line, true);
    }

    public static void deleteGiaoVien() {
        List<String> stringList = FileUtils.read(FILE_GIAO_VIEN);
        List<GiaoVien> giaoVienList = new ArrayList<>();
        for (int i = 0; i < stringList.size(); i++) {
            String[] arrayList = stringList.get(i).split(",");
            int maGiaoVien = Integer.parseInt(arrayList[0]);
            String tenGiaoVien = arrayList[1];
            String lopChuNhiem = arrayList[2];
            String diaChi = arrayList[3];
            String ngaySinh = arrayList[4];
            GiaoVien giaoVien = new GiaoVien(maGiaoVien, tenGiaoVien, lopChuNhiem, diaChi, ngaySinh);
            giaoVienList.add(giaoVien);
        }
        System.out.println("Mời bạn nhập tên giáo viên muốn xóa");
        String hoTenMuonXoa = scanner.nextLine();
        boolean check = false;
        System.out.println("1.Yes\n"
                + "2.No");
        choose = scanner.nextLine();
        switch (choose) {
            case "1":
                for (int i = 0; i < giaoVienList.size(); i++) {
                    if (giaoVienList.get(i).getTenGiaoVien().equals(hoTenMuonXoa)) {
                        check = true;
                        giaoVienList.remove(i);
                        i--;
                        System.out.println("Bạn đã xóa thành công" + hoTenMuonXoa);
                    }
                }
                if (!check) {
                    System.out.println(hoTenMuonXoa + " Không có trong danh sách");
                }
                List<String> stringList1 = new ArrayList<>();
                String temp = "";
                for (GiaoVien giaoVien : giaoVienList) {
                    temp = giaoVien.maGiaoVien + COMMA + giaoVien.tenGiaoVien + COMMA + giaoVien.ngaySinh + COMMA + giaoVien.lopChuNhiem + COMMA + giaoVien.diaChi;
                    stringList1.add(temp);
                }
                String temp1 = "";
                for (String s : stringList1) {
                    if (temp1.equals("")) {
                        temp1 += s;
                    } else {
                        temp1 += "\n" + s;
                    }
                }
                FileUtils.xoaSanPham(FILE_GIAO_VIEN, temp1, false);
                break;
            case "2":
                deleteGiaoVien();
                break;
        }
    }

    public static void deleteHocSinh() {
        List<String> stringList = FileUtils.read(FILE_HOC_SINH);
        List<HocSinh> hocSinhList = new ArrayList<>();
        for (int i = 0; i < stringList.size(); i++) {
            String[] arrayList = stringList.get(i).split(",");
            int idHocSinh = Integer.parseInt(arrayList[0]);
            String tenHocSinh = arrayList[1];
            String lopHoc = arrayList[2];
            String diaChi = arrayList[3];
            String ngaySinh = arrayList[4];
            String soDienThoai = arrayList[5];
            String gioiTinh = arrayList[6];
            String email = arrayList[7];
            HocSinh hocSinh = new HocSinh(idHocSinh, tenHocSinh, lopHoc, diaChi, ngaySinh, soDienThoai, gioiTinh, email);
            hocSinhList.add(hocSinh);
        }
        System.out.println("Mời bạn nhập tên học viên muốn xóa");
        String hoTenMuonXoa = scanner.nextLine();
        boolean isExist = false;
        for (HocSinh s : hocSinhList) {
            if (s.getTenHocSinh().equals(hoTenMuonXoa)) {
                isExist = true;
                boolean check = false;
                System.out.println("1.yes\n" +
                        "2.no");
                choose = scanner.nextLine();
                switch (choose) {
                    case "1":
                        for (int i = 0; i < hocSinhList.size(); i++) {
                            if (hocSinhList.get(i).getTenHocSinh().equals(hoTenMuonXoa)) {
                                check = true;
                                hocSinhList.remove(i);
                                i--;
                                System.out.println("Bạn đã xóa thành công " + hoTenMuonXoa);
                            }
                        }
                        if (!check) {
                            System.out.println("Tên bạn tìm không có trong danh sách " + hoTenMuonXoa);
                        }
                        String temp = "";
                        List<String> stringList1 = new ArrayList<>();
                        for (HocSinh hocSinh : hocSinhList) {
                            temp = hocSinh.idHocSinh + COMMA + hocSinh.tenHocSinh + COMMA + hocSinh.gioiTinh + COMMA
                                    + hocSinh.ngaySinh + COMMA + hocSinh.lopHoc + COMMA + hocSinh.soDienThoai + COMMA
                                    + hocSinh.gmail + COMMA + hocSinh.diaChi;
                            stringList1.add(temp);
                        }
                        String temp1 = "";
                        for (String s1 : stringList1) {
                            if (temp1.equals("")) {
                                temp1 += s1;
                            } else {
                                temp1 += "\n" + s1;
                            }
                        }
                        FileUtils.xoaSanPham(FILE_HOC_SINH, temp1, false);
                        break;
                    case "2":
                        System.exit(2);
                }
            }
        }
        if (!isExist) {
            System.out.println("khong co");
        }
    }

    public static void editGiaoVien() {
        boolean isExist = false;
        List<String> stringList = FileUtils.read(FILE_GIAO_VIEN);
        List<GiaoVien> giaoVienList = new ArrayList<>();
        for (int i = 0; i < stringList.size(); i++) {
            String[] arrayList = stringList.get(i).split(",");
            int maGiaoVien = Integer.parseInt(arrayList[0]);
            String tenGiaoVien = arrayList[1];
            String lopChuNhiem = arrayList[2];
            String diaChi = arrayList[3];
            String ngaySinh = arrayList[4];
            GiaoVien giaoVien = new GiaoVien(maGiaoVien, tenGiaoVien, lopChuNhiem, diaChi, ngaySinh);
            giaoVienList.add(giaoVien);
        }
        System.out.println("Mời bạn nhập tên giáo viên muốn sửa");
        String hoTenMuonSua = scanner.nextLine();
        for (int j = 0; j < giaoVienList.size(); j++) {
            if (giaoVienList.get(j).getTenGiaoVien().equals(hoTenMuonSua)) {
                isExist = true;
                boolean check = false;
                System.out.println("1.Yes\n" +
                        "2.No");
                choose = scanner.nextLine();
                switch (choose) {
                    case "1":
                        for (int i = 0; i < stringList.size(); i++) {
                            if (giaoVienList.get(i).getTenGiaoVien().equals(hoTenMuonSua)) {
                                check = true;
                                System.out.println("Tên muốn sửa là ");
                                String valueEdit = scanner.nextLine();
                                giaoVienList.get(i).setTenGiaoVien(valueEdit);
                                System.out.println("Tên đã sữa là : "+giaoVienList.get(i).getTenGiaoVien());
                                break;
                            }
                        }
                        if (!check) {
                            System.out.println("Ten bạn nhập không có trong danh sách");
                        }
                        List<String> stringList1 = new ArrayList<>();
                        String temp = "";
                        for (GiaoVien giaoVien : giaoVienList) {
                            temp = giaoVien.maGiaoVien + COMMA + giaoVien.tenGiaoVien + COMMA + giaoVien.ngaySinh +
                                    COMMA + giaoVien.lopChuNhiem + COMMA + giaoVien.diaChi;
                            stringList1.add(temp);
                        }
                        String temp1 = "";
                        for (String s : stringList1) {
                            if (temp1.equals("")) {
                                temp1 += s;
                            } else {
                                temp1 += "\n" + s;
                            }
                        }
                        FileUtils.suaSanPham(FILE_GIAO_VIEN, temp1, true);
                        break;
                    case "2":System.exit(2);
                }
            }
        }
        if (!isExist) {
            System.out.println("Khong co");
        }
    }

    public static void editHocSinh() {
        boolean isExits = false;
        List<String> stringList = FileUtils.read(FILE_HOC_SINH);
        List<HocSinh> hocSinhList = new ArrayList<>();
        for (int i = 0; i < stringList.size(); i++) {
            String[] arrayList = stringList.get(i).split(",");
            int idHocSinh = Integer.parseInt(arrayList[0]);
            String tenHocSinh = arrayList[1];
            String lopHoc = arrayList[2];
            String diaChi = arrayList[3];
            String ngaySinh = arrayList[4];
            String soDienThoai = arrayList[5];
            String gioiTinh = arrayList[6];
            String email = arrayList[7];
            HocSinh hocSinh = new HocSinh(idHocSinh, tenHocSinh, lopHoc, diaChi, ngaySinh, soDienThoai, gioiTinh, email);
            hocSinhList.add(hocSinh);
        }
        System.out.println("Mời bạn nhập tên học viên muốn sửa");
        String hoTenMuonSua = scanner.nextLine();
        for (int j = 0; j < hocSinhList.size();j++){
            if (hocSinhList.get(j).getTenHocSinh().equals(hoTenMuonSua)){
                isExits = true;
                boolean check = false;
                System.out.println("1.Yes\n" +
                        "2.No");
                choose = scanner.nextLine();
                switch (choose){
                    case "1":
                        for (int i = 0; i < stringList.size(); i++) {
                            if (hocSinhList.get(i).getTenHocSinh().equals(hoTenMuonSua)) {
                                check = true;
                                System.out.println("Tên muốn sửa là : ");
                                String valueEdit = scanner.nextLine();
                                hocSinhList.get(i).setTenHocSinh(valueEdit);
                                System.out.println("Tên đã sửa là : "+hocSinhList.get(i).getTenHocSinh());
                            }
                        }
                        List<String> listStrings = new ArrayList<>();
                        String temp = "";
                        for (HocSinh hocSinh : hocSinhList) {
                            temp = hocSinh.idHocSinh + COMMA + hocSinh.tenHocSinh + COMMA + hocSinh.gioiTinh + COMMA + hocSinh.ngaySinh
                                    + COMMA + hocSinh.lopHoc + COMMA + hocSinh.soDienThoai + COMMA + hocSinh.gmail + COMMA + hocSinh.diaChi;
                            listStrings.add(temp);
                        }
                        String temp1 = "";
                        for (String s : listStrings) {
                            if (temp1.equals("")) {
                                temp1 += s;
                            } else {
                                temp1 += "\n" + s;
                            }
                        }
                        FileUtils.suaSanPham(FILE_HOC_SINH, temp1, true);
                        break;
                    case "2": System.exit(2);
                }
            }
        }if (!isExits){
            System.out.println("Tên Bạn nhập không có");
        }
    }

    public static void hienThiDanhSachGV() {
        List<String> stringList = FileUtils.read(FILE_GIAO_VIEN);
        for (String s : stringList) {
            System.out.println(s);
        }
    }

    public static void hienThiDanhSachHS() {
        List<String> list = FileUtils.read(FILE_HOC_SINH);
        for (String s : list) {
            System.out.println(s);
        }
    }

    public static void hienThiDanhSachTreeSet() {
        List<String> stringList = FileUtils.read(FILE_GIAO_VIEN);
        List<GiaoVien> giaoVienList = new ArrayList<>();
        for (int i = 0; i < stringList.size(); i++) {
            String[] arrayList = stringList.get(i).split(",");
            int maGiaoVien = Integer.parseInt(arrayList[0]);
            String tenGiaoVien = arrayList[1];
            String lopChuNhiem = arrayList[2];
            String diaChi = arrayList[3];
            String ngaySinh = arrayList[4];
            GiaoVien giaoVien = new GiaoVien(maGiaoVien, tenGiaoVien, lopChuNhiem, diaChi, ngaySinh);
            giaoVienList.add(giaoVien);
        }
        TreeSet<GiaoVien> giaoVienTreeSet = new TreeSet<>(giaoVienList);
        for (GiaoVien giaoVien : giaoVienTreeSet) {
            System.out.println(giaoVien);
        }
    }

    public static void hienThiDanhSachHocSinhTS() {
        List<String> stringList = FileUtils.read(FILE_HOC_SINH);
        List<HocSinh> hocSinhList = new ArrayList<>();
        for (int i = 0; i < stringList.size(); i++) {
            String[] arrayList = stringList.get(i).split(",");
            int idHocSinh = Integer.parseInt(arrayList[0]);
            String tenHocSinh = arrayList[1];
            String lopHoc = arrayList[2];
            String diaChi = arrayList[3];
            String ngaySinh = arrayList[4];
            String soDienThoai = arrayList[5];
            String gioiTinh = arrayList[6];
            String email = arrayList[7];
            HocSinh hocSinh = new HocSinh(idHocSinh, tenHocSinh, lopHoc, diaChi, ngaySinh, soDienThoai, gioiTinh, email);
            hocSinhList.add(hocSinh);
        }
        TreeSet<HocSinh> hocSinhTreeSet = new TreeSet<>(hocSinhList);
        for (HocSinh hocSinh : hocSinhTreeSet) {
            System.out.println(hocSinh);
        }
    }
}
