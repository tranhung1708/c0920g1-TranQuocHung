package session_10.BaiTap;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class DaoNguocChuoiTrongMang {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        String[] array = string.split("\\s");
        String str = "";
        System.out.println(Arrays.toString(array));
        Stack<String> mWord = new Stack<String>();
        for (int i = 0; i < array.length; i++) {
            mWord.push(array[i]);
        }
        for (int j = 0; j < array.length; j++) {
            str += mWord.pop() + " ";
        }
        System.out.println(str);
    }
}
