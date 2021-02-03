package Dao;

import CaseStudy.Model.Service.Service;

import java.sql.SQLException;
import java.util.List;

public interface IServiceDao {
    public void insertCustomer(Service service) throws SQLException;

    public Service selectCustomer(int id);

    public List<Service> selectAllService();

    public boolean deleteService(int id) throws SQLException;

    public boolean updateService(Service service) throws SQLException;

    public Service getServiceById(int id);

    public void insertServiceStore(Service service) throws SQLException;
}
