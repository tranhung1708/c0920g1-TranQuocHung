package Test5;

public class Gai extends ConNguoi {
    @Override
    public void show() {
        System.out.println(this.toString());
    }

    private String viecLam;
    private String vo;
    private String con;

    public Gai() {
    }

    public Gai(String viecLam, String vo, String con) {
        this.viecLam = viecLam;
        this.vo = vo;
        this.con = con;
    }

    public Gai(String id, String ten, String tuoi, String diaChi, String capDo, String ngaySinh, String viecLam, String vo, String con) {
        super(id, ten, tuoi, diaChi, capDo, ngaySinh);
        this.viecLam = viecLam;
        this.vo = vo;
        this.con = con;
    }

    public String getViecLam() {
        return viecLam;
    }

    public void setViecLam(String viecLam) {
        this.viecLam = viecLam;
    }

    public String getVo() {
        return vo;
    }

    public void setVo(String vo) {
        this.vo = vo;
    }

    public String getCon() {
        return con;
    }

    public void setCon(String con) {
        this.con = con;
    }

    @Override
    public String toString() {
        return "Gai{" + super.toString() +
                "viecLam='" + viecLam + '\'' +
                ", vo='" + vo + '\'' +
                ", con='" + con + '\'' +
                '}';
    }
}
