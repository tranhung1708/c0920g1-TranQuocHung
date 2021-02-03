package Dao;

import CaseStudy.Model.Customer.Customer;

import java.sql.SQLException;
import java.util.List;

public interface CustomerDaos {
    public void insertCustomer(Customer customer) throws SQLException;

    public Customer selectCustomer(int id);

    public List<Customer> selectAllCustomer();

    public boolean deleteCustomer(int id) throws SQLException;

    public boolean updateCustomer(Customer customer) throws SQLException;

    public Customer getCustomerById(int id);

    public void insertCustomerStore(Customer customer) throws SQLException;
}
