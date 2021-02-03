package CaseStudy.Model.Contract;

import CaseStudy.Model.Contract.Contract;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContractRepository {
    private String jdbcURL = "jdbc:mysql://localhost:3306/case_study2";
    private String jdbcUsername = "root";
    private String jdbcPassword = "17082019hH";

    private static final String INSERT_CONTRACT_SQL = "INSERT INTO contract" + " (contract_id,contract_start_date," +
            "contract_end_date,contract_deposit,contract_total_money,employee_id,customer_id,service_id)VALUE" +
            "(?,?,?,?,?,?,?,?);";
    private static final String SELECT_CONTRACT_BY_ID = "select * from contract where contract_id = ?";
    private static final String SELECT_ALL_CONTRACT = "select * from contract";
    private static final String DELETE_CONTRACT_SQL = "delete from contract where contract_id = ?;";
    private static final String UPDATE_CONTRACT_SQL = "update contract set  contract_start_date = ?, contract_end_date= ?, contract_deposit = ?," +
            "contract_total_money = ?,employee_id = ?, customer_id = ?,service_id= ? where contract_id = ?";
    private static final String SEARCH_SQL = "select * from contract where contract_id like '%' ? '%';";

    public ContractRepository() {
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

    public void insertContract(Contract contract) throws SQLException {
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CONTRACT_SQL)) {
            preparedStatement.setString(1, contract.getContract_id());
            preparedStatement.setString(2, contract.getContract_start_date());
            preparedStatement.setString(3, contract.getContract_end_date());
            preparedStatement.setString(4, contract.getContract_deposit());
            preparedStatement.setString(5, contract.getContract_total_money());
            preparedStatement.setString(6, contract.getEmployee_id());
            preparedStatement.setString(7, contract.getCustomer_id());
            preparedStatement.setString(8, contract.getService_id());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public Contract selectContract(String id) {
        Contract contract = null;
        try (Connection connection = getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CONTRACT_BY_ID);
            preparedStatement.setString(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String contract_id = rs.getString("contract_id");
                String contract_start_date = rs.getString("contract_start_date");
                String contract_end_date = rs.getString("contract_end_date");
                String contract_deposit = rs.getString("contract_deposit");
                String contract_total_money = rs.getString("contract_total_money");
                String employee_id = rs.getString("employee_id");
                String customer_id = rs.getString("customer_id");
                String service_id = rs.getString("service_id");
                contract = new Contract(contract_id, contract_start_date, contract_end_date, contract_deposit, contract_total_money,
                        employee_id, customer_id, service_id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contract;
    }

    public List<Contract> selectAllContract() {
        List<Contract> contractList = new ArrayList<>();
        try {
            try (Connection connection = getConnection()) {
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CONTRACT);
                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()) {
                    String contract_id = rs.getString("contract_id");
                    String contract_start_date = rs.getString("contract_start_date");
                    String contract_end_date = rs.getString("contract_end_date");
                    String contract_deposit = rs.getString("contract_deposit");
                    String contract_total_money = rs.getString("contract_total_money");
                    String employee_id = rs.getString("employee_id");
                    String customer_id = rs.getString("customer_id");
                    String service_id = rs.getString("service_id");
                    contractList.add(new Contract(contract_id, contract_start_date, contract_end_date, contract_deposit,
                            contract_total_money, employee_id, customer_id, service_id));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contractList;
    }

   public boolean deleteContract(String id) throws SQLException{
        boolean rowDelete;
        try(Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(DELETE_CONTRACT_SQL)){
            statement.setString(1, id);
            rowDelete = statement.executeUpdate() > 0;
        }
        return rowDelete;
   }

    public boolean updateContract(Contract contract) throws SQLException {
        boolean rowUpdate;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_CONTRACT_SQL)) {
            statement.setString(1, contract.getContract_id());
            statement.setString(2, contract.getContract_start_date());
            statement.setString(3, contract.getContract_end_date());
            statement.setString(4, contract.getContract_deposit());
            statement.setString(5, contract.getContract_total_money());
            statement.setString(6, contract.getEmployee_id());
            statement.setString(7, contract.getCustomer_id());
            statement.setString(8, contract.getService_id());
            rowUpdate = statement.executeUpdate() > 0;
        }
        return rowUpdate;
    }
    public List<Contract> search(String id) throws SQLException{
        List<Contract> contractList = new ArrayList<>();
        try {
            try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_SQL);) {
                preparedStatement.setString(1,id);
                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()) {
                    String contract_id = rs.getString("contract_id");
                    String contract_start_date = rs.getString("contract_start_date");
                    String contract_end_date = rs.getString("contract_end_date");
                    String contract_deposit = rs.getString("contract_deposit");
                    String contract_total_money = rs.getString("contract_total_money");
                    String employee_id = rs.getString("employee_id");
                    String customer_id = rs.getString("customer_id");
                    String service_id = rs.getString("service_id");
                    contractList.add(new Contract(contract_id, contract_start_date, contract_end_date, contract_deposit,
                            contract_total_money, employee_id, customer_id, service_id));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contractList;
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
