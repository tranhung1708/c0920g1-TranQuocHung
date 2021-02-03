package vn.codegym.model;

import javax.persistence.*;
import java.util.List;

@Entity(name = "nguoiHoi")
public class NguoiHoi {
    @Id
    private int idNguoiHoi;
    private String tenNguoiHoi;

    @OneToMany(mappedBy = "nguoiHoi")
    private List<CauHoi> cauHois;


    public NguoiHoi() {
    }

    public int getIdNguoiHoi() {
        return idNguoiHoi;
    }

    public void setIdNguoiHoi(int idNguoiHoi) {
        this.idNguoiHoi = idNguoiHoi;
    }

    public String getTenNguoiHoi() {
        return tenNguoiHoi;
    }

    public void setTenNguoiHoi(String tenNguoiHoi) {
        this.tenNguoiHoi = tenNguoiHoi;
    }


    public List<CauHoi> getCauHois() {
        return cauHois;
    }

    public void setCauHois(List<CauHoi> cauHois) {
        this.cauHois = cauHois;
    }
}
