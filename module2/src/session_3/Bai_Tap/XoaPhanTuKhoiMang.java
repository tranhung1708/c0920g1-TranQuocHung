package session_3.Bai_Tap;

import java.util.Scanner;

public class XoaPhanTuKhoiMang {
    public static void main(String[] args) {
        int enter;
        int[] arrayInt = {1, 3,3, 5, 7, 9, 12, 15, 18};
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap so can xoa : ");
        enter = scanner.nextInt();
        int index = 0;
        for (int i = 0; i < arrayInt.length; i++) {
            if (enter == arrayInt[i]) {
                index ++;
                break;
            }
        }
        for (int j = index; j < arrayInt.length - 1; j++) {
            arrayInt[j] = arrayInt[j + 1];
        }
        arrayInt[arrayInt.length - 1] = 0;
        System.out.println("Mang da xoa :");
        for (int i = 0; i < arrayInt.length; i++) {
            System.out.print(arrayInt[i] + " ");
        }
    }
}
