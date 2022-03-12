package register.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import register.model.User;

public class UserDao {
	private String jdbcDriver = "com.mysql.jdbc.Driver";
    private String dbAddress = "jdbc:mysql://localhost:6000/";
    private String dbName = "ppsdb";
    private String userName = "GolamT313";
    private String password = "Gmaster123!";
    
    public int registerUser(User user) throws ClassNotFoundException {
        String INSERT_USERS_SQL = "INSERT INTO users" +
            "  (username, password, firstname, lastname, birthday, streetnumber, street, city, state, zipcode, ppsbalance, bankbalance) VALUES " +
            " (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

        int result = 0;

        Class.forName(jdbcDriver);

        try (Connection connection = DriverManager
            .getConnection(dbAddress + dbName, userName, password);

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getFirstname());
            preparedStatement.setString(4, user.getLastname());
            preparedStatement.setString(5, user.getBirthday());
            preparedStatement.setInt(6, user.getStreetnumber());
            preparedStatement.setString(7, user.getStreet());
            preparedStatement.setString(8, user.getCity());
            preparedStatement.setString(9, user.getState());
            preparedStatement.setInt(10, user.getZipcode());
            preparedStatement.setInt(11, user.getPpsbalance());
            preparedStatement.setDouble(12, user.getBankbalance());
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            result = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            // process sql exception
        	if(e.getSQLState().startsWith("23")) {System.out.println("test");}
            //printSQLException(e);
        }
        return result;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
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