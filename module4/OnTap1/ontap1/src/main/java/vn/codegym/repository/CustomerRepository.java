package vn.codegym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import vn.codegym.model.Customer;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer , Integer> {
    @Query("select c from customer c where c.nameCustomer like %?1% and c.service.nameService like %?2%")
    List<Customer> search(String nameCustomer, String nameService);
}
