package Test2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {
    public static final String REGEX_TEN_SAN_PHAM = "^[A-Za-z]+( )[A-Za-z]+$";
    public static final String REGEX_GIA_BAN = "^[1-9][0-9]+$";
    public static final String REGEX_SO_LUONG = "^[1-9][0-9]+$";
    public static final String REGEX_NOI_SAN_XUAT = "^(([A-Za-z]+)|([A-Za-z]+( )[A-Za-z]+))$";
    private static Pattern pattern;
    private static Matcher matcher;

    public static boolean isTenSanPham(String tenSanPham){
        pattern = Pattern.compile(REGEX_TEN_SAN_PHAM);
        matcher = pattern.matcher(tenSanPham);
        boolean flag = matcher.matches();
        if (!flag){
            System.out.println("Nhập sai " + tenSanPham + "Mời nhập đúng định dạng Abc Abc");
        }
        return flag;
    }
    public static boolean isGiaBan(String giaBan){
        pattern = Pattern.compile(REGEX_GIA_BAN);
        matcher = pattern.matcher(giaBan);
        boolean flag = matcher.matches();
        if (!flag){
            System.out.println("Nhập sai" + giaBan + "Mời bạn nhập đúng định đạng 123456789");
        }
        return flag;
    }
    public static boolean isSoLuong(String soLuong){
        pattern = Pattern.compile(REGEX_SO_LUONG);
        matcher = pattern.matcher(soLuong);
        boolean flag = matcher.matches();
        if (!flag){
            System.out.println("Nhập sai" + soLuong + "Mời bạn nhập đúng định dạng 123456789");
        }
        return flag;
    }
    public static boolean isNoiSanXuat(String noiSanXuat){
        pattern = Pattern.compile(REGEX_NOI_SAN_XUAT);
        matcher = pattern.matcher(noiSanXuat);
        boolean flag = matcher.matches();
        if (!flag){
            System.out.println("Nhập sai" + noiSanXuat + " Mời nhập lại đúng đinh dạng ví dụ : Đa Nang");
        }
        return flag;
    }
}
