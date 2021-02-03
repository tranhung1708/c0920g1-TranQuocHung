package Test4;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ServiceManager {
    public static Scanner scanner = new Scanner(System.in);
    public static final String FILE_MAN = "src/Test4/Man.csv";
    public static final String FILE_WOMEN = "src/Test4/Women.csv";
    public static String line;
    public static final String COMMA = ",";
    public static String name;
    public static String yearOld;
    public static String phoneNumber;
    public static String address;
    public static String identityCard;
    public static String job;

    public static void addNewHuman() {
        System.out.println("Mời bạn nhập tên");
        name = scanner.nextLine();
        System.out.println("Mời bạn nhập tuổi");
        yearOld = scanner.nextLine();
        System.out.println("Mời bạn nhập số điện thoại");
        phoneNumber = scanner.nextLine();
        System.out.println("Mời bạn nhập địa chỉ");
        address = scanner.nextLine();
        System.out.println("Mời bạn nhập chứng minh thư");
        identityCard = scanner.nextLine();
        System.out.println("Mời bạn nhập việc làm");
        job = scanner.nextLine();
    }

    public static void addNewMan() {
        addNewHuman();
        System.out.println("Mời bạn nhập xe");
        String driver = scanner.nextLine();
        System.out.println("Mời bạn nhập cách kiếm tiền");
        String howToMakeMoney = scanner.nextLine();
        System.out.println("Mời bạn nhập cách chơi với con");
        String playWithChildren = scanner.nextLine();
        line = name + COMMA + yearOld + COMMA + phoneNumber + COMMA + address + COMMA + identityCard + COMMA + job + COMMA
                + driver + COMMA + howToMakeMoney + COMMA + playWithChildren;
        FileUtils.themSanPham(FILE_MAN, line, true);
    }

    public static void addNewWomen() {
        addNewHuman();
        System.out.println("Mời bạn nhập việc nội trợ");
        String housewife = scanner.nextLine();
        System.out.println("Bạn giặt những gì");
        String washingClothes = scanner.nextLine();
        System.out.println("Mời bạn nhập nơi đón con");
        String pickUpYourBaby = scanner.nextLine();
        line = name + COMMA + yearOld + COMMA + phoneNumber + COMMA + address + COMMA + identityCard + COMMA + job + COMMA
                + housewife + COMMA + washingClothes + COMMA + pickUpYourBaby;
        FileUtils.themSanPham(FILE_WOMEN, line, true);
    }

    public static void deleteCustomer(String path){
        System.out.println("nhập ID cần xóa:");
        String ID = scanner.nextLine();
        List<String> stringList = FileUtils.read(path);
        boolean isCheckId = false;
        boolean isRemove = false;
        for (int i=0; i<stringList.size(); i++){
            String[] lineSplit = stringList.get(i).split(COMMA);
            if (lineSplit[0].equals(ID)){
                isCheckId = true;
                System.out.println("bạn có đồng ý xóa id: " + ID + " ko? \n" +
                        "Bấm y để xác nhận và ký tự khác để từ chối");
                String confirm = scanner.nextLine();
                if (confirm.equals("y")){
                    stringList.remove(i);
                    isRemove = true;
                    break;
                }
            }
        }if(!isCheckId){
            System.err.println("ko tìm thấy ID: " + ID);
        }if (isRemove){
            System.out.println("Đã xóa ID: " + ID + " khỏi danh sách");
        }
        String temp = "";
        for (String list: stringList){
            if (temp.equals("")) {
                temp += list;
            }else {
                temp += "\n" + list;
            }
        }
        try {
            FileWriter fileWriter = new FileWriter(path);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(temp);
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}