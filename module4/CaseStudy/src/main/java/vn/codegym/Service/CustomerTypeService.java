package vn.codegym.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.Model.CustomerType;
import vn.codegym.Model.Service;

import java.util.List;

public interface CustomerTypeService {
    List<CustomerType> findAll();

    void save(CustomerType customerType);

    void update(CustomerType customerType);

    void delete(int id);

    CustomerType findById(int id);
}
