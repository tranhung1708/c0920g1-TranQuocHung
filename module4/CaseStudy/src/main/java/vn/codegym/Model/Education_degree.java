package vn.codegym.Model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Education_degree {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int educationDegreeId;
    private String educationDegreeName;
    @OneToMany(mappedBy = "education_degree")
    private List<Employee> employees;

    public Education_degree() {
    }

    public int getEducationDegreeId() {
        return educationDegreeId;
    }

    public void setEducationDegreeId(int educationDegreeId) {
        this.educationDegreeId = educationDegreeId;
    }

    public String getEducationDegreeName() {
        return educationDegreeName;
    }

    public void setEducationDegreeName(String educationDegreeName) {
        this.educationDegreeName = educationDegreeName;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
