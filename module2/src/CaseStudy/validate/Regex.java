package CaseStudy.validate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
    public static final String ID_VILLA_VILLA = "^SVVL-\\d{4}$";
    public static final String ID_VILLA_HOUSE = "^SVHO-\\d{4}$";
    public static final String ID_VILLA_ROOM = "^SVRO-\\d{4}$";
    public static final String TEN_DICH_VU = "^([A-Z][a-z]+)$";
    public static final String TEN_LOAI_KHACH = "^([A-Z][a-z]+)$";
    public static final String DIEN_TICH_SU_DUNG = "^(([3-9][0-9]+)|([1-9][0-9][0-9])|([1-9][0-9][0-9][0-9][0-9])|([1-9][0-9]{3}))$";
    public static final String DIEN_TICH_HO_BOI = "^(([3-9][0-9]+)|([1-9][0-9][0-9])|([1-9][0-9][0-9][0-9][0-9])|([1-9][0-9]{3}))$";
    public static final String CHI_PHI_THUE = "^[1-9]+$";
    public static final String KIEU_THUE = "^((Year)|(Month)|(Day)|(hours))$";
    public static final String SO_LUONG_NGUOI_TOI_DA = "^([1-9]|(1)[0-9]|(20))$";
    public static final String SO_TANG = "^[1-9]+$";
    public static final String DINH_DANG_NGAY_SINH = "^([1-9]|[1-2][0-9]|(30)|(31))\\/([1-9]|(1)[0-2])\\/((19)[0-9][0-9]|(200)[0-2])$";
    public static final String DINH_DANG_EMAIL = "^([a-zA-Z0-9_\\.\\-])+\\@(([a-zA-Z0-9\\-])+\\.)+([a-zA-Z0-9]{2,4})+$";
    public static final String DINH_DANG_GIOI_TINH = "^((Male)|(Female)|(Unknow))$";
    public static final String DINH_DANG_ID_CARD = "^\\d{9}$";
    public static final String DINH_DANG_TEN = "^([A-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪỬỮỰỲỴÝỶỸ]([a-zàáâãèéêìíòóôõùúăđĩũơưăạảấầẩẫậắằẳẵặẹẻẽềềểễệỉịọỏốồổỗộớờởỡợụủứừửữựỳỵỷỹ]*)[ ])+[A-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪỬỮỰỲỴÝỶỸ]([a-zàáâãèéêìíòóôõùúăđĩũơưăạảấầẩẫậắằẳẵặẹẻẽềềểễệỉịọỏốồổỗộớờởỡợụủứừửữựỳỵỷỹ]*)$";
    public static final String DINH_DANG_SDT = "^(84)\\d{10}$";
    public static final String DICH_VU_DI_KEM = "^((Massage)|(Karaoke)|(Food)|(Water)|(Car rental))$";
    private static Pattern pattern;
    private static Matcher matcher;

    public static boolean IsIdVilla(String idVIlla) {
        pattern = Pattern.compile(ID_VILLA_VILLA);
        matcher = pattern.matcher(idVIlla);
        boolean flag = matcher.matches();
        if (!flag) {
            System.out.println("Nhập sai :" + idVIlla + "mời nhập lại theo " + "SVVL-0000");
        }
        return flag;
    }

    public static boolean IsIdHouse(String idHouse) {
        pattern = Pattern.compile(ID_VILLA_HOUSE);
        matcher = pattern.matcher(idHouse);
        boolean flag = matcher.matches();
        if (!flag) {
            System.out.println("Nhập sai :" + idHouse + "mời nhập lại theo SVHO-0000");
        }
        return flag;
    }

    public static boolean IsIdRoom(String idRoom) {
        pattern = Pattern.compile(ID_VILLA_ROOM);
        matcher = pattern.matcher(idRoom);
        boolean flag = matcher.matches();
        if (!flag) {
            System.out.println("Nhập sai: " + idRoom + " mời bạn nhập lại SVRO-0000");
        }
        return flag;
    }

    public static boolean IsTenDichVu(String tenDichVu) {
        pattern = Pattern.compile(TEN_DICH_VU);
        matcher = pattern.matcher(tenDichVu);
        boolean flag = matcher.matches();
        if (!flag) {
            System.out.println("Nhập sai : " + tenDichVu + "Mời bạn nhập lại theo Abcdef");
        }
        return flag;
    }

    public static boolean IsDienTichSuDung(String dienTichSuDung) {
        pattern = Pattern.compile(DIEN_TICH_SU_DUNG);
        matcher = pattern.matcher(dienTichSuDung);
        boolean flag = matcher.matches();
        if (!flag) {
            System.out.println("Nhập sai " + dienTichSuDung + "Mời nhập lại theo <30m2");
        }
        return flag;
    }

    public static boolean IsChiPhiThue(String chiPhiThue) {
        pattern = Pattern.compile(CHI_PHI_THUE);
        matcher = pattern.matcher(chiPhiThue);
        boolean flag = matcher.matches();
        if (!flag) {
            System.out.println("Nhập sai " + chiPhiThue + " Mời nhập lại theo 100000000");
        }
        return flag;
    }

    public static boolean IsSoLuongNguoi(String soLuongNguoi) {
        pattern = Pattern.compile(SO_LUONG_NGUOI_TOI_DA);
        matcher = pattern.matcher(soLuongNguoi);
        boolean flag = matcher.matches();
        if (!flag) {
            System.out.println("Nhập sai : " + soLuongNguoi + "Mời bạn nhập lại <0 và >20");
        }
        return flag;
    }

    public static boolean IsKieuThue(String kieuThue) {
        pattern = Pattern.compile(KIEU_THUE);
        matcher = pattern.matcher(kieuThue);
        boolean flag = matcher.matches();
        if (!flag) {
            System.out.println("Nhập sai : " + kieuThue + "Mời bạn nhập lại Abcdef...");
        }
        return flag;
    }

    public static boolean IsSoTang(String soTang) {
        pattern = Pattern.compile(SO_TANG);
        matcher = pattern.matcher(soTang);
        boolean flag = matcher.matches();
        if (!flag) {
            System.out.println("Nhập sai : " + soTang + "Mời bạn nhập lại 12345...");
        }
        return flag;
    }

    public static boolean IsGiaTien(String giaTien) {
        pattern = Pattern.compile(CHI_PHI_THUE);
        matcher = pattern.matcher(giaTien);
        boolean flag = matcher.matches();
        if (!flag) {
            System.out.println("Nhập sai : " + giaTien + "Mời bạn nhập lại 12345678...");
        }
        return flag;
    }

    public static boolean IsNgaysinh(String ngaySinh) {
        pattern = Pattern.compile(DINH_DANG_NGAY_SINH);
        matcher = pattern.matcher(ngaySinh);
        boolean flag = matcher.matches();
        if (!flag) {
            System.out.println("Nhập sai : " + ngaySinh + "Mời bạn nhập lại 11/11/1900");
        }
        return flag;
    }

    public static boolean IsEmail(String email) {
        pattern = Pattern.compile(DINH_DANG_EMAIL);
        matcher = pattern.matcher(email);
        boolean flag = matcher.matches();
        if (!flag) {
            System.out.println("Nhập sai : " + email + "Mời bạn nhập lại abc@abc.abc");
        }
        return flag;
    }

    public static boolean IsName(String name) {
        pattern = Pattern.compile(DINH_DANG_TEN);
        matcher = pattern.matcher(name);
        boolean flag = matcher.matches();
        if (!flag) {
            System.out.println("Nhập sai : " + "Mời bạn nhập lại Nguyễn Văn A");
        }
        return flag;
    }
    public static boolean IsGender(String gender){
        pattern = Pattern.compile(DINH_DANG_GIOI_TINH);
        matcher = pattern.matcher(gender);
        boolean flag = matcher.matches();
        if (!flag){
            System.out.println("Nhập sai " + gender + "Mời bạn nhập lại (Male)(Female)(Unknow)");
        }
        return flag;
    }
    public static boolean IsIDCard(String idCard){
        pattern = Pattern.compile(DINH_DANG_ID_CARD);
        matcher = pattern.matcher(idCard);
        boolean flag = matcher.matches();
        if (!flag){
            System.out.println("Nhập sai" + idCard + "Mời bạn nhập lại xxxxxxxxx");
        }
        return flag;
    }
    public static boolean IsNumberPhone(String numberPhone){
        pattern = Pattern.compile(DINH_DANG_SDT);
        matcher = pattern.matcher(numberPhone);
        boolean flag = matcher.matches();
        if (!flag){
            System.out.println("Nhập sai" + numberPhone + "Mời bạn nhập lại (840123456789)");
        }
        return flag;
    }
    public static boolean IsLoaiKhach(String loaiKhach){
        pattern = Pattern.compile(TEN_LOAI_KHACH);
        matcher = pattern.matcher(loaiKhach);
        boolean flag = matcher.matches();
        if (!flag){
            System.out.println("Nhập sai" + loaiKhach + "Mời bạn nhập lại Abc ");
        }
        return flag;
    }
    public static boolean IsDichVuDiKem(String dichVuDiKem){
        pattern = Pattern.compile(DICH_VU_DI_KEM);
        matcher = pattern.matcher(dichVuDiKem);
        boolean flag = matcher.matches();
        if (!flag){
            System.out.println("Nhập sai " + dichVuDiKem + "Mời nhập Massage , Karaoke ,Food ,Water ,Car rental");
        }
        return flag;
    }
}
