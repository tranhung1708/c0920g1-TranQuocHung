package Model;

public class Benh_nhan {
    int ma_benh_nhan;
    String ten_benh_nhan;

    public Benh_nhan() {
    }

    public Benh_nhan(int ma_benh_nhan, String ten_benh_nhan) {
        this.ma_benh_nhan = ma_benh_nhan;
        this.ten_benh_nhan = ten_benh_nhan;
    }

    public int getMa_benh_nhan() {
        return ma_benh_nhan;
    }

    public void setMa_benh_nhan(int ma_benh_nhan) {
        this.ma_benh_nhan = ma_benh_nhan;
    }

    public String getTen_benh_nhan() {
        return ten_benh_nhan;
    }

    public void setTen_benh_nhan(String ten_benh_nhan) {
        this.ten_benh_nhan = ten_benh_nhan;
    }
}
