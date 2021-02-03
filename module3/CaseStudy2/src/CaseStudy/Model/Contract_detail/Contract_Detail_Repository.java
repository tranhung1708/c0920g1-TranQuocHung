package CaseStudy.Model.Contract_detail;

import CaseStudy.Model.Employee.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Contract_Detail_Repository {
    private String jdbcURL = "jdbc:mysql://localhost:3306/case_study2";
    private String jdbcUsername = "root";
    private String jdbcPassword = "17082019hH";

    private static final String INSERT_CONTRACT_DETAIL_SQL = "INSERT INTO contract_detail" + " (contract_detail_id,contract_id," +
            "attach_service_id,quantity)VALUE" +
            "(?,?,?,?);";
    private static final String SELECT_CONTRACT_DETAIL_BY_ID = "select * from contract_detail where contract_detail_id = ?";
    private static final String SELECT_ALL_CONTRACT_DETAIL = "select * from contract_detail";
    private static final String DELETE_CONTRACT_DETAIL_SQL = "delete from contract_detail where contract_detail_id = ?;";
    private static final String UPDATE_CONTRACT_DETAIL_SQL = "update contract_detail set  contract_id = ?," +
            " attach_service_id= ?, quantity = ? where contract_detail_id = ?";
    private static final String SEARCH_SQL = "select * from contract_detail where contract_detail_id like '%' ? '%';";


    public Contract_Detail_Repository() {
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

    public void insertContract_detail(Contract_detail contract_detail) throws SQLException {
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CONTRACT_DETAIL_SQL)) {
            preparedStatement.setString(1, contract_detail.getContract_detail_id());
            preparedStatement.setString(2, contract_detail.getContract_id());
            preparedStatement.setString(3, contract_detail.getAttach_service_id());
            preparedStatement.setString(4, contract_detail.getQuantity());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public Contract_detail selectContract_detail(int id) {
        Contract_detail contract_detail = null;
        try (Connection connection = getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CONTRACT_DETAIL_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String contract_detail_id = rs.getString("contract_detail_id");
                String contract_id = rs.getString("contract_id");
                String attach_service_id = rs.getString("attach_service_id");
                String quantity = rs.getString("quantity");
                contract_detail = new Contract_detail(contract_detail_id, contract_id, attach_service_id, quantity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contract_detail;
    }

    public List<Contract_detail> selectAllContract_detail() {
        List<Contract_detail> contract_detailList = new ArrayList<>();
        try {
            try (Connection connection = getConnection()) {
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CONTRACT_DETAIL);
                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()) {
                    String contract_detail_id = rs.getString("contract_detail_id");
                    String contract_id = rs.getString("contract_id");
                    String attach_service_id = rs.getString("attach_service_id");
                    String quantity = rs.getString("quantity");
                    contract_detailList.add(new Contract_detail(contract_detail_id, contract_id, attach_service_id, quantity));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contract_detailList;
    }

    public boolean deleteContract(int id) throws SQLException {
        boolean rowDelete;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_CONTRACT_DETAIL_SQL)) {
            statement.setInt(1, id);
            rowDelete = statement.executeUpdate() > 0;
        }
        return rowDelete;
    }

    public boolean updateContract(Contract_detail contract_detail) throws SQLException {
        boolean rowUpdate;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_CONTRACT_DETAIL_SQL)) {
            statement.setString(1, contract_detail.getContract_id());
            statement.setString(2, contract_detail.getAttach_service_id());
            statement.setString(3, contract_detail.getQuantity());
            statement.setString(4, contract_detail.getContract_detail_id());
            rowUpdate = statement.executeUpdate() > 0;
        }
        return rowUpdate;
    }

    public List<Contract_detail> search(String id) throws SQLException{
        List<Contract_detail> contract_detailList = new ArrayList<>();
        try {
            try (Connection connection = getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_SQL)) {
                preparedStatement.setString(1,id);
                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()) {
                    String contract_detail_id = rs.getString("contract_detail_id");
                    String contract_id = rs.getString("contract_id");
                    String attach_service_id = rs.getString("attach_service_id");
                    String quantity = rs.getString("quantity");
                    contract_detailList.add(new Contract_detail(contract_detail_id, contract_id, attach_service_id, quantity));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contract_detailList;
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
