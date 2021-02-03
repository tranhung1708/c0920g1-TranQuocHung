package Thi.validate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
    public static final String REGEX = "^([A-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸ" +
            "ẺẼỀỀỂỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪỬỮỰỲỴÝỶỸ]" +
            "([a-zàáâãèéêìíòóôõùúăđĩũơưăạảấầẩẫậắằẳẵặẹẻẽềềểễệỉịọỏốồổỗộớờởỡợụủứừửữựỳỵ" +
            "ỷỹ]*)[ ])+[A-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨ" +
            "ƠƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪỬỮỰỲỴÝỶỸ]([a-zàáâãè" +
            "éêìíòóôõùúăđĩũơưăạảấầẩẫậắằẳẵặẹẻẽềềểễệỉịọỏố" +
            "ồổỗộớờởỡợụủứừửữựỳỵỷỹ]*)$";
    public static final String REGEX_TUOI = "^([1-9]|[1-2][0-9]|(30)|(31))\\/([1-9]|" +
            "(1)[0-2])\\/((19)[0-9][0-9]|(200)[0-2])$";
    public static final String REGEX_EMAIL = "^([a-zA-Z0-9_\\.\\-])+\\@(([a-zA-Z0-9\\-])+\\.)" +
            "+([a-zA-Z0-9]{2,4})+$";
    public static final String REGEX_SDT = "^(84)\\d{10}$";
    public static final String REDEX_CMND = "^\\d{9}$";
    public static final String REGEX_TEN = "^([A-Z][a-z]*[ ])*([A-Z][a-z]*)$";
    public static final String REGEX_TUOI_NAM_NHUAN= "^(((0[1-9]|[12][0-9]|30)[-\\\\" +
            "/](0[13-9]|1[012])|31[-\\\\/]" +
            "(0[13578]|1[02])|(0[1-9]|1[0-9]|2[0-8])[-\\\\/]02)\" +\n" +
            "\"[-\\\\/](19[0-9]{2}|200[012])|29[-\\\\/]02[-\\\\/]\" +\n" +
            "  \"([0-9]{2}(([2468][048]|[02468][48])|[13579][26])|([13579]" +
            "[26]|[02468][048]|0[0-9]|1[0-6])00))$";
    public static final String REGEX_GIOI_TINH = "([Mm][Aa][Ll][Ee])|([Ff][Ee][Mm][Aa][Ll][Ee])" +
            "|([Uu][Nn][Kk][Nn][Oo][Ww][Nn])";
    private static Pattern pattern;
    private static Matcher matcher;

    public static boolean isRegex(String ten) {
        pattern = Pattern.compile(REGEX);
        matcher = pattern.matcher(ten);
        boolean flag = matcher.matches();
        if (!flag ){
            System.out.println("Bạn nhập sai " + ten + "Mời bạn nhập lại theo định dạng Trần Văn Abc" );
        }
        return flag;
    }
    public static boolean isRegexTuoi (String tuoi){
        pattern = Pattern.compile(REGEX_TUOI);
        matcher = pattern.matcher(tuoi);
        boolean flag = matcher.matches();
        if (!flag){
            System.out.println("Bạn nhập sai" + tuoi + "Mời bạn nhập lại theo định dạng <18 tuổi");
        }
        return flag;
    }
    public static boolean isEmail(String email){
        pattern = Pattern.compile(REGEX_EMAIL);
        matcher = pattern.matcher(email);
        boolean flag = matcher.matches();
        if (!flag){
            System.out.println("Bạn nhập sai " + " Mời bạn nhập lại theo định dạng abc@abc.aac");
        }
        return flag;
    }
    public static boolean isSdt(String sdt){
        pattern = Pattern.compile(REGEX_SDT);
        matcher = pattern.matcher(sdt);
        boolean flag = matcher.matches();
        if (!flag){
            System.out.println("Bạn nhập sai " + " Mời bạn nhập lại theo định dạng 840123456789");
        }
        return flag;
    }
    public static boolean isCmnd(String cmnd){
        pattern = Pattern.compile(REDEX_CMND);
        matcher = pattern.matcher(cmnd);
        boolean flag= matcher.matches();
        if (!flag){
            System.out.println("Bạn nhập sai " + " Mời bạn nhập lại theo định dạng xxxxxxxxx");
        }
        return flag;
    }
}
