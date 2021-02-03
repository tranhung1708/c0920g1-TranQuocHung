package Model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BenhNhanRepository {
    private String jdbcURL = "jdbc:mysql://localhost:3306/thi_module_3";
    private String jdbcUsername = "root";
    private String jdbcPassword = "17082019hH";

    private static final String SELECT_CUSTOMER_BY_ID = "select * from customer where customer_id = ?";
    private static final String SELECT_ALL_CUSTOMER = "select * from customer";
    private static final String DELETE_CUSTOMER_SQL = "delete from customer where customer_id = ?;";
    private static final String UPDATE_CUSTOMER_SQL = "update customer set  customer_type_id = ?, customer_name= ?, customer_birthday = ?,customer_gender = ?,customer_id_card = ?, customer_phone = ?,customer_email= ?,customer_address = ? where customer_id = ?";
    private static final String SEARCH_SQL = "select * from customer where customer_name like '%' ? '%';";
    private static final String INSERT_CUSTOMER_SQL = "INSERT INTO customer(customer_id,customer_type_id,customer_name,customer_birthday,customer_gender,customer_id_card,customer_phone,customer_email,customer_address) VALUE(?,?,?,?,?,?,?,?,?);";

    public BenhNhanRepository() {
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

    public void insertBenh_nhan(Benh_nhan benh_nhan) throws SQLException {
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CUSTOMER_SQL)) {
            preparedStatement.setInt(1, benh_nhan.getMa_benh_nhan());
            preparedStatement.setString(2, benh_nhan.getTen_benh_nhan());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public Benh_nhan selectBenh_nhan(String id) {
        Benh_nhan benh_nhan = null;
        try (Connection connection = getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CUSTOMER_BY_ID);
            preparedStatement.setString(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int  ma_benh_nhan = rs.getInt("ma_benh_nhan");
                String ten_benh_nhan = rs.getString("ten_benh_nhan");
                benh_nhan = new Benh_nhan(ma_benh_nhan,ten_benh_nhan);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return benh_nhan;
    }

    public List<Benh_nhan> selectAllBenh_nhan() {
        List<Benh_nhan> benh_nhanList = new ArrayList<>();
        try (Connection connection = getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CUSTOMER);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int ma_benh_nhan = rs.getInt("ma_benh_nhan");
                String ten_banh_nhan = rs.getString("ten_banh_nhan");
                benh_nhanList.add(new Benh_nhan(ma_benh_nhan,ten_banh_nhan));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return benh_nhanList;
    }

    public boolean deleteBenh_nhan(String id) throws SQLException {
        boolean rowDelete;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_CUSTOMER_SQL);) {
            statement.setString(1, id);
            rowDelete = statement.executeUpdate() > 0;
        }
        return rowDelete;
    }

    public boolean updateBenh_nhan(Benh_nhan benh_nhan) throws SQLException {
        boolean rowUpdate;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_CUSTOMER_SQL);) {
            statement.setString(1, benh_nhan.getTen_benh_nhan());
            statement.setInt(2, benh_nhan.getMa_benh_nhan());
            rowUpdate = statement.executeUpdate() > 0;
        }
        return rowUpdate;
    }

    public List<Benh_nhan> search(String name) throws SQLException {
        List<Benh_nhan> benh_nhanList = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_SQL);) {
            preparedStatement.setString(1, name);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int ma_benh_nhan = rs.getInt("ma_benh_nhan");
                String ten_benh_nhan = rs.getString("ten_benh_nhan");
                benh_nhanList.add(new Benh_nhan(ma_benh_nhan,ten_benh_nhan));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return benh_nhanList;
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
