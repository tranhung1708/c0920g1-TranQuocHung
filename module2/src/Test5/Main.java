package Test5;

import Test4.Man;

import java.lang.invoke.SwitchPoint;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static String choose = "0";
    public static void main(String[] args) {
        do {
            System.out.println("1.Thêm");
            System.out.println("2.Sửa");
            System.out.println("3.xóa");
            System.out.println("4.tìm kiếm");
            System.out.println("5.hiển thị");
            System.out.println("6.Exit");
            choose = scanner.nextLine();
            switch (choose){
                case "1":
                    System.out.println("1.Con trai");
                    System.out.println("2.Con gái");
                    choose = scanner.nextLine();
                    switch (choose){
                        case "1":Manager.themConTrai();
                        break;
                        case "2": Manager.themConGai();
                        break;
                    }
                    break;
                case "2":
                    System.out.println("1.Con trai");
                    System.out.println("2.Con gái");
                    choose = scanner.nextLine();
                    switch (choose){
                        case "1": Manager.suaIdTrai();
                            break;
                        case "2":Manager.suaIdGai();
                    }
                    break;
                case "3":
                    System.out.println("1.Con trai");
                    System.out.println("2.Con gái");
                    choose = scanner.nextLine();
                    switch (choose){
                        case "1": Manager.xoaConTrai();
                        break;
                        case "2":Manager.xoaConGai();
                    }
                    break;
                case "4":
                    System.out.println("1.Con trai");
                    System.out.println("2.Con gái");
                    choose = scanner.nextLine();
                    switch (choose){
                        case "1": Manager.timIdTrai();
                            break;
                        case "2":Manager.timIdGai();
                    }
                    break;
                case "5":
                    System.out.println("1.Con trai");
                    System.out.println("2.Con gái");
                    choose = scanner.nextLine();
                    switch (choose){
                        case "1": Manager.hienThiIdGai();
                            break;
                        case "2":Manager.hienThiIdTrai();
                    }
                    break;
                case "6":
            }
        }while (true);
    }
}
