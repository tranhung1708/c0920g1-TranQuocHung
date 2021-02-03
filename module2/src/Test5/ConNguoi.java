package Test5;

public abstract class ConNguoi {
    protected String id ;
    protected String ten ;
    protected String tuoi ;
    protected String diaChi ;
    protected String capDo ;
    protected String ngaySinh ;

    public abstract void show();

    public ConNguoi() {
    }

    public ConNguoi(String id, String ten, String tuoi, String diaChi, String capDo, String ngaySinh) {
        this.id = id;
        this.ten = ten;
        this.tuoi = tuoi;
        this.diaChi = diaChi;
        this.capDo = capDo;
        this.ngaySinh = ngaySinh;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getTuoi() {
        return tuoi;
    }

    public void setTuoi(String tuoi) {
        this.tuoi = tuoi;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getCapDo() {
        return capDo;
    }

    public void setCapDo(String capDo) {
        this.capDo = capDo;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    @Override
    public String toString() {
        return "ConNguoi{" +
                "id='" + id + '\'' +
                ", ten='" + ten + '\'' +
                ", tuoi='" + tuoi + '\'' +
                ", diaChi='" + diaChi + '\'' +
                ", capDo='" + capDo + '\'' +
                ", ngaySinh='" + ngaySinh + '\'' +
                '}';
    }
}
