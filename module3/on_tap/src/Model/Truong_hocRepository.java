package Model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Truong_hocRepository {
    private String jdbcURL = "jdbc:mysql://localhost:3306/on_tap";
    private String jdbcUsername = "root";
    private String jdbcPassword = "17082019hH";

    private static final String SELECT_ALL_TRUONG_HOC = "select * from truong_hoc";
    private static final String INSERT_HOC_SINH_SQL = "INSERT INTO hoc_sinh" + " (ma_hoc_sinh,ten_hoc_sinh," +
            "lop,ngay_sinh,dia_chi" + "VALUE(?,?,?,?,?);";
    private static final String SELECT_HOC_SINH_BY_ID = "select * from hoc_sinh where ma_hoc_sinh = ?";
    private static final String DELETE_EMPLOYEE_SQL = "delete from hoc_sinh where ma_hoc_sinh = ?;";
    private static final String UPDATE_HOC_SINH_SQL = "update hoc_sinh set  ten_hoc_sinh = ?, lop= ?, ngay_sinh = ?," +
            "dia_chi = ? where ma_hoc_sinh = ?";
    private static final String SEARCH_SQL = "select * from hoc_sinh where ten_hoc_sinh like '%' ? '%';";

    public Truong_hocRepository() {
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

    public void insertTruong_hoc(Truong_hoc truong_hoc) throws SQLException {
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_HOC_SINH_SQL)) {
            preparedStatement.setInt(1, truong_hoc.getMa_truong_hoc());
            preparedStatement.setString(2, truong_hoc.getTen_truong_hoc());
            preparedStatement.setString(3, truong_hoc.getDia_chi());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public Truong_hoc selectTruong_hoc(String id) {
        Truong_hoc truong_hoc = null;
        try (Connection connection = getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_HOC_SINH_BY_ID);
            preparedStatement.setString(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int ma_truong_hoc  = rs.getInt("ma_truong_hoc");
                String ten_truong_hoc = rs.getString("ten_truong_hoc");
                String dia_chi = rs.getString("dia_chi");
                truong_hoc = new Truong_hoc(ma_truong_hoc,ten_truong_hoc,dia_chi);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return truong_hoc;
    }

    public List<Truong_hoc> selectAllTruong_hoc() {
        List<Truong_hoc> truong_hocList = new ArrayList<>();
        try {
            try (Connection connection = getConnection()) {
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_TRUONG_HOC);
                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()) {
                    int ma_truong_hoc  = rs.getInt("ma_truong_hoc");
                    String ten_truong_hoc = rs.getString("ten_truong_hoc");
                    String dia_chi = rs.getString("dia_chi");
                    truong_hocList.add(new Truong_hoc(ma_truong_hoc,ten_truong_hoc,dia_chi));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return truong_hocList;
    }

    public boolean deleteHocSinh(String id) throws SQLException {
        boolean rowDelete;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_EMPLOYEE_SQL)) {
            statement.setString(1, id);
            rowDelete = statement.executeUpdate() > 0;
        }
        return rowDelete;
    }
    public boolean updateTruong_hoc(Truong_hoc truongHoc) throws SQLException {
        boolean rowUpdate;
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_HOC_SINH_SQL)) {
            preparedStatement.setString(1, truongHoc.getTen_truong_hoc());
            preparedStatement.setString(2, truongHoc.getDia_chi());
            preparedStatement.setInt(3, truongHoc.getMa_truong_hoc());
            rowUpdate = preparedStatement.executeUpdate() > 0;
        }
        return rowUpdate;
    }

    public List<Truong_hoc> search(String id) throws SQLException{
        List<Truong_hoc> truong_hocList = new ArrayList<>();
        try {
            try (Connection connection = getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_SQL);) {
                preparedStatement.setString(1,id);
                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()) {
                    int ma_truong_hoc  = rs.getInt("ma_truong_hoc");
                    String ten_truong_hoc = rs.getString("ten_truong_hoc");
                    String dia_chi = rs.getString("dia_chi");
                    truong_hocList.add(new Truong_hoc(ma_truong_hoc,ten_truong_hoc,dia_chi));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return truong_hocList;
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
