package vn.codegym.model;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import java.util.Date;
import java.util.List;

@Entity(name = "giaoDich")
public class GiaoDich {
    @Id
    @GeneratedValue(generator = "my_generator")
    @GenericGenerator(name = "my_generator", strategy = "vn.codegym.common.MyGenerator")
    private String idGiaoDich;
    private String tenGiaoDich;
    private String loaiGiaoDich;
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date ngayGiaoDich;
    @Min(value = 1, message = "Đơn giá phải lớn hơn 0")
    private int donGia;
    @ManyToOne
    @JoinColumn(name = "ma_khach_hang" , nullable = false)
    private KhachHang khachHang;

    public GiaoDich() {
    }

    public String getIdGiaoDich() {
        return idGiaoDich;
    }

    public void setIdGiaoDich(String idGiaoDich) {
        this.idGiaoDich = idGiaoDich;
    }

    public String getTenGiaoDich() {
        return tenGiaoDich;
    }

    public void setTenGiaoDich(String tenGiaoDich) {
        this.tenGiaoDich = tenGiaoDich;
    }

    public String getLoaiGiaoDich() {
        return loaiGiaoDich;
    }

    public void setLoaiGiaoDich(String loaiGiaoDich) {
        this.loaiGiaoDich = loaiGiaoDich;
    }

    public Date getNgayGiaoDich() {
        return ngayGiaoDich;
    }

    public void setNgayGiaoDich(Date ngayGiaoDich) {
        this.ngayGiaoDich = ngayGiaoDich;
    }

    public int getDonGia() {
        return donGia;
    }

    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }
}
