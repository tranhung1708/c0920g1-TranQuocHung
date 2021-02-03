package CaseStudy.model;

public class House extends Service implements Comparable<House> {
    protected String tieuChuanPhong;
    protected String moTaTienNghiKhac;
    protected String soTang;

    @Override
    public void showInformation() {
        System.out.println(this.toString());
    }

    public House() {
    }

    public House(String tieuChuanPhong, String moTaTienNghiKhac, String soTang) {
        this.tieuChuanPhong = tieuChuanPhong;
        this.moTaTienNghiKhac = moTaTienNghiKhac;
        this.soTang = soTang;
    }

    public House(String id, String tenDichVu, String dienTichSuDung, String chiPhiThue, String soLuongNguoiToiDa, String kieuThue, String tieuChuanPhong, String moTaTienNghiKhac, String soTang) {
        super(id, tenDichVu, dienTichSuDung, chiPhiThue, soLuongNguoiToiDa, kieuThue);
        this.tieuChuanPhong = tieuChuanPhong;
        this.moTaTienNghiKhac = moTaTienNghiKhac;
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

    public String getSoTang() {
        return soTang;
    }

    public void setSoTang(String soTang) {
        this.soTang = soTang;
    }

    @Override
    public String toString() {
        return "House{" +
                "Tiêu chuẩn phòng : '" + tieuChuanPhong + '\'' +
                ", Tiện nghi khác :'" + moTaTienNghiKhac + '\'' +
                ", Số tầng=" + soTang +
                ", Id :'" + id + '\'' +
                ", Tên dịch vụ : '" + tenDichVu + '\'' +
                ", Diện tích sử dụng :" + dienTichSuDung +
                ", Chi phí thuê : " + chiPhiThue +
                ", Số lượng người tối đa : " + soLuongNguoiToiDa +
                ", Kiểu thuê : '" + kieuThue + '\'' +
                '}';
    }

    @Override
    public int compareTo(House o) {
        return this.getTieuChuanPhong().compareTo(o.getTieuChuanPhong());
    }
}
