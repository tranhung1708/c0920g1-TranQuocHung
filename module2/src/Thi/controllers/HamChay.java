package Thi.controllers;

import Thi.service.HamKhoiTao;

import java.util.Scanner;

public class HamChay {
    public static Scanner scanner = new Scanner(System.in);
    public static String choose = "0";

    public static void main(String[] args) {
        do {
            System.out.println("1.Thêm mới sổ tiết kiệm");
            System.out.println("2.Xóa sổ tiết kiệm");
            System.out.println("3.Xem danh sách sổ tiết kiệm");
            System.out.println("4.Xem thông tin khách hàng");
            System.out.println("5.Tìm sổ tiết kiệm");
            System.out.println("6.Thoát");
            choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    System.out.println("1.Thêm mới sổ dài hạn");
                    System.out.println("2.Thêm mới sổ vô thời hạn");
                    System.out.println("3.Thêm mới sổ có thời hạn");
                    choose = scanner.nextLine();
                    switch (choose) {
                        case "1":
                            HamKhoiTao.themMoiSoTietKiemDaiHan();
                            break;
                        case "2":
                            HamKhoiTao.themMoiSoVoThoiHan();
                            break;
                        case "3":
                            HamKhoiTao.themMoiSoCoThoiHan();
                    }
                    break;
                case "2":
                    System.out.println("1.xóa  sổ dài hạn");
                    System.out.println("2.xóa sổ vô thời hạn");
                    System.out.println("3.xóa sổ có thời hạn");
                    choose = scanner.nextLine();
                    switch (choose) {
                        case "1":
                            HamKhoiTao.xoaSoTietKiemDaiHan();
                            break;
                        case "2":
                            HamKhoiTao.xoaSoVoThoiHan();
                            break;
                        case "3":
                            HamKhoiTao.xoaCoThoiHan();
                    }
                    break;
                case "3":
                    System.out.println("1.xem danh sách  dài hạn");
                    System.out.println("2.xem danh sách vô thời hạn");
                    System.out.println("3.xem danh sách có thời hạn");
                    choose = scanner.nextLine();
                    switch (choose) {
                        case "1":
                            HamKhoiTao.xemDanhSachDaiHan();
                            break;
                        case "2":
                            HamKhoiTao.xemDanhSachSoTietKiemVoHan();
                            break;
                        case "3":
                            HamKhoiTao.xemDanhSachCoHan();
                    }
                    break;
                case "4":
                    break;
                case "5":
                    System.out.println("1.xóa  sổ dài hạn");
                    System.out.println("2.xóa sổ vô thời hạn");
                    System.out.println("3.xóa sổ có thời hạn");
                    choose = scanner.nextLine();
                    switch (choose) {
                        case "1":
                            HamKhoiTao.timMaSoDaiHan();
                            break;
                        case "2":
                            HamKhoiTao.timMaSoVohan();
                            break;
                        case "3":
                            HamKhoiTao.timDanhSachCoHan1();
                    }
                    break;
                case "6":
                    System.exit(6);
            }
        } while (true);
    }
}
