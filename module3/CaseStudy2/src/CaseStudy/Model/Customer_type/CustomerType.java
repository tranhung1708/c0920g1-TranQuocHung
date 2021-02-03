package CaseStudy.Model.Customer_type;

public class CustomerType {
    String customer_type_id;
    String customer_type_name;

    public CustomerType() {
    }

    public CustomerType(String customer_type_id, String customer_type_name) {
        this.customer_type_id = customer_type_id;
        this.customer_type_name = customer_type_name;
    }

    public String getCustomer_type_id() {
        return customer_type_id;
    }

    public void setCustomer_type_id(String customer_type_id) {
        this.customer_type_id = customer_type_id;
    }

    public String getCustomer_type_name() {
        return customer_type_name;
    }

    public void setCustomer_type_name(String customer_type_name) {
        this.customer_type_name = customer_type_name;
    }
}
