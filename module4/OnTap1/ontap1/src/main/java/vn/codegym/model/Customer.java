package vn.codegym.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import java.util.Date;

@Entity(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCustomer;
    @NotBlank(message = "abc")
    private String nameCustomer;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Past
    private Date birthdayCustomer;
    private String addressCustomer;
    private String genderCustomer;

    @ManyToOne
    @JoinColumn(name = "id_service" , nullable = false)
    private Service service;

    public Customer() {
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public Date getBirthdayCustomer() {
        return birthdayCustomer;
    }

    public void setBirthdayCustomer(Date birthdayCustomer) {
        this.birthdayCustomer = birthdayCustomer;
    }

    public String getAddressCustomer() {
        return addressCustomer;
    }

    public void setAddressCustomer(String addressCustomer) {
        this.addressCustomer = addressCustomer;
    }

    public String getGenderCustomer() {
        return genderCustomer;
    }

    public void setGenderCustomer(String genderCustomer) {
        this.genderCustomer = genderCustomer;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }
}
