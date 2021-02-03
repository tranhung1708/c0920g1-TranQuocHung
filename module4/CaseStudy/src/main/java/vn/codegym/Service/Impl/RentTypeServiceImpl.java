package vn.codegym.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.Model.RentType;
import vn.codegym.Service.RentTypeService;
import vn.codegym.repository.Service.RentTypeRepository;

import java.util.List;

@Service
public class RentTypeServiceImpl implements RentTypeService {
    @Autowired
    RentTypeRepository rentTypeRepository;

    @Override
    public List<RentType> findAll() {
        return rentTypeRepository.findAll();
    }

    @Override
    public void save(RentType rentType) {
        rentTypeRepository.save(rentType);
    }

    @Override
    public void update(RentType rentType) {
        rentTypeRepository.save(rentType);
    }

    @Override
    public void delete(int id) {
        rentTypeRepository.deleteById(id);
    }

    @Override
    public RentType findById(int id) {
        return rentTypeRepository.findById(id).orElse(null);
    }
}
