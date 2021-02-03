package vn.codegym.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.codegym.Model.Customer;
import vn.codegym.Service.CustomerService;
import vn.codegym.repository.Customer.CustomerRepository;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void update(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void delete(String id) {
        this.customerRepository.deleteById(id);
    }


    @Override
    public Customer findById(String id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public Page<Customer> findAllByCustomer_nameContaining(Pageable pageable, String nameSearch) {
        return this.customerRepository.findAllByCustomerNameContaining(pageable, nameSearch);
    }

    @Override
    public Page<Customer> searchNameAddressGender(Pageable pageable, String keyword) {
        return this.customerRepository.searchNameAddressGender(pageable, keyword);
    }


}
