package CaseStudy.model;

public class Villa extends Service implements Comparable<Villa> {
    protected String tieuChuanPhong;
    protected String moTaTienNghiKhac;
    protected String dienTichHoBoi;
    protected String soTang;

    @Override
    public void showInformation() {
        System.out.println(this.toString());
    }

    public Villa() {
    }

    public Villa(String tieuChuanPhong, String moTaTienNghiKhac, String dienTichHoBoi, String soTang) {
        this.tieuChuanPhong = tieuChuanPhong;
        this.moTaTienNghiKhac = moTaTienNghiKhac;
        this.dienTichHoBoi = dienTichHoBoi;
        this.soTang = soTang;
    }

    public Villa(String id, String tenDichVu, String dienTichSuDung, String chiPhiThue, String soLuongNguoiToiDa, String kieuThue, String tieuChuanPhong, String moTaTienNghiKhac, String dienTichHoBoi, String soTang) {
        super(id, tenDichVu, dienTichSuDung, chiPhiThue, soLuongNguoiToiDa, kieuThue);
        this.tieuChuanPhong = tieuChuanPhong;
        this.moTaTienNghiKhac = moTaTienNghiKhac;
        this.dienTichHoBoi = dienTichHoBoi;
        this.soTang = soTang;
    }

    public String getTieuChuanPhong() {
        return tieuChuanPhong;
    }

    public void setTieuChuanPhong(String tieuChuanPhong) {
        this.tieuChuanPhong = tieuChuanPhong;
    }

    public String getMoTaTienNghiKhac() {
        return moTaTienNghiKhac;
    }

    public void setMoTaTienNghiKhac(String moTaTienNghiKhac) {
        this.moTaTienNghiKhac = moTaTienNghiKhac;
    }

    public String getDienTichHoBoi() {
        return dienTichHoBoi;
    }

    public void setDienTichHoBoi(String dienTichHoBoi) {
        this.dienTichHoBoi = dienTichHoBoi;
    }

    public String getSoTang() {
        return soTang;
    }

    public void setSoTang(String soTang) {
        this.soTang = soTang;
    }

    @Override
    public String toString() {
        return "Villa{" +
                "Tiêu chuẩn phòng :'" + tieuChuanPhong + '\'' +
                ", Tiện nghi khác :'" + moTaTienNghiKhac + '\'' +
                ", Diện tích hồ bơi : " + dienTichHoBoi +
                ", Số tầng : " + soTang +
                ", Id :'" + id + '\'' +
                ", Dịch vụ : '" + tenDichVu + '\'' +
                ", Diện tích sử dụng : " + dienTichSuDung +
                ", Chi phí thuê : " + chiPhiThue +
                ", Số lượng người tối đa : " + soLuongNguoiToiDa +
                ", Kiểu thuê : '" + kieuThue + '\'' +
                '}';
    }

    @Override
    public int compareTo(Villa o) {
        return this.getTenDichVu().compareTo(o.getTenDichVu());
    }
}
