package CaseStudy.Model.Service;

import CaseStudy.Model.Employee.Employee;
import CaseStudy.Model.Service.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceRepository {
    private String jdbcURL = "jdbc:mysql://localhost:3306/case_study2";
    private String jdbcUsername = "root";
    private String jdbcPassword = "17082019hH";

    private static final String INSERT_SERVICE_SQL = "INSERT INTO service" + " (service_id,service_name," +
            "service_area,service_cost,service_max_people,rent_type_id,service_type_id,standard_room," +
            "description_other_convenience,pool_area,number_of_floors)VALUE" +
            "(?,?,?,?,?,?,?,?,?,?,?);";
    private static final String SELECT_SERVICE_BY_ID = "select * from service where service_id = ?";
    private static final String SELECT_ALL_SERVICE = "select * from service";
    private static final String DELETE_SERVICE_SQL = "delete from service where service_id = ?;";
    private static final String UPDATE_SERVICE_SQL = "update service set  service_name = ?, service_area= ?, service_cost = ?," +
            "service_max_people = ?,rent_type_id = ?, service_type_id = ?,standard_room= ?,description_other_convenience = ?," +
            "pool_area = ? ,number_of_floors = ? where service_id = ?";
    private static final String SEARCH_SQL = "select * from service where service_name like '%' ? '%';";


    public ServiceRepository() {
    }

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void insertService(Service service) throws SQLException {
        Connection connection = getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SERVICE_SQL)) {
            preparedStatement.setString(1, service.getService_id());
            preparedStatement.setString(2, service.getService_name());
            preparedStatement.setString(3, service.getService_area());
            preparedStatement.setString(4, service.getService_cost());
            preparedStatement.setString(5, service.getService_max_people());
            preparedStatement.setString(6, service.getRent_type_id());
            preparedStatement.setString(7, service.getService_type_id());
            preparedStatement.setString(8, service.getStandard_room());
            preparedStatement.setString(9, service.getDescription_other_convenience());
            preparedStatement.setString(10, service.getPool_area());
            preparedStatement.setString(11, service.getNumber_of_floors());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }finally {
             connection.close();
        }
    }

    public Service selectService(String  id) {
        Service service = null;
        try (Connection connection = getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_SERVICE_BY_ID);
            preparedStatement.setString(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String service_id = rs.getString("service_id");
                String service_name = rs.getString("service_name");
                String service_area = rs.getString("service_area");
                String service_cost = rs.getString("service_cost");
                String service_max_people = rs.getString("service_max_people");
                String rent_type_id = rs.getString("rent_type_id");
                String service_type_id = rs.getString("service_type_id");
                String standard_room = rs.getString("standard_room");
                String description_other_convenience = rs.getString("description_other_convenience");
                String pool_area = rs.getString("pool_area");
                String number_of_floors = rs.getString("number_of_floors");
                service = new Service(service_id, service_name, service_area, service_cost, service_max_people, rent_type_id
                        , service_type_id, standard_room, description_other_convenience, pool_area, number_of_floors);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return service;
    }

    public List<Service> selectAllService() {
        List<Service> serviceList = new ArrayList<>();
        try (Connection connection = getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_SERVICE);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String service_id = rs.getString("service_id");
                String service_name = rs.getString("service_name");
                String service_area = rs.getString("service_area");
                String service_cost = rs.getString("service_cost");
                String service_max_people = rs.getString("service_max_people");
                String rent_type_id = rs.getString("rent_type_id");
                String service_type_id = rs.getString("service_type_id");
                String standard_room = rs.getString("standard_room");
                String description_other_convenience = rs.getString("description_other_convenience");
                String pool_area = rs.getString("pool_area");
                String number_of_floors = rs.getString("number_of_floors");
                serviceList.add(new Service(service_id, service_name, service_area, service_cost, service_max_people, rent_type_id
                        , service_type_id, standard_room, description_other_convenience, pool_area, number_of_floors));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return serviceList;
    }

    public boolean delete(String id) throws SQLException {
        boolean rowDelete;
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(DELETE_SERVICE_SQL);) {
            preparedStatement.setString(1, id);
            rowDelete = preparedStatement.executeUpdate() > 0;
        }
        return rowDelete;
    }

    public boolean updateService(Service service) throws SQLException {
        boolean rowUpdate;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_SERVICE_SQL)) {
            statement.setString(1, service.getService_name());
            statement.setString(2, service.getService_area());
            statement.setString(3, service.getService_cost());
            statement.setString(4, service.getService_max_people());
            statement.setString(5, service.getRent_type_id());
            statement.setString(6, service.getService_type_id());
            statement.setString(7, service.getStandard_room());
            statement.setString(8, service.getDescription_other_convenience());
            statement.setString(9, service.getPool_area());
            statement.setString(10, service.getNumber_of_floors());
            statement.setString(11, service.getService_id());
            rowUpdate = statement.executeUpdate() > 0;
        }
        return rowUpdate;
    }
    public List<Service> search(String name){
        List<Service> serviceList = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_SQL)) {
            preparedStatement.setString(1,name);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String service_id = rs.getString("service_id");
                String service_name = rs.getString("service_name");
                String service_area = rs.getString("service_area");
                String service_cost = rs.getString("service_cost");
                String service_max_people = rs.getString("service_max_people");
                String rent_type_id = rs.getString("rent_type_id");
                String service_type_id = rs.getString("service_type_id");
                String standard_room = rs.getString("standard_room");
                String description_other_convenience = rs.getString("description_other_convenience");
                String pool_area = rs.getString("pool_area");
                String number_of_floors = rs.getString("number_of_floors");
                serviceList.add(new Service(service_id, service_name, service_area, service_cost, service_max_people, rent_type_id
                        , service_type_id, standard_room, description_other_convenience, pool_area, number_of_floors));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return serviceList;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
