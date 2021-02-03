package session_17.BaiTap;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {
    private static Pattern pattern;
    private static Matcher matcher;
    public static Scanner scanner = new Scanner(System.in);

    public static final String REGEX_CLASS = "^((C)|(A)|(P))\\d{4}((G)|(H)|(I)|(K)|(L)|(M))$";


    public static boolean IsValidate(String regex) {
        pattern = Pattern.compile(REGEX_CLASS);
        matcher = pattern.matcher(regex);
        return matcher.matches();
    }
    public static String class2;
    public static void main(String[] args) {
        do {
                System.out.println("Mời bạn nhập class : ");
                class2 = scanner.nextLine();
        }while (!IsValidate(class2));
    }
}
