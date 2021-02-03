package CaseStudy.Model.Attach_service;

import CaseStudy.Model.Position.Position;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Attach_serviceRepository {
    private String jdbcURL = "jdbc:mysql://localhost:3306/case_study2";
    private String jdbcUsername = "root";
    private String jdbcPassword = "17082019hH";

    private static final String SELECT_ALL_ATTACH_SERVICE = "select * from attach_service";

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

    public List<Attach_service> selectAllAttachService() {
        List<Attach_service> attach_serviceList = new ArrayList<>();
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(SELECT_ALL_ATTACH_SERVICE)) {
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int attach_service_id = rs.getInt("attach_service_id");
                String attach_service_name = rs.getString("attach_service_name");
                String attach_service_cost = rs.getString("attach_service_cost");
                int attach_service_unit = rs.getInt("attach_service_unit");
                String attach_service_status = rs.getString("attach_service_status");
                attach_serviceList.add(new Attach_service(attach_service_id,attach_service_name,
                        attach_service_cost,attach_service_unit,attach_service_status));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return attach_serviceList;
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
