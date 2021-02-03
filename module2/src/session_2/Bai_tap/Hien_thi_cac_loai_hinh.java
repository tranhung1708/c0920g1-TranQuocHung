package session_2.Bai_tap;

import java.util.Scanner;

public class Hien_thi_cac_loai_hinh {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Menu");
        System.out.println("1.Ve hinh chu nhat");
        System.out.println("2.Ve hinh tam giac can");
        System.out.println("3.Ve hinh tam giac vuong");
        System.out.println("4.Exit");
        while (true) {
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    for (int i = 1; i <= 3; i++) {
                        for (int j = 1; j <= 7; j++) {
                            System.out.print("*");
                        }
                        System.out.println("\n");
                    }
                    break;
                case 2:
                    for (int i = 1; i <= 5; i++) {
                        for (int j = 1; j <= i; j++) {
                            System.out.print("*");
                        }
                        System.out.print("\n");
                    }
                    break;
                case 3:
                    for (int i = 7 ; i >=1;i-- ){
                        for (int j = 1 ; j <= i ;j++){
                            System.out.print("*");
                        }
                        System.out.println("\n");
                    }
                    break;
                case 4:
                    System.exit(4);
                default:
                    System.out.println("No choice");
            }
        }
    }
}
