package Thi.model;

public class SoTietKiemDaiHan {
    private  String maSoSo;
    private String maKhachHang;
    private String ngayMoSo;
    private String thoiGianKiGui;
    private String kiHan;
    private String soTienGui;
    private String laiXuat;
    private String uuDai;

    public SoTietKiemDaiHan() {
    }

    public SoTietKiemDaiHan(String maSoSo, String maKhachHang, String ngayMoSo, String thoiGianKiGui,
                            String kiHan, String soTienGui, String laiXuat, String uuDai) {
        this.maSoSo = maSoSo;
        this.maKhachHang = maKhachHang;
        this.ngayMoSo = ngayMoSo;
        this.thoiGianKiGui = thoiGianKiGui;
        this.kiHan = kiHan;
        this.soTienGui = soTienGui;
        this.laiXuat = laiXuat;
        this.uuDai = uuDai;
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

    public String getThoiGianKiGui() {
        return thoiGianKiGui;
    }

    public void setThoiGianKiGui(String thoiGianKiGui) {
        this.thoiGianKiGui = thoiGianKiGui;
    }

    public String getKiHan() {
        return kiHan;
    }

    public void setKiHan(String kiHan) {
        this.kiHan = kiHan;
    }

    public String getSoTienGui() {
        return soTienGui;
    }

    public void setSoTienGui(String soTienGui) {
        this.soTienGui = soTienGui;
    }

    public String getLaiXuat() {
        return laiXuat;
    }

    public void setLaiXuat(String laiXuat) {
        this.laiXuat = laiXuat;
    }

    public String getUuDai() {
        return uuDai;
    }

    public void setUuDai(String uuDai) {
        this.uuDai = uuDai;
    }

    @Override
    public String toString() {
        return "SoTietKiemDaiHan{" +
                "maSoSo='" + maSoSo + '\'' +
                ", maKhachHang='" + maKhachHang + '\'' +
                ", ngayMoSo='" + ngayMoSo + '\'' +
                ", thoiGianKiGui='" + thoiGianKiGui + '\'' +
                ", kiHan='" + kiHan + '\'' +
                ", soTienGui='" + soTienGui + '\'' +
                ", laiXuat='" + laiXuat + '\'' +
                ", uuDai='" + uuDai + '\'' +
                '}';
    }
}
