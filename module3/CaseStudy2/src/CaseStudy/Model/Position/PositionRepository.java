package CaseStudy.Model.Position;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PositionRepository {
    private String jdbcURL = "jdbc:mysql://localhost:3306/case_study2";
    private String jdbcUsername = "root";
    private String jdbcPassword = "17082019hH";

    private static final String SELECT_ALL_POSITION = "select * from positions";

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

    public List<Position> selectAllPosition() {
        List<Position> positionList = new ArrayList<>();
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(SELECT_ALL_POSITION)) {
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int position_id = rs.getInt("position_id");
                String position_name = rs.getString("position_name");
                positionList.add(new Position(position_id,position_name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return positionList;
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
