package vn.codegym.service;

import org.springframework.beans.factory.annotation.Autowired;
import vn.codegym.model.Service;
import vn.codegym.repository.ServiceRepository;

import java.util.List;
@org.springframework.stereotype.Service
public class ServiceServiceImpl implements ServiceService {
    @Autowired
    ServiceRepository serviceRepository;
    @Override
    public List<Service> findAll() {
        return serviceRepository.findAll();
    }
}
