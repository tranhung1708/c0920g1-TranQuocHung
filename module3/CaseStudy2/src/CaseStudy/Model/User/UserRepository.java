package CaseStudy.Model.User;

import CaseStudy.Model.Rent_type.Rent_type;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    private String jdbcURL = "jdbc:mysql://localhost:3306/case_study2";
    private String jdbcUsername = "root";
    private String jdbcPassword = "17082019hH";

    private static final String SELECT_ALL_USER = "select * from user";

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
    public List<User> selectAllUser() {
        List<User> userList = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_ALL_USER)) {
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");
                userList.add(new User(username,password));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }
}
