package Test3;

public class GiaoVien implements Comparable<GiaoVien>{
    protected int maGiaoVien;
    protected String tenGiaoVien;
    protected String lopChuNhiem;
    protected String diaChi;
    protected String ngaySinh;

    public GiaoVien() {
    }

    public GiaoVien(int maGiaoVien, String tenGiaoVien, String lopChuNhiem, String diaChi, String ngaySinh) {
        this.maGiaoVien = maGiaoVien;
        this.tenGiaoVien = tenGiaoVien;
        this.lopChuNhiem = lopChuNhiem;
        this.diaChi = diaChi;
        this.ngaySinh = ngaySinh;
    }

    public int getMaGiaoVien() {
        return maGiaoVien;
    }

    public void setMaGiaoVien(int maGiaoVien) {
        this.maGiaoVien = maGiaoVien;
    }

    public String getTenGiaoVien() {
        return tenGiaoVien;
    }

    public void setTenGiaoVien(String tenGiaoVien) {
        this.tenGiaoVien = tenGiaoVien;
    }

    public String getLopChuNhiem() {
        return lopChuNhiem;
    }

    public void setLopChuNhiem(String lopChuNhiem) {
        this.lopChuNhiem = lopChuNhiem;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    @Override
    public String toString() {
        return "GiaoVien{" +
                "maGiaoVien=" + maGiaoVien +
                ", tenGiaoVien='" + tenGiaoVien + '\'' +
                ", lopChuNhiem='" + lopChuNhiem + '\'' +
                ", diaChi='" + diaChi + '\'' +
                ", ngaySinh='" + ngaySinh + '\'' +
                '}';
    }

    @Override
    public int compareTo(GiaoVien o) {
        return this.getTenGiaoVien().compareTo(o.getTenGiaoVien());
    }
}
