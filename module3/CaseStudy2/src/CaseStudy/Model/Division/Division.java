package CaseStudy.Model.Division;

public class Division {
    int division_id;
    String division_name;

    public Division() {
    }

    public Division(int division_id, String division_name) {
        this.division_id = division_id;
        this.division_name = division_name;
    }

    public int getDivision_id() {
        return division_id;
    }

    public void setDivision_id(int division_id) {
        this.division_id = division_id;
    }

    public String getDivision_name() {
        return division_name;
    }

    public void setDivision_name(String division_name) {
        this.division_name = division_name;
    }
}
