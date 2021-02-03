package vn.codegym.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.Model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee , String> {
    Page<Employee> findAllByEmployeeNameContaining(Pageable pageable, String nameSearch);
}
