package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import entity.User;
import sql.connection.DBConnection;

public class UserDAO {
	static Scanner input = new Scanner(System.in);

	public User register(String username, String password, String full_name, String gender, String []hobbies) {
	    try (Connection connection = DBConnection.makeConnection();
	         PreparedStatement pstmtInsert = connection.prepareStatement("INSERT INTO user (username, password, full_name, gender, hobbies) VALUES (?, ?, ?, ?, ?)");
	         ) {

	        pstmtInsert.setString(1, username);
	        pstmtInsert.setString(2, password);
	        pstmtInsert.setString(3, full_name);
	        pstmtInsert.setString(4, gender);
	        pstmtInsert.setString(5, hobbies != null ? String.join(",", hobbies) : null); 

	        int rowsAffected = pstmtInsert.executeUpdate();

	        if (rowsAffected > 0) {
	        	return new User(username, password, full_name, gender, hobbies);

	           
	                }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return null;
	}






	public User getUserByUsernameAndPassword(String username, String password) throws SQLException {
		Connection connection = DBConnection.makeConnection();
		String SQLString = "SELECT * FROM user WHERE username = ? AND password = ?";
		PreparedStatement login = connection.prepareStatement(SQLString);
		login.setString(1, username);
		login.setString(2, password);
		ResultSet resultSet = login.executeQuery();

		if (resultSet.next()) {
			int id = resultSet.getInt("id");
			return new User(username, password);
		}

		return null;
	}
}
