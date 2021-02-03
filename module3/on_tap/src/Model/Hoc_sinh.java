package Model;

public class Hoc_sinh {
    int ma_hoc_sinh;
    String ten_hoc_sinh;
    int lop;
    String ngay_sinh;
    String dia_chi;

    public Hoc_sinh() {
    }

    public Hoc_sinh(int ma_hoc_sinh, String ten_hoc_sinh, int lop, String ngay_sinh, String dia_chi) {
        this.ma_hoc_sinh = ma_hoc_sinh;
        this.ten_hoc_sinh = ten_hoc_sinh;
        this.lop = lop;
        this.ngay_sinh = ngay_sinh;
        this.dia_chi = dia_chi;
    }

    public int getMa_hoc_sinh() {
        return ma_hoc_sinh;
    }

    public void setMa_hoc_sinh(int ma_hoc_sinh) {
        this.ma_hoc_sinh = ma_hoc_sinh;
    }

    public String getTen_hoc_sinh() {
        return ten_hoc_sinh;
    }

    public void setTen_hoc_sinh(String ten_hoc_sinh) {
        this.ten_hoc_sinh = ten_hoc_sinh;
    }

    public int getLop() {
        return lop;
    }

    public void setLop(int lop) {
        this.lop = lop;
    }

    public String getNgay_sinh() {
        return ngay_sinh;
    }

    public void setNgay_sinh(String ngay_sinh) {
        this.ngay_sinh = ngay_sinh;
    }

    public String getDia_chi() {
        return dia_chi;
    }

    public void setDia_chi(String dia_chi) {
        this.dia_chi = dia_chi;
    }
}
