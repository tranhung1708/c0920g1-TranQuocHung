package CaseStudy.Model.Rent_type;

import CaseStudy.Model.Service_type.Service_type;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Rent_typeRepository {
    private String jdbcURL = "jdbc:mysql://localhost:3306/case_study2";
    private String jdbcUsername = "root";
    private String jdbcPassword = "17082019hH";

    private static final String SELECT_ALL_RENT_TYPE_ID = "select * from rent_type";

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

    public List<Rent_type> selectAllRent_type() {
        List<Rent_type> rent_typeList = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_ALL_RENT_TYPE_ID)) {
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int rent_type_id = rs.getInt("rent_type_id");
                String rent_type_name = rs.getString("rent_type_name");
                String rent_type_cost = rs.getString("rent_type_cost");
                rent_typeList.add(new Rent_type(rent_type_id,rent_type_name,rent_type_cost));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rent_typeList;
    }
}
