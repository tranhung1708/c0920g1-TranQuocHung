package Test3;

public class HocSinh implements Comparable<HocSinh>{
    protected int idHocSinh;
    protected String tenHocSinh;
    protected String lopHoc;
    protected String diaChi;
    protected String ngaySinh;
    protected String soDienThoai;
    protected String gioiTinh;
    protected String gmail;

    public HocSinh() {
    }

    public HocSinh(int idHocSinh, String tenHocSinh, String lopHoc, String diaChi, String ngaySinh, String soDienThoai, String gioiTinh, String gmail) {
        this.idHocSinh = idHocSinh;
        this.tenHocSinh = tenHocSinh;
        this.lopHoc = lopHoc;
        this.diaChi = diaChi;
        this.ngaySinh = ngaySinh;
        this.soDienThoai = soDienThoai;
        this.gioiTinh = gioiTinh;
        this.gmail = gmail;
    }

    public int getIdHocSinh() {
        return idHocSinh;
    }

    public void setIdHocSinh(int idHocSinh) {
        this.idHocSinh = idHocSinh;
    }

    public String getTenHocSinh() {
        return tenHocSinh;
    }

    public void setTenHocSinh(String tenHocSinh) {
        this.tenHocSinh = tenHocSinh;
    }

    public String getLopHoc() {
        return lopHoc;
    }

    public void setLopHoc(String lopHoc) {
        this.lopHoc = lopHoc;
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

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    @Override
    public String   toString() {
        return "HocSinh{" +
                "idHocSinh=" + idHocSinh +
                ", tenHocSinh='" + tenHocSinh + '\'' +
                ", lopHoc='" + lopHoc + '\'' +
                ", diaChi='" + diaChi + '\'' +
                ", ngaySinh='" + ngaySinh + '\'' +
                ", soDienThoai='" + soDienThoai + '\'' +
                ", gioiTinh='" + gioiTinh + '\'' +
                ", gmail='" + gmail + '\'' +
                '}';
    }

    @Override
    public int compareTo(HocSinh o) {
        return this.getTenHocSinh().compareTo(o.getTenHocSinh());
    }
}
