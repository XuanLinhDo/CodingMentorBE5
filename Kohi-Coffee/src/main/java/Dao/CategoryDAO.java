package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Category;
import DBConnection.DBConnection;

public class CategoryDAO {
	public List<Category> getAllCategories() throws SQLException {
		Connection connection = DBConnection.makeConnection();

		Statement stmt = connection.createStatement();
		String SQL = "SELECT * FROM category ORDER BY priority";

		ResultSet rs = stmt.executeQuery(SQL);

		List<Category> list = new ArrayList<Category>();

		while (rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			int priority = rs.getInt("priority");
			Category category = new Category(id, name, priority);
			list.add(category);
		}
		return list;

	}

	public List<Category> getCategoryById(String categoryId) throws SQLException {
		Connection connection = DBConnection.makeConnection();
		String SQL = "SELECT * FROM category WHERE id = ?";

		try (PreparedStatement pstmt = connection.prepareStatement(SQL)) {
			pstmt.setString(1, categoryId);
			ResultSet rs = pstmt.executeQuery();

			List<Category> list = new ArrayList<>();
// using while will be waste of time complexity so better use if
			if (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int priority = rs.getInt("priority");
				Category category = new Category(id, name, priority);
				list.add(category);
			}
			return list;
		}
	}
}
