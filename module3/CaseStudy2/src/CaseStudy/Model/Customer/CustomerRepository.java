package CaseStudy.Model.Customer;

import CaseStudy.Model.Attach_service.Attach_service;
import CaseStudy.Model.Attach_service.Attach_serviceRepository;
import CaseStudy.Model.Contract.Contract;
import CaseStudy.Model.Contract.ContractRepository;
import CaseStudy.Model.Contract_detail.Contract_Detail_Repository;
import CaseStudy.Model.Contract_detail.Contract_detail;
import CaseStudy.Model.Customer.Customer;
import CaseStudy.Model.Employee.Employee;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository {
    private String jdbcURL = "jdbc:mysql://localhost:3306/case_study2";
    private String jdbcUsername = "root";
    private String jdbcPassword = "17082019hH";

    private static final String INSERT_CUSTOMER_SQL = "INSERT INTO customer" + " (customer_id,customer_type_id," +
            "customer_name,customer_birthday,customer_gender,customer_id_card,customer_phone,customer_email," +
            "customer_address)VALUE" +
            "(?,?,?,?,?,?,?,?,?);";
    //    private static final String SELECT_CUSTOMER_BY_ID = "select customer_id,customer_type_id,customer_name," +
//            "customer_birthday,customer_gender,customer_id_card,customer_phone,customer_email,customer_address = ?";
    private static final String SELECT_CUSTOMER_BY_ID = "select * from customer where customer_id = ?";
    private static final String SELECT_ALL_CUSTOMER = "select * from customer";
    private static final String DELETE_CUSTOMER_SQL = "delete from customer where customer_id = ?;";
    private static final String UPDATE_CUSTOMER_SQL = "update customer set  customer_type_id = ?, customer_name= ?, customer_birthday = ?," +
            "customer_gender = ?,customer_id_card = ?, customer_phone = ?,customer_email= ?,customer_address = ? where customer_id = ?";
    private static final String SEARCH_SQL = "select * from customer where customer_name like '%' ? '%';";
    private static final String SELECT_CUSTOMER_SERVICE = "select customer.customer_name , contract.customer_id ,contract.contract_start_date , contract.contract_end_date ," +
            "attach_service.attach_service_name " +
            "from customer join contract on contract.customer_id = customer.customer_id " +
            "left join contract_detail on contract_detail.contract_id = contract.contract_id " +
            "left join attach_service on attach_service.attach_service_id = contract_detail.attach_service_id" +
            " where contract.contract_start_date < now() and contract.contract_end_date > now();";

    public CustomerRepository() {
    }

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void insertCustomer(Customer customer) throws SQLException {
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CUSTOMER_SQL)) {
            preparedStatement.setString(1, customer.getCustomer_id());
            preparedStatement.setString(2, customer.getCustomer_type_id());
            preparedStatement.setString(3, customer.getCustomer_name());
            preparedStatement.setString(4, customer.getCustomer_birthday());
            preparedStatement.setString(5, customer.getCustomer_gender());
            preparedStatement.setString(6, customer.getCustomer_id_card());
            preparedStatement.setString(7, customer.getCustomer_phone());
            preparedStatement.setString(8, customer.getCustomer_email());
            preparedStatement.setString(9, customer.getCustomer_address());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public Customer selectCustomer(String id) {
        Customer customer = null;
        try (Connection connection = getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CUSTOMER_BY_ID);
            preparedStatement.setString(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String customer_id = rs.getString("customer_id");
                String customer_type_id = rs.getString("customer_type_id");
                String customer_name = rs.getString("customer_name");
                String customer_birthday = rs.getString("customer_birthday");
                String customer_gender = rs.getString("customer_gender");
                String customer_id_card = rs.getString("customer_id_card");
                String customer_phone = rs.getString("customer_phone");
                String customer_email = rs.getString("customer_email");
                String customer_address = rs.getString("customer_address");
                customer = new Customer(customer_id, customer_type_id, customer_name, customer_birthday, customer_gender,
                        customer_id_card, customer_phone, customer_email, customer_address);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return customer;
    }

    public List<Customer> selectAllCustomer() {
        List<Customer> customers = new ArrayList<>();
        try (Connection connection = getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CUSTOMER);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String customer_id = rs.getString("customer_id");
                String customer_type_id = rs.getString("customer_type_id");
                String customer_name = rs.getString("customer_name");
                String customer_birthday = rs.getString("customer_birthday");
                String customer_gender = rs.getString("customer_gender");
                String customer_id_card = rs.getString("customer_id_card");
                String customer_phone = rs.getString("customer_phone");
                String customer_email = rs.getString("customer_email");
                String customer_address = rs.getString("customer_address");
                customers.add(new Customer(customer_id, customer_type_id, customer_name, customer_birthday, customer_gender
                        , customer_id_card, customer_phone, customer_email, customer_address));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return customers;
    }

    public boolean deleteCustomer(String id) throws SQLException {
        boolean rowDelete;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_CUSTOMER_SQL);) {
            statement.setString(1, id);
            rowDelete = statement.executeUpdate() > 0;
        }
        return rowDelete;
    }

    public boolean updateCustomer(Customer customer) throws SQLException {
        boolean rowUpdate;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_CUSTOMER_SQL);) {
            statement.setString(1, customer.getCustomer_type_id());
            statement.setString(2, customer.getCustomer_name());
            statement.setString(3, customer.getCustomer_birthday());
            statement.setString(4, customer.getCustomer_gender());
            statement.setString(5, customer.getCustomer_id_card());
            statement.setString(6, customer.getCustomer_phone());
            statement.setString(7, customer.getCustomer_email());
            statement.setString(8, customer.getCustomer_address());
            statement.setString(9, customer.getCustomer_id());
            rowUpdate = statement.executeUpdate() > 0;
        }
        return rowUpdate;
    }

    public List<Customer> search(String name) throws SQLException {
        List<Customer> customers = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_SQL);) {
            preparedStatement.setString(1, name);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String customer_id = rs.getString("customer_id");
                String customer_type_id = rs.getString("customer_type_id");
                String customer_name = rs.getString("customer_name");
                String customer_birthday = rs.getString("customer_birthday");
                String customer_gender = rs.getString("customer_gender");
                String customer_id_card = rs.getString("customer_id_card");
                String customer_phone = rs.getString("customer_phone");
                String customer_email = rs.getString("customer_email");
                String customer_address = rs.getString("customer_address");
                customers.add(new Customer(customer_id, customer_type_id, customer_name, customer_birthday, customer_gender
                        , customer_id_card, customer_phone, customer_email, customer_address));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return customers;
    }
    private void selectCustomerService(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        try(Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(SELECT_CUSTOMER_SERVICE)){

        }
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

