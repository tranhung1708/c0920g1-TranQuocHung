package vn.codegym.Model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Position {
    @Id
    private int positionId;
    private String positionName;
    @OneToMany(mappedBy = "position")
    private List<Employee> employees;

    public int getPositionId() {
        return positionId;
    }

    public void setPositionId(int positionId) {
        this.positionId = positionId;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
