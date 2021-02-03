package Model;

public class Benh_an {
String ma_benh_an;
String ma_benh_nhan;
String ngay_nhap_vien;
String ngay_ra_vien;
String ly_do_nhap_vien;

    public Benh_an() {
    }

    public Benh_an(String ma_benh_an, String ma_benh_nhan, String ngay_nhap_vien, String ngay_ra_vien, String ly_do_nhap_vien) {
        this.ma_benh_an = ma_benh_an;
        this.ma_benh_nhan = ma_benh_nhan;
        this.ngay_nhap_vien = ngay_nhap_vien;
        this.ngay_ra_vien = ngay_ra_vien;
        this.ly_do_nhap_vien = ly_do_nhap_vien;
    }

    public String getMa_benh_an() {
        return ma_benh_an;
    }

    public void setMa_benh_an(String ma_benh_an) {
        this.ma_benh_an = ma_benh_an;
    }

    public String getMa_benh_nhan() {
        return ma_benh_nhan;
    }

    public void setMa_benh_nhan(String ma_benh_nhan) {
        this.ma_benh_nhan = ma_benh_nhan;
    }

    public String getNgay_nhap_vien() {
        return ngay_nhap_vien;
    }

    public void setNgay_nhap_vien(String ngay_nhap_vien) {
        this.ngay_nhap_vien = ngay_nhap_vien;
    }

    public String getNgay_ra_vien() {
        return ngay_ra_vien;
    }

    public void setNgay_ra_vien(String ngay_ra_vien) {
        this.ngay_ra_vien = ngay_ra_vien;
    }

    public String getLy_do_nhap_vien() {
        return ly_do_nhap_vien;
    }

    public void setLy_do_nhap_vien(String ly_do_nhap_vien) {
        this.ly_do_nhap_vien = ly_do_nhap_vien;
    }
}
