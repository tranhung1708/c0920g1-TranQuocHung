package vn.codegym.repository.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.Model.Customer;
import vn.codegym.Model.Service;

public interface ServiceRepository extends JpaRepository<Service , String> {
    Page<Service> findAllByServiceNameContaining(Pageable pageable, String nameSearch);
}
