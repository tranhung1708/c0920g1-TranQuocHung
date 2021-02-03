package CaseStudy.model;

public class VeXemPhim {
    protected String hoTen;
    protected String tuoi;
    protected String soGhe;
    protected String giaVe;

    public VeXemPhim() {
    }

    public VeXemPhim(String hoTen, String tuoi, String soGhe, String giaVe) {
        this.hoTen = hoTen;
        this.tuoi = tuoi;
        this.soGhe = soGhe;
        this.giaVe = giaVe;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getTuoi() {
        return tuoi;
    }

    public void setTuoi(String tuoi) {
        this.tuoi = tuoi;
    }

    public String getSoGhe() {
        return soGhe;
    }

    public void setSoGhe(String soGhe) {
        this.soGhe = soGhe;
    }

    public String getGiaVe() {
        return giaVe;
    }

    public void setGiaVe(String giaVe) {
        this.giaVe = giaVe;
    }

    @Override
    public String toString() {
        return "Vé xem phim{" +
                "Họ Tên Khách Hàng='" + hoTen + '\'' +
                ", Tuổi='" + tuoi + '\'' +
                ", Số Ghế='" + soGhe + '\'' +
                ", Giá Vé='" + giaVe + '\'' +
                '}';
    }
}
