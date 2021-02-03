package session_16.BaiTap;

import javax.swing.*;
import java.io.Serializable;

public class Product implements Serializable {
    private String maSanPham;
    private String tenSanPham;
    private String hangSanXuat;
    private String gia;
    private String cacMoTaKhac;

    public Product() {
    }

    public Product(String maSanPham, String tenSanPham, String hangSanXuat, String gia, String cacMoTaKhac) {
        this.maSanPham = maSanPham;
        this.tenSanPham = tenSanPham;
        this.hangSanXuat = hangSanXuat;
        this.gia = gia;
        this.cacMoTaKhac = cacMoTaKhac;
    }

    public String getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(String maSanPham) {
        this.maSanPham = maSanPham;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public String getHangSanXuat() {
        return hangSanXuat;
    }

    public void setHangSanXuat(String hangSanXuat) {
        this.hangSanXuat = hangSanXuat;
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }

    public String getCacMoTaKhac() {
        return cacMoTaKhac;
    }

    public void setCacMoTaKhac(String cacMoTaKhac) {
        this.cacMoTaKhac = cacMoTaKhac;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "maSanPham='" + maSanPham + '\'' +
                ", tenSanPham='" + tenSanPham + '\'' +
                ", hangSanXuat='" + hangSanXuat + '\'' +
                ", gia='" + gia + '\'' +
                ", cacMoTaKhac='" + cacMoTaKhac + '\'' +
                '}';
    }
}
