package session_3.Bai_Tap;

import java.util.Arrays;
import java.util.Scanner;

public class GopMang {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhap so phan tu muon nhap vao mang 1");
        int[] array = new int[scanner.nextInt()];
        System.out.println("nhap so phan tu muon nhap vao mang 2");
        int[] array1 = new int[scanner.nextInt()];
        int[] array2 = new int[array.length + array1.length];
        for (int i = 0; i < array.length; i++) {
            System.out.println("Nhap phan tu thu " + (i + 1) + " cua mang 1:");
            array[i] = scanner.nextInt();
        }
        for (int i = 0; i < array1.length; i++) {
            System.out.println("Nhap phan tu thu " + (i + 1) + " cua mang 2:");
            array1[i] = scanner.nextInt();
        }
        for (int i = 0; i < array2.length; i++) {
            if (i < array.length) {
                array2[i] = array[i];
            } else {
                array2[i] = array1[i - array.length];
            }
        }
        System.out.println("Mang 1: " + Arrays.toString(array));
        System.out.println("Mang 2: " + Arrays.toString(array1));
        System.out.println("Mang 3: " + Arrays.toString(array2));
    }
}