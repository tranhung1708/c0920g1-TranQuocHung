package session_10.BaiTap;

import javax.crypto.spec.PSource;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class ConvertFromDecimalToBinary {

    public static void main(String[] args) {
        Stack stack = new Stack();
        final StringBuilder stringBuilder = new StringBuilder();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số thập phân : ");
        int num = scanner.nextInt();
        while (num != 0 ){
            stack.push(num%2);
            num = Math.round(num)/ 2;
        }
        for (int i = 0 ; i < stack.size();){
        stringBuilder.append(stack.pop());
        }
        System.out.println("Số nhị phân " + stringBuilder);
    }

}
