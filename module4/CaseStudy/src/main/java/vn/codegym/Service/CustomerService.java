package vn.codegym.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.Model.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();

    Page<Customer> findAll(Pageable pageable);

    void save(Customer customer);

    void update(Customer customer);
    void delete(String id);
    Customer findById(String id);

    Page<Customer> findAllByCustomer_nameContaining(Pageable pageable,String nameSearch);
    Page<Customer> searchNameAddressGender(Pageable pageable, String keyword);
}
