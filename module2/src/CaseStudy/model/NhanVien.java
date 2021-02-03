package CaseStudy.model;

public class NhanVien {
    private String maNhanVien ;
    private String tenNhanVien;
    private String boPhanLamViec;
    private String soDienThoai;
    private String diaChi;

    public NhanVien() {
    }

    public NhanVien(String maNhanVien, String tenNhanVien, String boPhanLamViec, String soDienThoai, String diaChi) {
        this.maNhanVien = maNhanVien;
        this.tenNhanVien = tenNhanVien;
        this.boPhanLamViec = boPhanLamViec;
        this.soDienThoai = soDienThoai;
        this.diaChi = diaChi;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getTenNhanVien() {
        return tenNhanVien;
    }

    public void setTenNhanVien(String tenNhanVien) {
        this.tenNhanVien = tenNhanVien;
    }

    public String getBoPhanLamViec() {
        return boPhanLamViec;
    }

    public void setBoPhanLamViec(String boPhanLamViec) {
        this.boPhanLamViec = boPhanLamViec;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    @Override
    public String toString() {
        return "NhanVien{" +
                "maNhanVien='" + maNhanVien + '\'' +
                ", tenNhanVien='" + tenNhanVien + '\'' +
                ", boPhanLamViec='" + boPhanLamViec + '\'' +
                ", soDienThoai='" + soDienThoai + '\'' +
                ", diaChi='" + diaChi + '\'' +
                '}';
    }
}
