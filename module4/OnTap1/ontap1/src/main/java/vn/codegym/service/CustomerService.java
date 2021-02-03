package vn.codegym.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.model.Customer;

import java.util.List;

public interface CustomerService {
    Page<Customer> findAll(Pageable pageable);
    List<Customer> findAll();
    void save(Customer customer);
    void delete(int id);
    Customer findById(int id);
    List<Customer> search(String nameCustomer , String nameService);
}
