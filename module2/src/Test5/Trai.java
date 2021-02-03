package Test5;

public class Trai extends ConNguoi {
    @Override
    public void show() {
        System.out.println(this.toString());
    }

    private String viecLam;
    private String chong;
    private String con;

    public Trai() {
    }

    public Trai(String viecLam, String chong, String con) {
        this.viecLam = viecLam;
        this.chong = chong;
        this.con = con;
    }

    public Trai(String id, String ten, String tuoi, String diaChi, String capDo, String ngaySinh, String viecLam, String chong, String con) {
        super(id, ten, tuoi, diaChi, capDo, ngaySinh);
        this.viecLam = viecLam;
        this.chong = chong;
        this.con = con;
    }

    public String getViecLam() {
        return viecLam;
    }

    public void setViecLam(String viecLam) {
        this.viecLam = viecLam;
    }

    public String getChong() {
        return chong;
    }

    public void setChong(String chong) {
        this.chong = chong;
    }

    public String getCon() {
        return con;
    }

    public void setCon(String con) {
        this.con = con;
    }

    @Override
    public String toString() {
        return "Trai{" + super.toString() +
                "viecLam='" + viecLam + '\'' +
                ", chong='" + chong + '\'' +
                ", con='" + con + '\'' +
                '}';
    }
}
