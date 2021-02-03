package CaseStudy.Model.Employee;

import CaseStudy.Model.Contract.Contract;
import CaseStudy.Model.Employee.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository {
    private String jdbcURL = "jdbc:mysql://localhost:3306/case_study2";
    private String jdbcUsername = "root";
    private String jdbcPassword = "17082019hH";

    private static final String INSERT_EMPLOYEE_SQL = "INSERT INTO employee" + " (employee_id,employee_name," +
            "employee_brithday,employee_id_card,employee_salary,employee_phone,employee_email,employee_address," +
            "position_id,education_degree_id,division_id,username)VALUE" +
            "(?,?,?,?,?,?,?,?,?,?,?,?);";
    private static final String SELECT_EMPLOYEE_BY_ID = "select * from employee where employee_id = ?";
    private static final String SELECT_ALL_EMPLOYEE = "select * from employee";
    private static final String DELETE_EMPLOYEE_SQL = "delete from employee where employee_id = ?;";
    private static final String UPDATE_EMPLOYEE_SQL = "update employee set  employee_name = ?, employee_brithday= ?, employee_id_card = ?," +
            "employee_salary = ?,employee_phone = ?, employee_email = ?,employee_address= ?,position_id = ?," +
            "education_degree_id = ? ,division_id = ? ,username = ?  where employee_id = ?";
    private static final String SEARCH_SQL = "select * from employee where employee_name like '%' ? '%';";

    public EmployeeRepository() {
    }

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void insertEmployee(Employee employee) throws SQLException {
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_EMPLOYEE_SQL)) {
            preparedStatement.setString(1, employee.getEmployee_id());
            preparedStatement.setString(2, employee.getEmployee_name());
            preparedStatement.setString(3, employee.getEmployee_brithday());
            preparedStatement.setString(4, employee.getEmployee_id_card());
            preparedStatement.setString(5, employee.getEmployee_salary());
            preparedStatement.setString(6, employee.getEmployee_phone());
            preparedStatement.setString(7, employee.getEmployee_email());
            preparedStatement.setString(8, employee.getEmployee_address());
            preparedStatement.setString(9, employee.getPosition_id());
            preparedStatement.setString(10, employee.getEducation_degree_id());
            preparedStatement.setString(11, employee.getDivision_id());
            preparedStatement.setString(12, employee.getUsername());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public Employee selectEmployee(String id) {
        Employee employee = null;
        try (Connection connection = getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_EMPLOYEE_BY_ID);
            preparedStatement.setString(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String employee_id = rs.getString("employee_id");
                String employee_name = rs.getString("employee_name");
                String employee_birthday = rs.getString("employee_brithday");
                String employee_id_card = rs.getString("employee_id_card");
                String employee_salary = rs.getString("employee_salary");
                String employee_phone = rs.getString("employee_phone");
                String employee_email = rs.getString("employee_email");
                String employee_address = rs.getString("employee_address");
                String position_id = rs.getString("position_id");
                String education_degree_id = rs.getString("education_degree_id");
                String division_id = rs.getString("division_id");
                String username = rs.getString("username");
                employee = new Employee(employee_id, employee_name, employee_birthday, employee_id_card, employee_salary
                        , employee_phone, employee_email, employee_address, position_id,education_degree_id, division_id, username);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }

    public List<Employee> selectAllEmployee() {
        List<Employee> employeeList = new ArrayList<>();
        try {
            try (Connection connection = getConnection()) {
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_EMPLOYEE);
                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()) {
                    String employee_id = rs.getString("employee_id");
                    String employee_name = rs.getString("employee_name");
                    String employee_brithday = rs.getString("employee_brithday");
                    String employee_id_card = rs.getString("employee_id_card");
                    String employee_salary = rs.getString("employee_salary");
                    String employee_phone = rs.getString("employee_phone");
                    String employee_email = rs.getString("employee_email");
                    String employee_address = rs.getString("employee_address");
                    String position_id = rs.getString("position_id");
                    String education_degree_id = rs.getString("education_degree_id");
                    String division_id = rs.getString("division_id");
                    String username = rs.getString("username");
                    employeeList.add(new Employee(employee_id, employee_name, employee_brithday, employee_id_card, employee_salary
                            , employee_phone, employee_email, employee_address, position_id,education_degree_id, division_id, username));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeList;
    }

    public boolean deleteEmployee(String id) throws SQLException {
        boolean rowDelete;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_EMPLOYEE_SQL)) {
            statement.setString(1, id);
            rowDelete = statement.executeUpdate() > 0;
        }
        return rowDelete;
    }

    public boolean updateEmployee(Employee employee) throws SQLException {
        boolean rowUpdate;
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_EMPLOYEE_SQL)) {
            preparedStatement.setString(1, employee.getEmployee_name());
            preparedStatement.setString(2, employee.getEmployee_brithday());
            preparedStatement.setString(3, employee.getEmployee_id_card());
            preparedStatement.setString(4, employee.getEmployee_salary());
            preparedStatement.setString(5, employee.getEmployee_phone());
            preparedStatement.setString(6, employee.getEmployee_email());
            preparedStatement.setString(7, employee.getEmployee_address());
            preparedStatement.setString(8, employee.getPosition_id());
            preparedStatement.setString(9, employee.getEducation_degree_id());
            preparedStatement.setString(10, employee.getDivision_id());
            preparedStatement.setString(11, employee.getUsername());
            preparedStatement.setString(12, employee.getEmployee_id());
            rowUpdate = preparedStatement.executeUpdate() > 0;
        }
        return rowUpdate;
    }

    public List<Employee> search(String id) throws SQLException{
        List<Employee> employeeList = new ArrayList<>();
        try {
            try (Connection connection = getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_SQL);) {
                preparedStatement.setString(1,id);
                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()) {
                    String employee_id = rs.getString("employee_id");
                    String employee_name = rs.getString("employee_name");
                    String employee_brithday = rs.getString("employee_brithday");
                    String employee_id_card = rs.getString("employee_id_card");
                    String employee_salary = rs.getString("employee_salary");
                    String employee_phone = rs.getString("employee_phone");
                    String employee_email = rs.getString("employee_email");
                    String employee_address = rs.getString("employee_address");
                    String position_id = rs.getString("position_id");
                    String education_degree_id = rs.getString("education_degree_id");
                    String division_id = rs.getString("division_id");
                    String username = rs.getString("username");
                    employeeList.add(new Employee(employee_id, employee_name, employee_brithday, employee_id_card, employee_salary
                            , employee_phone, employee_email, employee_address, position_id,education_degree_id, division_id, username));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeList;
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
