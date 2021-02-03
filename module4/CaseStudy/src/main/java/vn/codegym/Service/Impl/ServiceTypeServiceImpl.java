package vn.codegym.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.Model.ServiceType;
import vn.codegym.Service.ServiceTypeService;
import vn.codegym.repository.Service.ServiceRepository;
import vn.codegym.repository.Service.ServiceTypeRepository;

import java.util.List;
@Service
public class ServiceTypeServiceImpl implements ServiceTypeService {
    @Autowired
    ServiceTypeRepository serviceTypeRepository;
    @Override
    public List<ServiceType> findAll() {
        return serviceTypeRepository.findAll();
    }

    @Override
    public void save(ServiceType serviceType) {
        serviceTypeRepository.save(serviceType);
    }

    @Override
    public void update(ServiceType serviceType) {
        serviceTypeRepository.save(serviceType);
    }

    @Override
    public void delete(int id) {
        serviceTypeRepository.deleteById(id);
    }

    @Override
    public ServiceType findById(int id) {
        return serviceTypeRepository.findById(id).orElse(null);
    }
}
