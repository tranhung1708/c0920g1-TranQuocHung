package Model;

public class Truong_hoc {
    int ma_truong_hoc;
    String ten_truong_hoc;
    String dia_chi;

    public Truong_hoc() {
    }

    public Truong_hoc(int ma_truong_hoc, String ten_truong_hoc, String dia_chi) {
        this.ma_truong_hoc = ma_truong_hoc;
        this.ten_truong_hoc = ten_truong_hoc;
        this.dia_chi = dia_chi;
    }

    public int getMa_truong_hoc() {
        return ma_truong_hoc;
    }

    public void setMa_truong_hoc(int ma_truong_hoc) {
        this.ma_truong_hoc = ma_truong_hoc;
    }

    public String getTen_truong_hoc() {
        return ten_truong_hoc;
    }

    public void setTen_truong_hoc(String ten_truong_hoc) {
        this.ten_truong_hoc = ten_truong_hoc;
    }

    public String getDia_chi() {
        return dia_chi;
    }

    public void setDia_chi(String dia_chi) {
        this.dia_chi = dia_chi;
    }
}
