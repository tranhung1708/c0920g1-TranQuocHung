package session_10.BaiTap;

import java.util.Scanner;

public class BinaryToDecimal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào số nhị phân cần chuyển : ");
        String binaryString = scanner.nextLine();
        //chuyển đổi từ số nhị phân thành số thập phân
        System.out.println(Integer.parseInt(binaryString,2));
        //chuyển đổi số thập phân thành nhị phân
        System.out.println(Integer.toBinaryString(124));
    }
}
