package Thi.model;

public class SoTietKiemVoThoiHan extends SoTietKiemNganHan {
    @Override
    public void show() {
        System.out.println(this.toString());
    }
    private String maSoSo;
    private String maKhachHang;
    private String ngayMoSo;
    private String thoiGianGui;
    private String soTienGui;
    private String laiSuat;

    public SoTietKiemVoThoiHan() {
    }

    public SoTietKiemVoThoiHan(String maSoSo, String maKhachHang, String ngayMoSo,
                               String thoiGianGui, String soTienGui, String laiSuat) {
        this.maSoSo = maSoSo;
        this.maKhachHang = maKhachHang;
        this.ngayMoSo = ngayMoSo;
        this.thoiGianGui = thoiGianGui;
        this.soTienGui = soTienGui;
        this.laiSuat = laiSuat;
    }

    public String getMaSoSo() {
        return maSoSo;
    }

    public void setMaSoSo(String maSoSo) {
        this.maSoSo = maSoSo;
    }

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public String getNgayMoSo() {
        return ngayMoSo;
    }

    public void setNgayMoSo(String ngayMoSo) {
        this.ngayMoSo = ngayMoSo;
    }

    public String getThoiGianGui() {
        return thoiGianGui;
    }

    public void setThoiGianGui(String thoiGianGui) {
        this.thoiGianGui = thoiGianGui;
    }

    public String getSoTienGui() {
        return soTienGui;
    }

    public void setSoTienGui(String soTienGui) {
        this.soTienGui = soTienGui;
    }

    public String getLaiSuat() {
        return laiSuat;
    }

    public void setLaiSuat(String laiSuat) {
        this.laiSuat = laiSuat;
    }

    @Override
    public String toString() {
        return "SoTietKiemVoThoiHan{" +
                "maSoSo='" + maSoSo + '\'' +
                ", maKhachHang='" + maKhachHang + '\'' +
                ", ngayMoSo='" + ngayMoSo + '\'' +
                ", thoiGianGui='" + thoiGianGui + '\'' +
                ", soTienGui='" + soTienGui + '\'' +
                ", laiSuat='" + laiSuat + '\'' +
                '}';
    }
}
