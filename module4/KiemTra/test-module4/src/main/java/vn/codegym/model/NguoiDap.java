package vn.codegym.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class NguoiDap {
    @Id
    private int idNguoiDap;
    private String tenNguoiDap;

    @OneToMany(mappedBy = "nguoiDap")
    private List<CauHoi> cauHois;

    public int getIdNguoiDap() {
        return idNguoiDap;
    }

    public void setIdNguoiDap(int idNguoiDap) {
        this.idNguoiDap = idNguoiDap;
    }

    public String getTenNguoiDap() {
        return tenNguoiDap;
    }

    public void setTenNguoiDap(String tenNguoiDap) {
        this.tenNguoiDap = tenNguoiDap;
    }

    public List<CauHoi> getCauHois() {
        return cauHois;
    }

    public void setCauHois(List<CauHoi> cauHois) {
        this.cauHois = cauHois;
    }
}
