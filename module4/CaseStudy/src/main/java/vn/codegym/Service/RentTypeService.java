package vn.codegym.Service;

import vn.codegym.Model.CustomerType;
import vn.codegym.Model.RentType;

import java.util.List;

public interface RentTypeService  {
    List<RentType> findAll();

    void save(RentType RentType);

    void update(RentType RentType);

    void delete(int id);

    RentType findById(int id);
}
