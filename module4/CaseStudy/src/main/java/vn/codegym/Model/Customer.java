package vn.codegym.Model;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(generator = "my_generator")
    @GenericGenerator(name = "my_generator", strategy = "vn.codegym.common.MyGenerator")
    @Column(name = "customer_id")
    private String customerId;
    @ManyToOne
    @JoinColumn(name = "customer_type_id", nullable = false)
    private CustomerType customerType;

    @NotBlank(message = "Name cannot be left blank")
    private String customerName;
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date customerBirthday;

    private String customerGender;
    @Size(min = 9, max = 9, message = "Identity card must be 9 numbers")
    private String customerIdCard;

    private String customerPhone;
    @Email(message = "The email you entered is incorrect, enter the form abc@abc.abc")
    private String customerEmail;

    private String customerAddress;

    @OneToMany(mappedBy = "customer")
    private List<Contract> contracts;

    public Customer() {
    }

//    public Customer(String customerId, @NotBlank String customerName, String customerBirthday, String customerGender,
//                    String customerIdCard, String customerPhone, String customerEmail, String customerAddress) {
//        this.customerId = customerId;
//        this.customerName = customerName;
//        this.customerBirthday = customerBirthday;
//        this.customerGender = customerGender;
//        this.customerIdCard = customerIdCard;
//        this.customerPhone = customerPhone;
//        this.customerEmail = customerEmail;
//        this.customerAddress = customerAddress;
//    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Date getCustomerBirthday() {
        return customerBirthday;
    }

    public void setCustomerBirthday(Date customerBirthday) {
        this.customerBirthday = customerBirthday;
    }

    public String getCustomerGender() {
        return customerGender;
    }

    public void setCustomerGender(String customerGender) {
        this.customerGender = customerGender;
    }

    public String getCustomerIdCard() {
        return customerIdCard;
    }

    public void setCustomerIdCard(String customerIdCard) {
        this.customerIdCard = customerIdCard;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }
}
