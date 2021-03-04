package com.example.testmodule6.Service;

import com.example.testmodule6.model.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();

    void save(Customer customer);

    void delete(int id);

    void update(Customer customer);

    Customer findById(int id);
}
