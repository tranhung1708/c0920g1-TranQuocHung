package vn.codegym.service;

import vn.codegym.model.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();

    void update(Customer customer);

    void save(Customer customer);

    void remove(int id);

    Customer findById(int id);
}
