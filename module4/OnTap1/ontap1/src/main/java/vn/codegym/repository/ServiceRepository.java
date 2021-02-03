package vn.codegym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.codegym.model.Service;
@Repository
public interface ServiceRepository extends JpaRepository<Service , Integer> {
}
