package Test;

public class Product {
    private String ten;
    private String loaiHang;
    private String hangNk;
    private String hangXk;

    public Product() {
    }

    public Product(String ten, String loaiHang, String hangNk, String hangXk) {
        this.ten = ten;
        this.loaiHang = loaiHang;
        this.hangNk = hangNk;
        this.hangXk = hangXk;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getLoaiHang() {
        return loaiHang;
    }

    public void setLoaiHang(String loaiHang) {
        this.loaiHang = loaiHang;
    }

    public String getHangNk() {
        return hangNk;
    }

    public void setHangNk(String hangNk) {
        this.hangNk = hangNk;
    }

    public String getHangXk() {
        return hangXk;
    }

    public void setHangXk(String hangXk) {
        this.hangXk = hangXk;
    }

    @Override
    public String toString() {
        return "Product{" +
                "ten='" + ten + '\'' +
                ", loaiHang='" + loaiHang + '\'' +
                ", hangNk='" + hangNk + '\'' +
                ", hangXk='" + hangXk + '\'' +
                '}';
    }
}
