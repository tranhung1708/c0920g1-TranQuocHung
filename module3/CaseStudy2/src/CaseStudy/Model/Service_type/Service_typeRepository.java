package CaseStudy.Model.Service_type;

import CaseStudy.Model.Position.Position;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Service_typeRepository {
    private String jdbcURL = "jdbc:mysql://localhost:3306/case_study2";
    private String jdbcUsername = "root";
    private String jdbcPassword = "17082019hH";

    private static final String SELECT_ALL_SERVICE_TYPE_ID = "select * from service_type";

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
    public List<Service_type> selectAllService_type() {
        List<Service_type> service_typeList = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_ALL_SERVICE_TYPE_ID)) {
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int service_type_id = rs.getInt("service_type_id");
                String service_type_name = rs.getString("service_type_name");
                service_typeList.add(new Service_type(service_type_id,service_type_name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return service_typeList;
    }

}
