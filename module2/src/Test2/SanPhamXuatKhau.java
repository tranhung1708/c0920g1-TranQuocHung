package Test2;

public class SanPhamXuatKhau extends SanPham{
    protected String giaXuatKhau;
    protected String quocGiaNhapSanPham;

    public SanPhamXuatKhau() {
    }

    @Override
    public void show() {
        System.out.println(this.toString());
    }

    public SanPhamXuatKhau(String giaXuatKhau, String quocGiaNhapSanPham) {
        this.giaXuatKhau = giaXuatKhau;
        this.quocGiaNhapSanPham = quocGiaNhapSanPham;
    }

    public SanPhamXuatKhau(String idSanPham, String maSanPham, String tenSanPham, String giaBan, String soLuong, String nhaSanXuat, String giaXuatKhau, String quocGiaNhapSanPham) {
        super(idSanPham, maSanPham, tenSanPham, giaBan, soLuong, nhaSanXuat);
        this.giaXuatKhau = giaXuatKhau;
        this.quocGiaNhapSanPham = quocGiaNhapSanPham;
    }

    public String getGiaXuatKhau() {
        return giaXuatKhau;
    }

    public void setGiaXuatKhau(String giaXuatKhau) {
        this.giaXuatKhau = giaXuatKhau;
    }

    public String getQuocGiaNhapSanPham() {
        return quocGiaNhapSanPham;
    }

    public void setQuocGiaNhapSanPham(String quocGiaNhapSanPham) {
        this.quocGiaNhapSanPham = quocGiaNhapSanPham;
    }

    @Override
    public String toString() {
        return "SanPhamXuatKhau{" +
                "giaXuatKhau='" + giaXuatKhau + '\'' +
                ", quocGiaNhapSanPham='" + quocGiaNhapSanPham + '\'' +
                ", idSanPham='" + idSanPham + '\'' +
                ", maSanPham='" + maSanPham + '\'' +
                ", tenSanPham='" + tenSanPham + '\'' +
                ", giaBan='" + giaBan + '\'' +
                ", soLuong='" + soLuong + '\'' +
                ", nhaSanXuat='" + nhaSanXuat + '\'' +
                '}';
    }
}
