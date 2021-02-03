package CaseStudy.model;

import java.time.LocalTime;
import java.util.Date;

public abstract class Service {
    protected String id;
    protected String tenDichVu;
    protected String dienTichSuDung;
    protected String chiPhiThue;
    protected String soLuongNguoiToiDa;
    protected String kieuThue;
    public abstract void showInformation();
    public Service() {
    }

    public Service(String id, String tenDichVu, String dienTichSuDung, String chiPhiThue, String soLuongNguoiToiDa, String kieuThue) {
        this.id = id;
        this.tenDichVu = tenDichVu;
        this.dienTichSuDung = dienTichSuDung;
        this.chiPhiThue = chiPhiThue;
        this.soLuongNguoiToiDa = soLuongNguoiToiDa;
        this.kieuThue = kieuThue;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTenDichVu() {
        return tenDichVu;
    }

    public void setTenDichVu(String tenDichVu) {
        this.tenDichVu = tenDichVu;
    }

    public String getDienTichSuDung() {
        return dienTichSuDung;
    }

    public void setDienTichSuDung(String dienTichSuDung) {
        this.dienTichSuDung = dienTichSuDung;
    }

    public String getChiPhiThue() {
        return chiPhiThue;
    }

    public void setChiPhiThue(String chiPhiThue) {
        this.chiPhiThue = chiPhiThue;
    }

    public String getSoLuongNguoiToiDa() {
        return soLuongNguoiToiDa;
    }

    public void setSoLuongNguoiToiDa(String soLuongNguoiToiDa) {
        this.soLuongNguoiToiDa = soLuongNguoiToiDa;
    }

    public String getKieuThue() {
        return kieuThue;
    }

    public void setKieuThue(String kieuThue) {
        this.kieuThue = kieuThue;
    }

    @Override
    public String toString() {
        return "Service{" +
                "Id : '" + id + '\'' +
                ", Tên dịch vụ : '" + tenDichVu + '\'' +
                ", Diện tích sử dụng : " + dienTichSuDung +
                ", Chi phí thuê : " + chiPhiThue +
                ", Số lượng người tối đa : " + soLuongNguoiToiDa +
                ", Kiểu thuê : '" + kieuThue + '\'' +
                '}';
    }

}
