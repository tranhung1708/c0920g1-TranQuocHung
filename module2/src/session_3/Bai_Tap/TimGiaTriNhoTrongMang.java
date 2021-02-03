package session_3.Bai_Tap;

import java.util.Scanner;

public class TimGiaTriNhoTrongMang {
    public static void main(String[] args) {
        int size;
        int [] array;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Enter size");
            size = scanner.nextInt();
            if (size >  20 )
                System.out.println("size not 20");
        }while (size > 20);
        array = new int[size];
        int i = 0;
        while (i <array.length){
            System.out.println("Enter element " + (i + 1) + ":");
                    array[i] = scanner.nextInt();
                    i++;
        }
        System.out.print("Property list :");
        for (int j = 0  ; j < array.length ; j++){
            System.out.print(array[j] + "\t");
        }
        int min = array[0];
        for (int j  = 0 ; j < array.length ;j++){
            if (array[j] < min){
                min = array[j];
            }
        }
        System.out.println("phan tu nho nhat trong mang la " + min);
    }
}
