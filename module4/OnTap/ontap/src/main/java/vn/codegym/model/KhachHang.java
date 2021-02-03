package vn.codegym.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class KhachHang {
    @Id
    private String maKhachHang;
    private String tenKhachHang;

    @OneToMany(mappedBy = "khachHang")
    private List<GiaoDich> giaoDich;

    public KhachHang() {
    }

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public List<GiaoDich> getGiaoDich() {
        return giaoDich;
    }

    public void setGiaoDich(List<GiaoDich> giaoDich) {
        this.giaoDich = giaoDich;
    }
}
