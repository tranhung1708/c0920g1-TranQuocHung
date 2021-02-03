package CaseStudy.model;

import java.util.Date;

public class Employee implements Comparable<Employee> {
    protected String name;
    protected String birthday;
    protected String diaChi;

    public Employee() {
    }

    public Employee(String name, String birthday, String diaChi) {
        this.name = name;
        this.birthday = birthday;
        this.diaChi = diaChi;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", birthday='" + birthday + '\'' +
                ", diaChi='" + diaChi + '\'' +
                '}';
    }

    @Override
    public int compareTo(Employee o) {
        return this.getName().compareTo(o.getName());
    }
}
