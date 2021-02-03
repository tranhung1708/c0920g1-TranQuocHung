package vn.codegym.Model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Division {
    @Id
    private int divisionId;
    private String divisionName;
    @OneToMany(mappedBy = "division", fetch = FetchType.LAZY)
    private List<Employee> employees;

    public Division() {
    }

    public int getDivisionId() {
        return divisionId;
    }

    public void setDivisionId(int divisionId) {
        this.divisionId = divisionId;
    }

    public String getDivisionName() {
        return divisionName;
    }

    public void setDivisionName(String divisionName) {
        this.divisionName = divisionName;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
