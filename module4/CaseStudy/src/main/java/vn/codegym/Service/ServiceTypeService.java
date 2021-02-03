package vn.codegym.Service;

import vn.codegym.Model.CustomerType;
import vn.codegym.Model.ServiceType;

import java.util.List;

public interface ServiceTypeService {
    List<ServiceType> findAll();

    void save(ServiceType serviceType);

    void update(ServiceType serviceType);

    void delete(int id);

    ServiceType findById(int id);
}
