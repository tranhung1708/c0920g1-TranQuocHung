package CaseStudy.Model.Division;

import CaseStudy.Model.Position.Position;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DivisionRepository {
    private String jdbcURL = "jdbc:mysql://localhost:3306/case_study2";
    private String jdbcUsername = "root";
    private String jdbcPassword = "17082019hH";

    private static final String SELECT_ALL_DIVISION = "select * from division";

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
    public List<Division> selectDivisionList() {
        List<Division> divisionList = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_ALL_DIVISION)) {
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int division_id = rs.getInt("division_id");
                String division_name = rs.getString("division_name");
                divisionList.add(new Division(division_id,division_name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return divisionList;
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
