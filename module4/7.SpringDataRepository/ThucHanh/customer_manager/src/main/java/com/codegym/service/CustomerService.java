package com.codegym.service;

import com.codegym.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CustomerService {
    Page<Customer> findAll(Pageable pageable);
    Page<Customer> findAllByFirstNameContaining(String keyword,Pageable pageable);
    void save(Customer customer);
    void delete(Integer id);
    Customer findById(Integer id);
}
