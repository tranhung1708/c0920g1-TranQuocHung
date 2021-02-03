package vn.codegym.Model;

import org.springframework.format.annotation.DateTimeFormat;
import vn.codegym.common.ValidDuration;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import java.util.Date;
import java.util.List;

@Entity
@ValidDuration
public class Contract {
    @Id
    private String contractId;
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private String contractStartDate;
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private String contractEndDate;
    private String contractDeposit;
//    @Min(1)
    private String contractTotalMoney;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "emlpoyee_id" , nullable = false)
    private Employee employee;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "customer_id" , nullable = false)
    private Customer customer;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "service_id" , nullable = false)
    private Service service;
    @OneToMany(mappedBy = "contract")
    private List<ContractDetail> contractDetails;

    public Contract() {
    }

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId;
    }

    public String getContractStartDate() {
        return contractStartDate;
    }

    public void setContractStartDate(String contractStartDate) {
        this.contractStartDate = contractStartDate;
    }

    public String getContractEndDate() {
        return contractEndDate;
    }

    public void setContractEndDate(String contractEndDate) {
        this.contractEndDate = contractEndDate;
    }

    public String getContractDeposit() {
        return contractDeposit;
    }

    public void setContractDeposit(String contractDeposit) {
        this.contractDeposit = contractDeposit;
    }

    public String getContractTotalMoney() {
        return contractTotalMoney;
    }

    public void setContractTotalMoney(String contractTotalMoney) {
        this.contractTotalMoney = contractTotalMoney;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public List<ContractDetail> getContractDetails() {
        return contractDetails;
    }

    public void setContractDetails(List<ContractDetail> contractDetails) {
        this.contractDetails = contractDetails;
    }
}
