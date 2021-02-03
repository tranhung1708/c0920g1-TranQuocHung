package Bai_Tap;

import java.util.Scanner;

public class UngDungChuyenDoiTienTe {
    public static void main(String[] args) {
        double vnd = 23000;
        double usd;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter is a USD : ");
        usd = scanner.nextDouble();
        double exchange = usd * 23000;
        System.out.println("value in VND is: "+ exchange);
    }
}
