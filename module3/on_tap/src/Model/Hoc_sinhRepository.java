package Model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Hoc_sinhRepository {
    private String jdbcURL = "jdbc:mysql://localhost:3306/ontap";
    private String jdbcUsername = "root";
    private String jdbcPassword = "17082019hH";

    private  static final String SELECT_ALL_HOC_SINH = "select * from hoc_sinh";
    private static final String INSERT_HOC_SINH_SQL = "INSERT INTO hoc_sinh (ma_hoc_sinh,ten_hoc_sinh,lop,ngay_sinh,dia_chi) VALUE(?,?,?,?,?);";
    private static final String SELECT_HOC_SINH_BY_ID = "select * from hoc_sinh where ma_hoc_sinh = ?";
    private static final String DELETE_EMPLOYEE_SQL = "delete from hoc_sinh where ma_hoc_sinh = ?;";
    private static final String UPDATE_HOC_SINH_SQL = "update hoc_sinh set  ten_hoc_sinh = ?, lop= ?, ngay_sinh = ?," +
            "dia_chi = ? where ma_hoc_sinh = ?";
    private static final String SEARCH_SQL = "select * from hoc_sinh where ten_hoc_sinh like '%' ? '%';";

    public Hoc_sinhRepository(){
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


    public void insertEmployee(Hoc_sinh hoc_sinh) throws SQLException {
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_HOC_SINH_SQL)) {
            preparedStatement.setInt(1, hoc_sinh.getMa_hoc_sinh());
            preparedStatement.setString(2, hoc_sinh.getTen_hoc_sinh());
            preparedStatement.setInt(3, hoc_sinh.getLop());
            preparedStatement.setString(4, hoc_sinh.getNgay_sinh());
            preparedStatement.setString(5, hoc_sinh.getDia_chi());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public Hoc_sinh selectHoc_sinh(String id) {
        Hoc_sinh hoc_sinh = null;
        try (Connection connection = getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_HOC_SINH_BY_ID);
            preparedStatement.setString(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int ma_hoc_sinh  = rs.getInt("ma_hoc_sinh");
                String ten_hoc_sinh = rs.getString("ten_hoc_sinh");
                int lop = rs.getInt("lop");
                String ngay_sinh = rs.getString("ngay_sinh");
                String dia_chi = rs.getString("dia_chi");
                hoc_sinh = new Hoc_sinh(ma_hoc_sinh,ten_hoc_sinh,lop,ngay_sinh,dia_chi);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hoc_sinh;
    }

    public List<Hoc_sinh> selectAllHoc_sinh() {
        List<Hoc_sinh> hoc_sinhList = new ArrayList<>();
        try {
            try (Connection connection = getConnection()) {
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_HOC_SINH);
                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()) {
                    int ma_hoc_sinh  = rs.getInt("ma_hoc_sinh");
                    String ten_hoc_sinh = rs.getString("ten_hoc_sinh");
                    int lop = rs.getInt("lop");
                    String ngay_sinh = rs.getString("ngay_sinh");
                    String dia_chi = rs.getString("dia_chi");
                    hoc_sinhList.add(new Hoc_sinh(ma_hoc_sinh,ten_hoc_sinh,lop,ngay_sinh,dia_chi));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hoc_sinhList;
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

    public boolean updateEmployee(Hoc_sinh hoc_sinh) throws SQLException {
        boolean rowUpdate;
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_HOC_SINH_SQL)) {
            preparedStatement.setString(1, hoc_sinh.getTen_hoc_sinh());
            preparedStatement.setInt(2, hoc_sinh.getLop());
            preparedStatement.setString(3, hoc_sinh.getNgay_sinh());
            preparedStatement.setString(4, hoc_sinh.getDia_chi());
            preparedStatement.setInt(5, hoc_sinh.getMa_hoc_sinh());
            rowUpdate = preparedStatement.executeUpdate() > 0;
        }
        return rowUpdate;
    }

    public List<Hoc_sinh> search(String id) throws SQLException{
        List<Hoc_sinh> hoc_sinhList = new ArrayList<>();
        try {
            try (Connection connection = getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_SQL);) {
                preparedStatement.setString(1,id);
                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()) {
                    int ma_hoc_sinh  = rs.getInt("ma_hoc_sinh");
                    String ten_hoc_sinh = rs.getString("ten_hoc_sinh");
                    int lop = rs.getInt("lop");
                    String ngay_sinh = rs.getString("ngay_sinh");
                    String dia_chi = rs.getString("dia_chi");
                    hoc_sinhList.add(new Hoc_sinh(ma_hoc_sinh,ten_hoc_sinh,lop,ngay_sinh,dia_chi));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hoc_sinhList;
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

