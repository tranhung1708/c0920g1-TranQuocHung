package vn.codegym.service;

import org.springframework.beans.factory.annotation.Autowired;
import vn.codegym.model.Customer;
import vn.codegym.repository.CustomerRepository;

import java.util.List;

public class CustomerServiecImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findById(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void remove(Long id) {
        customerRepository.remove(id);
    }
}
