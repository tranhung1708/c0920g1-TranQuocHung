package Model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BenhAnRepository {
    private String jdbcURL = "jdbc:mysql://localhost:3306/thi_module_3";
    private String jdbcUsername = "root";
    private String jdbcPassword = "17082019hH";

    private static final String SELECT_BENHAN_BY_ID = "select * from benh_an where ma_benh_an = ?";
    private static final String SELECT_ALL_BENHAN = "select * from benh_an";
    private static final String DELETE_BENH_AN_SQL = "delete from benh_an where ma_benh_an = ?;";
    private static final String UPDATE_BENH_AN_SQL = "update benh_an set  ma_benh_nhan = ?, ngay_nhap_vien= ?, ngay_ra_vien = ?,ly_do_nhap_vien = ? where ma_benh_an = ?";
    private static final String SEARCH_SQL = "select * from benh_an where ma_benh_nhan like '%' ? '%';";
    private static final String INSERT_CUSTOMER_SQL = "INSERT INTO benh_an(ma_benh_an,ma_benh_nhan,ngay_nhap_vien,ngay_ra_vien,ly_do_nhap_vien) VALUE(?,?,?,?,?);";
    public BenhAnRepository(){}

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

    public void insertBenhAn(Benh_an benh_an) throws SQLException {
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CUSTOMER_SQL)) {
            preparedStatement.setString(1, benh_an.getMa_benh_an());
            preparedStatement.setString(2, benh_an.getMa_benh_nhan());
            preparedStatement.setString(3, benh_an.getNgay_nhap_vien());
            preparedStatement.setString(4, benh_an.getNgay_ra_vien());
            preparedStatement.setString(5, benh_an.getLy_do_nhap_vien());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public Benh_an selectBenhAn(String id) {
        Benh_an benh_an = null;
        try (Connection connection = getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BENHAN_BY_ID);
            preparedStatement.setString(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String ma_benh_an = rs.getString("ma_benh_an");
                String ma_benh_nhan = rs.getString("ma_benh_nhan");
                String ngay_nhap_vien = rs.getString("ngay_nhap_vien");
                String ngay_ra_vien = rs.getString("ngay_ra_vien");
                String ly_do_nhap_vien = rs.getString("ly_do_nhap_vien");
                benh_an = new Benh_an(ma_benh_an,ma_benh_nhan,ngay_nhap_vien,ngay_ra_vien,ly_do_nhap_vien);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return benh_an;
    }

    public List<Benh_an> selectAllBenhAn() {
        List<Benh_an> benh_anList = new ArrayList<>();
        try (Connection connection = getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BENHAN);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String ma_benh_an = rs.getString("ma_benh_an");
                String ma_benh_nhan = rs.getString("ma_benh_nhan");
                String ngay_nhap_vien = rs.getString("ngay_nhap_vien");
                String ngay_ra_vien = rs.getString("ngay_ra_vien");
                String ly_do_nhap_vien = rs.getString("ly_do_nhap_vien");
                benh_anList.add(new Benh_an(ma_benh_an,ma_benh_nhan,ngay_nhap_vien,ngay_ra_vien,ly_do_nhap_vien));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return benh_anList;
    }

    public boolean deleteBenhAn(String id) throws SQLException {
        boolean rowDelete;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_BENH_AN_SQL);) {
            statement.setString(1, id);
            rowDelete = statement.executeUpdate() > 0;
        }
        return rowDelete;
    }

    public boolean updateBenhAn(Benh_an benh_an) throws SQLException {
        boolean rowUpdate;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_BENH_AN_SQL);) {
            statement.setString(1, benh_an.getMa_benh_nhan());
            statement.setString(2, benh_an.getNgay_nhap_vien());
            statement.setString(3, benh_an.getNgay_ra_vien());
            statement.setString(4, benh_an.getLy_do_nhap_vien());
            statement.setString(5, benh_an.getMa_benh_an());
            rowUpdate = statement.executeUpdate() > 0;
        }
        return rowUpdate;
    }

    public List<Benh_an> search(String name) throws SQLException {
        List<Benh_an> benh_anList = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_SQL);) {
            preparedStatement.setString(1, name);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String ma_benh_an = rs.getString("ma_benh_an");
                String ma_benh_nhan = rs.getString("ma_benh_nhan");
                String ngay_nhap_vien = rs.getString("ngay_nhap_vien");
                String ngay_ra_vien = rs.getString("ngay_ra_vien");
                String ly_do_nhap_vien = rs.getString("ly_do_nhap_vien");
                benh_anList.add(new Benh_an(ma_benh_an,ma_benh_nhan,ngay_nhap_vien,ngay_ra_vien,ly_do_nhap_vien));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return benh_anList;
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
