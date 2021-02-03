package vn.codegym.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.codegym.Model.Customer;
import vn.codegym.Model.CustomerType;
import vn.codegym.Service.CustomerService;
import vn.codegym.Service.CustomerTypeService;
import vn.codegym.repository.Customer.CustomerTypeRepository;

import java.util.List;

@Service
public class CustomerTypeServiceImpl implements CustomerTypeService {
    @Autowired
    CustomerTypeRepository customerTypeRepository;

    @Override
    public List<CustomerType> findAll() {
        return customerTypeRepository.findAll();
    }

    @Override
    public void save(CustomerType customerType) {
        customerTypeRepository.save(customerType);
    }

    @Override
    public void update(CustomerType customerType) {
        customerTypeRepository.save(customerType);
    }

    @Override
    public void delete(int id) {
        customerTypeRepository.deleteById(id);
    }

    @Override
    public CustomerType findById(int id) {
        return customerTypeRepository.findById(id).orElse(null);
    }
}
