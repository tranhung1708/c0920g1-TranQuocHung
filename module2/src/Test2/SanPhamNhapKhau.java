package Test2;

public class SanPhamNhapKhau extends SanPham{
    protected String giaNhapKhau;
    protected String tinhThanhNhap;
    protected String thueNhapKkhau;

    public SanPhamNhapKhau() {
    }

    @Override
    public void show() {
        System.out.println(this.toString());
    }

    public SanPhamNhapKhau(String giaNhapKhau, String tinhThanhNhap, String thueNhapKkhau) {
        this.giaNhapKhau = giaNhapKhau;
        this.tinhThanhNhap = tinhThanhNhap;
        this.thueNhapKkhau = thueNhapKkhau;
    }

    public SanPhamNhapKhau(String idSanPham, String maSanPham, String tenSanPham, String giaBan, String soLuong, String nhaSanXuat, String giaNhapKhau, String tinhThanhNhap, String thueNhapKkhau) {
        super(idSanPham, maSanPham, tenSanPham, giaBan, soLuong, nhaSanXuat);
        this.giaNhapKhau = giaNhapKhau;
        this.tinhThanhNhap = tinhThanhNhap;
        this.thueNhapKkhau = thueNhapKkhau;
    }

    public String getGiaNhapKhau() {
        return giaNhapKhau;
    }

    public void setGiaNhapKhau(String giaNhapKhau) {
        this.giaNhapKhau = giaNhapKhau;
    }

    public String getTinhThanhNhap() {
        return tinhThanhNhap;
    }

    public void setTinhThanhNhap(String tinhThanhNhap) {
        this.tinhThanhNhap = tinhThanhNhap;
    }

    public String getThueNhapKkhau() {
        return thueNhapKkhau;
    }

    public void setThueNhapKkhau(String thueNhapKkhau) {
        this.thueNhapKkhau = thueNhapKkhau;
    }

    @Override
    public String toString() {
        return "SanPhamNhapKhau1.csv{" +
                "giaNhapKhau='" + giaNhapKhau + '\'' +
                ", tinhThanhNhap='" + tinhThanhNhap + '\'' +
                ", thueNhapKkhau='" + thueNhapKkhau + '\'' +
                ", idSanPham='" + idSanPham + '\'' +
                ", maSanPham='" + maSanPham + '\'' +
                ", tenSanPham='" + tenSanPham + '\'' +
                ", giaBan='" + giaBan + '\'' +
                ", soLuong='" + soLuong + '\'' +
                ", nhaSanXuat='" + nhaSanXuat + '\'' +
                '}';
    }
}
