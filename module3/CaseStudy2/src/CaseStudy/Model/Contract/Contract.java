package CaseStudy.Model.Contract;

public class Contract {

    String contract_id;
    String contract_start_date;
    String contract_end_date;
    String contract_deposit;
    String contract_total_money;
    String employee_id;
    String customer_id;
    String service_id;

    public Contract() {
    }

    public Contract(String contract_id, String contract_start_date, String contract_end_date, String contract_deposit,
                    String contract_total_money, String employee_id, String customer_id, String service_id) {
        this.contract_id = contract_id;
        this.contract_start_date = contract_start_date;
        this.contract_end_date = contract_end_date;
        this.contract_deposit = contract_deposit;
        this.contract_total_money = contract_total_money;
        this.employee_id = employee_id;
        this.customer_id = customer_id;
        this.service_id = service_id;
    }

    public String getContract_id() {
        return contract_id;
    }

    public void setContract_id(String contract_id) {
        this.contract_id = contract_id;
    }

    public String getContract_start_date() {
        return contract_start_date;
    }

    public void setContract_start_date(String contract_start_date) {
        this.contract_start_date = contract_start_date;
    }

    public String getContract_end_date() {
        return contract_end_date;
    }

    public void setContract_end_date(String contract_end_date) {
        this.contract_end_date = contract_end_date;
    }

    public String getContract_deposit() {
        return contract_deposit;
    }

    public void setContract_deposit(String contract_deposit) {
        this.contract_deposit = contract_deposit;
    }

    public String getContract_total_money() {
        return contract_total_money;
    }

    public void setContract_total_money(String contract_total_money) {
        this.contract_total_money = contract_total_money;
    }

    public String getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(String employee_id) {
        this.employee_id = employee_id;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public String getService_id() {
        return service_id;
    }

    public void setService_id(String service_id) {
        this.service_id = service_id;
    }
}
