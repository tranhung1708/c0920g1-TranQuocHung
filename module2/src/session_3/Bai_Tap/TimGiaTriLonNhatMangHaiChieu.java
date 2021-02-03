package session_3.Bai_Tap;

import java.util.Scanner;

public class TimGiaTriLonNhatMangHaiChieu {
    public static void main(String[] args) {
        int m;
        int n;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap vao so dong cua mang hai chieu ");
        m = scanner.nextInt();
        System.out.println("nhap vao so cot cua mang hai chieu");
        n = scanner.nextInt();
        int A[][] = new int[m][n];
        System.out.println("nhap cac phan tu cho ma tran ");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("A[" + i + "][" + j + "] =");
                A[i][j] = scanner.nextInt();
            }
        }
        int max = A[0][0];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (max < A[i][j]) {
                    max = A[i][j];
                }
            }
        }
        System.out.println("phan tu lon nhat trong mang hai chieu la" + max);
    }
}
