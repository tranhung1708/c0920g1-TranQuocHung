package vn.codegym.repository.Customer;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import vn.codegym.Model.Customer;
@Repository
public interface CustomerRepository extends JpaRepository<Customer,String> {
        @Query("select c from customer c where c.customerName like %?1% " +
                "or c.customerAddress like %?1% or c.customerGender like %?1%")
        Page<Customer> searchNameAddressGender(Pageable pageable, String keyword);

    Page<Customer> findAllByCustomerNameContaining(Pageable pageable, String nameSearch);
}
