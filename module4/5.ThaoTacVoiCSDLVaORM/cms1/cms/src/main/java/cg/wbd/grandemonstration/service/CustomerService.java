package cg.wbd.grandemonstration.service;

import cg.wbd.grandemonstration.model.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();

    Customer findOne(Long id);

    Customer save(Customer customer);

}
