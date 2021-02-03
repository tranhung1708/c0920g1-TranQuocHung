package vn.codegym.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity(name = "cauHoi")
public class CauHoi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCauHoi;
    @NotBlank(message = "Không được bỏ trống")
    @Size(min = 5 , max = 100 , message = "Trên 5 kí tự và dưới 100 ký tự")
    private String tieuDe;
    @NotBlank(message = "Không được bỏ trống")
    private String loaiCauHoi;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Past
    private Date ngayDang;
    private String tinhTrang;

    @ManyToOne
    @JoinColumn(name = "id_nguoi_hoi", nullable = false)
    private NguoiHoi nguoiHoi;

    public NguoiDap getNguoiDap() {
        return nguoiDap;
    }

    public void setNguoiDap(NguoiDap nguoiDap) {
        this.nguoiDap = nguoiDap;
    }

    @ManyToOne
    @JoinColumn(name = "id_nguoi_dap", nullable = false)
    private NguoiDap nguoiDap;

    public CauHoi() {
    }

    public int getIdCauHoi() {
        return idCauHoi;
    }

    public void setIdCauHoi(int idCauHoi) {
        this.idCauHoi = idCauHoi;
    }

    public String getTieuDe() {
        return tieuDe;
    }

    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }

    public String getLoaiCauHoi() {
        return loaiCauHoi;
    }

    public void setLoaiCauHoi(String loaiCauHoi) {
        this.loaiCauHoi = loaiCauHoi;
    }

    public Date getNgayDang() {
        return ngayDang;
    }

    public void setNgayDang(Date ngayDang) {
        this.ngayDang = ngayDang;
    }

    public String getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public NguoiHoi getNguoiHoi() {
        return nguoiHoi;
    }

    public void setNguoiHoi(NguoiHoi nguoiHoi) {
        this.nguoiHoi = nguoiHoi;
    }
}
