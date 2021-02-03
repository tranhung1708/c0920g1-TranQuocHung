package session_2;

import java.util.Scanner;

public class UngDungTinhTienLaiChoVay {
    public static void main(String[] args) {
        double money = 1.0;
        int month = 1;
        double interest_rate = 1.0;
        Scanner input = new Scanner(System.in);
        System.out.println("Moi ban nhap so tien: ");
        money = input.nextDouble();
        System.out.println("Moi ban nhap thang gui: ");
        month = input.nextInt();
        System.out.println("Moi ban nhap lai suat : ");
        interest_rate = input.nextDouble();
        double total_interset = 0;
        for (int i =0 ; i < month ; i++){
            total_interset += money * (interest_rate/100)/12*month;
        }
        System.out.println("tong so tien lai : " + total_interset);
    }
}
