package vn.codegym.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.Model.Service;
import vn.codegym.Service.ServiceService;
import vn.codegym.repository.Service.ServiceRepository;

import java.util.List;

@org.springframework.stereotype.Service
public class ServiceImpl implements ServiceService {

    @Autowired
    ServiceRepository serviceRepository;

    @Override
    public List<Service> findAll() {
        return serviceRepository.findAll();
    }

    @Override
    public Page<Service> findAll(Pageable pageable) {
        return serviceRepository.findAll(pageable);
    }

    @Override
    public void save(Service service) {
        serviceRepository.save(service);
    }

    @Override
    public void update(Service service) {
        serviceRepository.save(service);
    }

    @Override
    public void delete(String id) {
        this.serviceRepository.deleteById(id);
    }

    @Override
    public Service findById(String id) {
        return serviceRepository.findById(id).orElse(null);
    }

    @Override
    public Page<Service> findAllByCustomer_nameContaining(Pageable pageable, String nameSearch) {
        return this.serviceRepository.findAllByServiceNameContaining(pageable,nameSearch);
    }
}
