package session_10.BaiTap;

import java.util.Scanner;
import java.util.Stack;

public class BinaryToDecimal1 {
    public static void main(String[] args) {
        int decimal = 0;
        int p = 0;
        Stack<Double> stack = new Stack();
        Scanner scanner = new Scanner(System.in);
        final StringBuilder stringBuilder = new StringBuilder();
        System.out.println("nhập số nhị phân cần chuyển : ");
        String string = scanner.nextLine();
        int res=0;
        for (int i = string.length()-1; i >= 0; i--) {
            res += (int) (Character.getNumericValue(string.charAt(i)) *Math.pow(2,i));
        }
        System.out.println(res);
    }
}
