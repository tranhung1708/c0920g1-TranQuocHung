package vn.codegym.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.Model.Service;

import java.util.List;

public interface ServiceService {
    List<Service> findAll();
    Page<vn.codegym.Model.Service> findAll(Pageable pageable);

    void save(Service service);

    void update(Service service);
    void delete(String id);
    Service findById(String id);

    Page<vn.codegym.Model.Service> findAllByCustomer_nameContaining(Pageable pageable, String nameSearch);
}
