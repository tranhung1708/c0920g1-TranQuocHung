package Thi.service;

import Test5.Trai;
import Thi.common.FileUtils;
import Thi.model.SoTietKiemCoThoiHan;
import Thi.model.SoTietKiemDaiHan;
import Thi.model.SoTietKiemVoThoiHan;

import javax.xml.bind.SchemaOutputResolver;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HamKhoiTao {
    public static Scanner scanner = new Scanner(System.in);
    public static String line;
    public static String choose = "0";
    public static boolean kiemTra = false;
    public static final String COMMA = ",";
    public static final String FILE_KHACH_HANG = "src/Thi/data/KhachHang.csv";
    public static final String FILE_SO_TIET_KIEM_DAI_HAN = "src/Thi/data/SoTietKiemDaiHan.csv";
    public static final String FILE_SO_TIET_KIEM_VO_THOI_HAN = "src/Thi/data/SoTietKiemVoThoiHan.csv";
    public static final String FILE_SO_TIET_KIEM_CO_THOI_HAN = "src/Thi/data/SoTietKiemCoThoiHan.csv";

    public static void themMoiSoTietKiemDaiHan() {
        System.out.println("Mời bạn nhập mã số sổ");
        String maSoSo = scanner.nextLine();
        System.out.println("Mời bạn nhập mã khách hàng");
        String maKhachHang = scanner.nextLine();
        System.out.println("Mời bạn nhập ngày mở sổ");
        String ngayMoSo = scanner.nextLine();
        System.out.println("Mời bạn nhập thời gian gửi");
        String thoiGianKiGui = scanner.nextLine();
        System.out.println("Mời bạn kì hạn");
        String kiHan = scanner.nextLine();
        System.out.println("Mời bạn nhập số tiền gửi");
        String soTienGui = scanner.nextLine();
        System.out.println("Mời bạn nhập lãi xuất");
        String laiSuat = scanner.nextLine();
        System.out.println("Mời bạn nhập ưu đãi");
        String uuDai = scanner.nextLine();
        line = maSoSo + COMMA + maKhachHang + COMMA + ngayMoSo + COMMA + thoiGianKiGui + COMMA + kiHan + COMMA +
                soTienGui + COMMA + laiSuat + COMMA + uuDai;
        FileUtils.themMoiSo(FILE_SO_TIET_KIEM_DAI_HAN, line, true);
    }
    public static void themKhachHang (){
        System.out.println("Mời bạn nhập mã số khách hàng");
        String maKhachHang = scanner.nextLine();
        System.out.println("Mời bạn nhập tên khách hàng");
        String tenKhachHang = scanner.nextLine();
        System.out.println("Mời bạn nhập ngày sinh");
        String ngaySinh = scanner.nextLine();
        System.out.println("Mời bạn nhập giới tính");
        String gioiTinh = scanner.nextLine();
        System.out.println("Mời bạn nhập số điện thoại");
        String soDienThoai = scanner.nextLine();
        System.out.println("Mời bạn nhập địa chỉ");
        String diaChi = scanner.nextLine();
        line = maKhachHang+COMMA+tenKhachHang+COMMA+ngaySinh+COMMA+gioiTinh+COMMA+soDienThoai+
                COMMA+diaChi;
        FileUtils.themMoiSo(FILE_KHACH_HANG,line,true);
    }

    public static void themMoiSoVoThoiHan() {
        System.out.println("Mời bạn nhập mã số sổ");
        String maSoSo = scanner.nextLine();
        System.out.println("Mời bạn nhập mã khách hàng");
        String maKhachHang = scanner.nextLine();
        System.out.println("Mời bạn nhập ngày mở sổ");
        String ngayMoSo = scanner.nextLine();
        System.out.println("Mời bạn nhập thời gian gửi");
        String thoiGianKiGui = scanner.nextLine();
        System.out.println("Mời bạn nhập số tiền gửi");
        String soTienGui = scanner.nextLine();
        System.out.println("Mời bạn nhập lãi suất");
        String laiSuat = scanner.nextLine();
        line = maSoSo + COMMA + maKhachHang + COMMA + ngayMoSo + COMMA + thoiGianKiGui + COMMA +
                soTienGui + COMMA + laiSuat;
        FileUtils.themMoiSo(FILE_SO_TIET_KIEM_VO_THOI_HAN, line, true);
    }

    public static void themMoiSoCoThoiHan() {
        System.out.println("Mời bạn nhập mã số sổ");
        String maSoSo = scanner.nextLine();
        System.out.println("Mời bạn nhập mã khách hàng");
        String maKhachHang = scanner.nextLine();
        System.out.println("Mời bạn nhập ngày mở sổ");
        String ngayMoSo = scanner.nextLine();
        System.out.println("Mời bạn nhập thời gian gửi");
        String thoiGianKiGui = scanner.nextLine();
        System.out.println("Mời bạn nhập kì hạn");
        String kiHan = scanner.nextLine();
        System.out.println("Mời bạn nhập số tiền gửi ");
        String soTienGui = scanner.nextLine();
        System.out.println("Mời bạn nhập lãi suất");
        String laiSuat = scanner.nextLine();
        line = maSoSo + COMMA + maKhachHang + COMMA + ngayMoSo + COMMA + thoiGianKiGui + COMMA +
                kiHan + COMMA + soTienGui + COMMA + laiSuat;
        FileUtils.themMoiSo(FILE_SO_TIET_KIEM_CO_THOI_HAN, line, true);
    }

    public static void xoaSoTietKiemDaiHan() {
        List<String> stringList = FileUtils.read(FILE_SO_TIET_KIEM_DAI_HAN);
        List<SoTietKiemDaiHan> soTietKiemDaiHans = new ArrayList<>();
        for (int i = 0; i < stringList.size(); i++) {
            String[] mangDaiHan = stringList.get(i).split(",");
            SoTietKiemDaiHan soTietKiemDaiHan = new SoTietKiemDaiHan(mangDaiHan[0], mangDaiHan[1], mangDaiHan[2],
                    mangDaiHan[3], mangDaiHan[4], mangDaiHan[5], mangDaiHan[6], mangDaiHan[7]);
            soTietKiemDaiHans.add(soTietKiemDaiHan);
        }
        System.out.println("Mời bạn nhập mã số sổ muốn xóa");
        String maSoSo = scanner.nextLine();
        for (int j = 0; j < soTietKiemDaiHans.size(); j++) {
            if (soTietKiemDaiHans.get(j).getMaSoSo().equals(maSoSo)) {
                kiemTra = true;
                System.out.println("Bạn có muốn xóa mã số sổ muốn xóa ");
                System.out.println("1.Yes");
                System.out.println("2.No");
                choose = scanner.nextLine();
                switch (choose) {
                    case "1":
                        for (int i1 = 0; i1 < soTietKiemDaiHans.size(); i1++) {
                            if (soTietKiemDaiHans.get(i1).getMaSoSo().equals(maSoSo)) {
                                soTietKiemDaiHans.remove(i1);
                                System.out.println("Bạn đã xóa thành công mã số sổ" + maSoSo);
                                break;
                            }
                        }
                        List<String> stringList1 = new ArrayList<>();
                        String temp = "";
                        for (SoTietKiemDaiHan soTietKiemDaiHan1 : soTietKiemDaiHans) {
                            temp = soTietKiemDaiHan1.getMaSoSo() + COMMA + soTietKiemDaiHan1.getMaKhachHang()
                                    + COMMA + soTietKiemDaiHan1.getNgayMoSo() + COMMA + soTietKiemDaiHan1.getThoiGianKiGui() +
                                    COMMA + soTietKiemDaiHan1.getKiHan() + COMMA + soTietKiemDaiHan1.getSoTienGui() +
                                    COMMA + soTietKiemDaiHan1.getLaiXuat() + COMMA + soTietKiemDaiHan1.getUuDai();
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
                        FileUtils.xoaSanPham(FILE_SO_TIET_KIEM_DAI_HAN, temp1, false);
                        break;
                    case "2":
                        System.exit(2);
                }
            }
        }
        if (!kiemTra) {
            System.out.println("Mã số bạn nhập không có trong danh sách");
        }
    }

    public static void xoaSoVoThoiHan() {
        List<String> stringList = FileUtils.read(FILE_SO_TIET_KIEM_VO_THOI_HAN);
        List<SoTietKiemVoThoiHan> soTietKiemVoThoiHans = new ArrayList<>();
        for (int i = 0; i < stringList.size(); i++) {
            String[] mangVoThoiHan = stringList.get(i).split(",");
            SoTietKiemVoThoiHan soTietKiemVoThoiHan = new SoTietKiemVoThoiHan(mangVoThoiHan[0],
                    mangVoThoiHan[1], mangVoThoiHan[2], mangVoThoiHan[3], mangVoThoiHan[4], mangVoThoiHan[5]);
            soTietKiemVoThoiHans.add(soTietKiemVoThoiHan);
            System.out.println(soTietKiemVoThoiHans);
        }
        System.out.println("Mời bạn nhập mã số sổ muốn xóa");
        String maSoSo = scanner.nextLine();
        for (int j = 0; j < soTietKiemVoThoiHans.size(); j++) {
            if (soTietKiemVoThoiHans.get(j).getMaSoSo().equals(maSoSo)) {
                kiemTra = true;
                System.out.println("Bạn có muốn xóa mã số sổ muốn xóa ");
                System.out.println("1.Yes");
                System.out.println("2.No");
                choose = scanner.nextLine();
                switch (choose) {
                    case "1":
                        for (int i1 = 0; i1 < soTietKiemVoThoiHans.size(); i1++) {
                            if (soTietKiemVoThoiHans.get(i1).getMaSoSo().equals(maSoSo)) {
                                System.out.println(soTietKiemVoThoiHans);
                                soTietKiemVoThoiHans.remove(i1);
                                System.out.println("Bạn đã xóa thành công mã số sổ" + maSoSo);
                                break;
                            }
                        }
                        List<String> stringList1 = new ArrayList<>();
                        String temp = "";
                        for (SoTietKiemVoThoiHan soTietKiemVoThoiHan : soTietKiemVoThoiHans) {
                            temp = soTietKiemVoThoiHan.getMaSoSo() + COMMA + soTietKiemVoThoiHan.getMaKhachHang()
                                    + COMMA + soTietKiemVoThoiHan.getNgayMoSo() + COMMA + soTietKiemVoThoiHan.getThoiGianGui() +
                                    COMMA + soTietKiemVoThoiHan.getSoTienGui() +
                                    COMMA + soTietKiemVoThoiHan.getLaiSuat();
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
                        FileUtils.xoaSanPham(FILE_SO_TIET_KIEM_VO_THOI_HAN, temp1, false);
                        break;
                    case "2":
                        System.exit(2);
                }
            }
        }
        if (!kiemTra) {
            System.out.println("Mã số bạn nhập không có trong danh sách");
        }
    }

    public static void xoaCoThoiHan() {
        List<String> stringList = FileUtils.read(FILE_SO_TIET_KIEM_CO_THOI_HAN);
        List<SoTietKiemCoThoiHan> soTietKiemCoThoiHanList = new ArrayList<>();
        for (int i = 0; i < stringList.size(); i++) {
            String[] mangCoThoiHan = stringList.get(i).split(",");
            SoTietKiemCoThoiHan soTietKiemCoThoiHan = new SoTietKiemCoThoiHan(mangCoThoiHan[0], mangCoThoiHan[1],
                    mangCoThoiHan[2], mangCoThoiHan[3], mangCoThoiHan[4], mangCoThoiHan[5], mangCoThoiHan[6]);
            soTietKiemCoThoiHanList.add(soTietKiemCoThoiHan);
        }
        System.out.println("Mời bạn nhập mã số sổ muốn xóa");
        String maSoSo = scanner.nextLine();
        for (int j = 0; j < soTietKiemCoThoiHanList.size(); j++) {
            if (soTietKiemCoThoiHanList.get(j).getMaSoSo().equals(maSoSo)) {
                kiemTra = true;
                System.out.println("Bạn có muốn xóa mã số sổ muốn xóa ");
                System.out.println("1.Yes");
                System.out.println("2.No");
                choose = scanner.nextLine();
                switch (choose) {
                    case "1":
                        for (int i1 = 0; i1 < soTietKiemCoThoiHanList.size(); i1++) {
                            if (soTietKiemCoThoiHanList.get(i1).getMaSoSo().equals(maSoSo)) {
                                soTietKiemCoThoiHanList.remove(i1);
                                System.out.println("Bạn đã xóa thành công mã số sổ" + maSoSo);
                                break;
                            }
                        }
                        List<String> stringList1 = new ArrayList<>();
                        String temp = "";
                        for (SoTietKiemCoThoiHan soTietKiemCoThoiHan : soTietKiemCoThoiHanList) {
                            temp = soTietKiemCoThoiHan.getMaSoSo() + COMMA + soTietKiemCoThoiHan.getMaKhachHang()
                                    + COMMA + soTietKiemCoThoiHan.getNgayMoSo() + COMMA + soTietKiemCoThoiHan.getThoiGianBatDauGui() +
                                    COMMA + soTietKiemCoThoiHan.getKiHan() + COMMA + soTietKiemCoThoiHan.getSoTienGui() +
                                    COMMA + soTietKiemCoThoiHan.getLaiSuat();
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
                        FileUtils.xoaSanPham(FILE_SO_TIET_KIEM_CO_THOI_HAN, temp1, false);
                        break;
                    case "2":
                        System.exit(2);
                }
            }
        }
        if (!kiemTra) {
            System.out.println("Mã số sổ bạn nhập không có");
        }
    }
    public static void xemDanhSachSoTietKiemVoHan(){
        List<String> stringList = FileUtils.read(FILE_SO_TIET_KIEM_VO_THOI_HAN);
        for (String s : stringList){
            System.out.println(s);
        }
    }
    public static void xemDanhSachDaiHan(){
        List<String> list = FileUtils.read(FILE_SO_TIET_KIEM_DAI_HAN);
        for (String s : list){
            System.out.println(s);
        }
    }
    public static void xemDanhSachCoHan(){
        List<String> stringList = FileUtils.read(FILE_SO_TIET_KIEM_CO_THOI_HAN);
        for (String s : stringList){
            System.out.println(s);
        }
    }
    public static void timMaSoDaiHan(){
        List<String> stringList = FileUtils.read(FILE_SO_TIET_KIEM_DAI_HAN);
        List<SoTietKiemDaiHan> soTietKiemDaiHans = new ArrayList<>();
        for (int i = 0; i < stringList.size(); i++) {
            String[] mangDaiHan = stringList.get(i).split(",");
            SoTietKiemDaiHan soTietKiemDaiHan = new SoTietKiemDaiHan(mangDaiHan[0], mangDaiHan[1], mangDaiHan[2],
                    mangDaiHan[3], mangDaiHan[4], mangDaiHan[5], mangDaiHan[6], mangDaiHan[7]);
            soTietKiemDaiHans.add(soTietKiemDaiHan);
        }
        System.out.println("Mời bạn nhập mã số sổ muốn tìm");
        String maSoSo = scanner.nextLine();
        for (int i  =0 ; i < soTietKiemDaiHans.size();i++){
            if (soTietKiemDaiHans.get(i).getMaSoSo().contains(maSoSo)){
                System.out.println(soTietKiemDaiHans.get(i));
            }
        }
    }
    public static void timMaSoVohan(){
        List<String> stringList = FileUtils.read(FILE_SO_TIET_KIEM_VO_THOI_HAN);
        List<SoTietKiemVoThoiHan> soTietKiemVoThoiHans = new ArrayList<>();
        for (int i = 0; i < stringList.size(); i++) {
            String[] mangVoThoiHan = stringList.get(i).split("");
            SoTietKiemVoThoiHan soTietKiemVoThoiHan = new SoTietKiemVoThoiHan(mangVoThoiHan[0],
                    mangVoThoiHan[1], mangVoThoiHan[2], mangVoThoiHan[3], mangVoThoiHan[4], mangVoThoiHan[5]);
            soTietKiemVoThoiHans.add(soTietKiemVoThoiHan);
        }
        System.out.println("Mời bạn nhập mã số sổ muốn tìm");
        String maSoSo = scanner.nextLine();
        for (int i = 0 ;i < soTietKiemVoThoiHans.size();i++){
            if (soTietKiemVoThoiHans.get(i).getMaSoSo().contains(maSoSo)){
                System.out.println(soTietKiemVoThoiHans.get(i));
            }
        }
    }
    public static void timDanhSachCoHan1(){
        List<String> stringList = FileUtils.read(FILE_SO_TIET_KIEM_CO_THOI_HAN);
        List<SoTietKiemCoThoiHan> soTietKiemCoThoiHanList = new ArrayList<>();
        for (int i = 0; i < stringList.size(); i++) {
            String[] mangCoThoiHan = stringList.get(i).split(",");
            SoTietKiemCoThoiHan soTietKiemCoThoiHan = new SoTietKiemCoThoiHan(mangCoThoiHan[0], mangCoThoiHan[1],
                    mangCoThoiHan[2], mangCoThoiHan[3], mangCoThoiHan[4], mangCoThoiHan[5], mangCoThoiHan[6]);
            soTietKiemCoThoiHanList.add(soTietKiemCoThoiHan);
        }
        System.out.println("Mời bạn nhập mã số sổ muốn tìm");
        String maSoSo = scanner.nextLine();
        for (int i =0 ; i < soTietKiemCoThoiHanList.size();i++){
            if (soTietKiemCoThoiHanList.get(i).getMaSoSo().contains(maSoSo)){
                System.out.println(soTietKiemCoThoiHanList.get(i));
            }
        }
    }
}
