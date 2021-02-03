package vn.codegym.repository.Service;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.Model.ServiceType;

public interface ServiceTypeRepository extends JpaRepository<ServiceType , Integer> {
}
