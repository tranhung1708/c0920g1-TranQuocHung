package Thi.model;

public class SoTietKiemCoThoiHan extends SoTietKiemNganHan{

    @Override
    public void show() {
        System.out.println(this.toString());
    }
    private String maSoSo;
    private String maKhachHang;
    private String ngayMoSo;
    private String thoiGianBatDauGui;
    private String kiHan;
    private String soTienGui;
    private String laiSuat;

    public SoTietKiemCoThoiHan() {
    }

    public SoTietKiemCoThoiHan(String maSoSo, String maKhachHang, String ngayMoSo,
                               String thoiGianBatDauGui, String kiHan,
                               String soTienGui, String laiSuat) {
        this.maSoSo = maSoSo;
        this.maKhachHang = maKhachHang;
        this.ngayMoSo = ngayMoSo;
        this.thoiGianBatDauGui = thoiGianBatDauGui;
        this.kiHan = kiHan;
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

    public String getThoiGianBatDauGui() {
        return thoiGianBatDauGui;
    }

    public void setThoiGianBatDauGui(String thoiGianBatDauGui) {
        this.thoiGianBatDauGui = thoiGianBatDauGui;
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

    public String getLaiSuat() {
        return laiSuat;
    }

    public void setLaiSuat(String laiSuat) {
        this.laiSuat = laiSuat;
    }

    @Override
    public String toString() {
        return "SoTietKiemCoThoiHan{" +
                "maSoSo='" + maSoSo + '\'' +
                ", maKhachHang='" + maKhachHang + '\'' +
                ", ngayMoSo='" + ngayMoSo + '\'' +
                ", thoiGianBatDauGui='" + thoiGianBatDauGui + '\'' +
                ", kiHan='" + kiHan + '\'' +
                ", soTienGui='" + soTienGui + '\'' +
                ", laiSuat='" + laiSuat + '\'' +
                '}';
    }
}
