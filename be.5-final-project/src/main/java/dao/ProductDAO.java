package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import entity.Product;
import sql.connection.DBConnection;

public class ProductDAO {

	public List<Product> getLastestProducts() throws SQLException {
		Connection connection = DBConnection.makeConnection();

		Statement stmt = connection.createStatement();
		String SQL = "SELECT * FROM products WHERE is_new = 1";

		ResultSet rs = stmt.executeQuery(SQL);

		List<Product> list = new ArrayList<Product>();

		while (rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			int price = rs.getInt("price");
			String imgName = rs.getString("img_name");
			boolean isNew = rs.getBoolean("is_new");
			int quantity = rs.getInt("quantity");
			String description = rs.getString("description");
			Product product = new Product(id, name, price, imgName, isNew, quantity, description);
			list.add(product);
		}
		return list;

	}

	public List<Product> getProductById(String productId) throws SQLException {
		Connection connection = DBConnection.makeConnection();
		String SQL = "SELECT * FROM products WHERE id = ?";

		try (PreparedStatement pstmt = connection.prepareStatement(SQL)) {
			pstmt.setString(1, productId);
			ResultSet rs = pstmt.executeQuery();

			List<Product> list = new ArrayList<>();

			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int price = rs.getInt("price");
				String imgName = rs.getString("img_name");
				boolean isNew = rs.getBoolean("is_new");
				int quantity = rs.getInt("quantity");
				String description = rs.getString("description");
				Product product = new Product(id, name, price, imgName, isNew, quantity, description);
				list.add(product);
			}
			return list;
		}
	}

}
