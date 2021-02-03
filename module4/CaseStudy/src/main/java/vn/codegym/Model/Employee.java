package vn.codegym.Model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;
import java.util.List;

@Entity
public class Employee {
    @Id
    @NotBlank(message = "must not be left blank")
    private String employeeId;
    @Pattern(regexp = "^([\\p{Lu}][\\p{Ll}]{1,8})(\\s([\\p{Lu}]|[\\p{Lu}][\\p{Ll}]{1,10})){0,6}$" , message = "Please enter your correct name")
    private String employeeName;
    @DateTimeFormat(pattern = "yyyy/mm/dd")
    private String employeeBirthday;
    @Size(min = 9, max = 9, message = "Identity card must be 9 numbers")
    private String employeeIdCard;

    @Pattern(regexp = "^\\d+$", message = "The number of people must be greater than 0")
    private String employeeSalary;

    @Pattern(regexp = "^(84)\\d{10}$", message = "You must enter the format 84xxxxxxxxx")
    private String employeePhone;
    @Email(message = "You must enter the format abc@abc.com")
    @Pattern(regexp = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$" , message = "You must enter the correct format abc@abc.com")
    private String employeeEmail;

    private String employeeAddress;

    @ManyToOne
    @JoinColumn(name = "position_id" , nullable=false)
    private Position position;

    @ManyToOne
    @JoinColumn(name = "education_degree_id" , nullable=false)
    private Education_degree education_degree;

    @ManyToOne
    @JoinColumn(name = "division_id" ,nullable=false)
    private Division division;

    @ManyToOne
    @JoinColumn(name = "username" , nullable = false)
    private User user;
    public Employee() {
    }
    @OneToMany(mappedBy = "employee")
    private List<Contract> contracts;


    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeBirthday() {
        return employeeBirthday;
    }

    public void setEmployeeBirthday(String employeeBirthday) {
        this.employeeBirthday = employeeBirthday;
    }

    public String getEmployeeIdCard() {
        return employeeIdCard;
    }

    public void setEmployeeIdCard(String employeeIdCard) {
        this.employeeIdCard = employeeIdCard;
    }

    public String getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(String employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public String getEmployeePhone() {
        return employeePhone;
    }

    public void setEmployeePhone(String employeePhone) {
        this.employeePhone = employeePhone;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Education_degree getEducation_degree() {
        return education_degree;
    }

    public void setEducation_degree(Education_degree education_degree) {
        this.education_degree = education_degree;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }
}
