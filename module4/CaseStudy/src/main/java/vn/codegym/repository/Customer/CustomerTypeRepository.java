package vn.codegym.repository.Customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.codegym.Model.CustomerType;
@Repository
public interface CustomerTypeRepository extends JpaRepository<CustomerType,Integer> {

}
