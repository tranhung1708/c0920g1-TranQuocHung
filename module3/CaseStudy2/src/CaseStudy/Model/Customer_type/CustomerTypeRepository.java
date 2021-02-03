package CaseStudy.Model.Customer_type;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerTypeRepository {
    private String jdbcURL = "jdbc:mysql://localhost:3306/case_study2";
    private String jdbcUsername = "root";
    private String jdbcPassword = "17082019hH";

    private static final String SELECT_ALL_CUSTOMER_TYPE = "select * from customer_type";

    public CustomerTypeRepository(){
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

    public List<CustomerType> selectAllCustomerType(){
        List<CustomerType> customerTypeList = new ArrayList<>();
        try(Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(SELECT_ALL_CUSTOMER_TYPE)){
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                String customer_type_id = rs.getString("customer_type_id");
                String customer_type_name = rs.getString("customer_type_name");
                customerTypeList.add(new CustomerType(customer_type_id,customer_type_name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerTypeList;
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
