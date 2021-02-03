package com.codegym.service;

import com.codegym.model.Customer;
import com.codegym.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepository customerRepository;
    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return this.customerRepository.findAll(pageable);
    }

    @Override
    public Page<Customer> findAllByFirstNameContaining(String keyword, Pageable pageable) {
        return this.customerRepository.findAllByFirstNameContaining(keyword,pageable);
    }

    @Override
    public void save(Customer customer) {
         this.customerRepository.save(customer);
    }

    @Override
    public void delete(Integer id) {
        this.customerRepository.deleteById(id);
    }

    @Override
    public Customer findById(Integer id) {
        return this.customerRepository.findById(id).orElse(null);
    }
}
