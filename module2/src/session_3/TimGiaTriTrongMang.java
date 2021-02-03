package session_3;

import java.util.Scanner;

public class TimGiaTriTrongMang {
    public static void main(String[] args) {
        String[] student = {"Christian", "Michael", "Camila", "Sienna", "Tanya", "Connor", "Zachariah", "Mallory", "Zoe", "Emily"};
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a name's student");
        String input_name = scanner.nextLine();
        boolean isExist = false;
        for (int i = 0 ; i < student.length;i++){
            if (student[i].equals(input_name)){
                System.out.println("Vị trí của các sinh viên trong danh sách :"+ input_name + " is " +(i+1));
                isExist = true;
                break;
            }
        }
        if (!isExist){
            System.out.println("Không tìm thấy"+ input_name + "is the list.");
        }
    }
}
