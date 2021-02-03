package session_2.Bai_tap;

import java.util.Scanner;

public class HienThi20SoNguyenToDauTien {
    public static void main(String[] args) {
        int numbers;
        int count = 0;
        int N = 2;
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhap so nguyen to dau tien: ");
        numbers = scanner.nextInt();
        while (count < numbers){
            int dem = 0;
            for (int i = 1 ; i <= N ;i++){
//                set bat N = 2 chia het cho 1 thi se cong bien i va dem
//                quay nguoc lai N =2 chia het cho i = 2 thoa dieu kien thi cong bien dem
                if (N % i ==0){
                    dem++;
                }
            }if (dem==2){
//         neu cai bien dem= 2 thi bien dem + count len
                System.out.println(N);
                count++;
            }
            N++;
        }

    }
}
