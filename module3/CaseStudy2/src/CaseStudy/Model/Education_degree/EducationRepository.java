package CaseStudy.Model.Education_degree;

import CaseStudy.Model.Customer_type.CustomerType;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EducationRepository {
    private String jdbcURL = "jdbc:mysql://localhost:3306/case_study2";
    private String jdbcUsername = "root";
    private String jdbcPassword = "17082019hH";

    private static final String SELECT_EDUCATION = "select * from education_degree";

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
    public List<Education_degree> selectAllEducation(){
        List<Education_degree> education_degreeList = new ArrayList<>();
        try(Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(SELECT_EDUCATION)){
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                int education_degree_id = rs.getInt("education_degree_id");
                String education_degree_name = rs.getString("education_degree_name");
                education_degreeList.add(new Education_degree(education_degree_id,education_degree_name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return education_degreeList;
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
