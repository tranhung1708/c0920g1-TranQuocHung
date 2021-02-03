package session_3.Bai_Tap;

import java.util.Arrays;
import java.util.Scanner;

public class ThemPhanTuVaoMang {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] arr2 = new int[arr.length + 1];
        System.out.println("Nhập số cần chèn:");
        int x = input.nextInt();
        System.out.println("Nhập vị trí chèn:");
        int index = input.nextInt();
        if (index < 0 || index >= arr.length) {
            System.out.println("Không chèn được phần tử vào mảng");
        }
        for (int i = 0; i < arr2.length; i++) {
            if (i < index) {
                arr2[i] = arr[i];
            } else if (i == index) {
                arr2[i] = x;
            } else if (i > index) {
                arr2[i] = arr[i - 1];
            }
        }
        System.out.println(Arrays.toString(arr2));
    }
}

