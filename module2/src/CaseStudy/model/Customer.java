package CaseStudy.model;

import java.util.Comparator;

public class Customer {
    protected String hoTen;
    protected String ngaySinh;
    protected String gioiTinh;
    protected String cmnd;
    protected String soDienThoai;
    protected String email;
    protected String loaiKhach;
    protected String diaChi;

    public Customer() {
    }

    public Customer(String hoTen, String ngaySinh, String gioiTinh, String cmnd, String soDienThoai, String email, String loaiKhach, String diaChi) {
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.cmnd = cmnd;
        this.soDienThoai = soDienThoai;
        this.email = email;
        this.loaiKhach = loaiKhach;
        this.diaChi = diaChi;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLoaiKhach() {
        return loaiKhach;
    }

    public void setLoaiKhach(String loaiKhach) {
        this.loaiKhach = loaiKhach;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }


    @Override
    public String toString() {
        return "Customer{" +
                "Họ Tên :'" + hoTen + '\'' +
                ", Ngày Sinh :'" + ngaySinh + '\'' +
                ", Giới Tính :'" + gioiTinh + '\'' +
                ", Chứng Minh Nhân Dân :'" + cmnd + '\'' +
                ", Số Điện Thoại :" + soDienThoai +
                ", Email :'" + email + '\'' +
                ", Loại Khách :'" + loaiKhach + '\'' +
                ", Địa Chỉ :'" + diaChi + '\'' +
                '}';
    }
}
