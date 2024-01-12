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

	public String register(User user) throws SQLException {
		Connection connection = DBConnection.makeConnection();
		String SQL = "INSERT INTO user ( username, password, email, first_name, last_name) VALUES ( ?, ?, ?, ?, ?)";

		try (PreparedStatement pstmt = connection.prepareStatement(SQL)) {
			pstmt.setString(1, user.getUserName());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getEmail());
			pstmt.setString(4, user.getFirstName());
			pstmt.setString(5, user.getLastName());

			int rowsAffected = pstmt.executeUpdate();

			if (rowsAffected > 0) {
				return "Registered";
			} else {
				return "Not Registered";
			}
		}

	}

	public boolean login(User user) throws SQLException {
	    Connection connection = DBConnection.makeConnection();
	    String SQLString = "SELECT * FROM user WHERE username = ? AND password = ?";

	    try (PreparedStatement login = connection.prepareStatement(SQLString)) {
	        login.setString(1, user.getUserName());
	        login.setString(2, user.getPassword());

	        try (ResultSet resultSet = login.executeQuery()) {
	            return resultSet.next(); 
	        }
	    } 
	}
public User getUserByUsernameAndPassword(String username, String password) throws SQLException {
	 Connection connection = DBConnection.makeConnection();
	 String SQLString = "SELECT * FROM user WHERE username = ? AND password = ?";
	 PreparedStatement login = connection.prepareStatement(SQLString);
	 login.setString(1, username);
     login.setString(2, password);
     ResultSet resultSet = login.executeQuery();
     
     if(resultSet.next()) {
    	 int id = resultSet.getInt("id");
    	 return new User(id, username, password, SQLString, SQLString, SQLString);
     }
     
	 return null;
}
}
