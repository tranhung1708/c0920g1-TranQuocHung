package com.codegym.service;

import com.codegym.entity.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();

    void save(Customer customer);

    Customer findById(int id);

    void update( Customer customer);

    void remove(int id);
}
