package CaseStudy.model;

public class Room extends Service implements Comparable<Room> {
    protected String tenDichVuDiKem;
    protected String donVi;
    protected String giaTien;

    @Override
    public void showInformation() {
        System.out.println(this.toString());
    }

    public Room(String tenDichVuDiKem, String donVi, String giaTien) {
        this.tenDichVuDiKem = tenDichVuDiKem;
        this.donVi = donVi;
        this.giaTien = giaTien;
    }

    public Room(String id, String tenDichVu, String dienTichSuDung, String chiPhiThue, String soLuongNguoiToiDa, String kieuThue, String tenDichVuDiKem, String donVi, String giaTien) {
        super(id, tenDichVu, dienTichSuDung, chiPhiThue, soLuongNguoiToiDa, kieuThue);
        this.tenDichVuDiKem = tenDichVuDiKem;
        this.donVi = donVi;
        this.giaTien = giaTien;
    }

    public String getTenDichVuDiKem() {
        return tenDichVuDiKem;
    }

    public void setTenDichVuDiKem(String tenDichVuDiKem) {
        this.tenDichVuDiKem = tenDichVuDiKem;
    }

    public String getDonVi() {
        return donVi;
    }

    public void setDonVi(String donVi) {
        this.donVi = donVi;
    }

    public String getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(String giaTien) {
        this.giaTien = giaTien;
    }

    @Override
    public String toString() {
        return "Room{" +
                "tenDichVuDiKem='" + tenDichVuDiKem + '\'' +
                ", donVi='" + donVi + '\'' +
                ", giaTien='" + giaTien + '\'' +
                ", id='" + id + '\'' +
                ", tenDichVu='" + tenDichVu + '\'' +
                ", dienTichSuDung='" + dienTichSuDung + '\'' +
                ", chiPhiThue='" + chiPhiThue + '\'' +
                ", soLuongNguoiToiDa='" + soLuongNguoiToiDa + '\'' +
                ", kieuThue='" + kieuThue + '\'' +
                '}';
    }

    @Override
    public int compareTo(Room o) {
        return this.getTenDichVuDiKem().compareTo(o.getTenDichVuDiKem());
    }
}
