package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entity.Category;
import entity.Order;
import entity.User;
import sql.connection.DBConnection;

public class OrderDAO {
	public int addOrder(Order order) throws SQLException {
		Connection connection = null;
		PreparedStatement pstmtInsert = null;
		try {
			connection = DBConnection.makeConnection();
			pstmtInsert = connection.prepareStatement("INSERT INTO `order` (user_id, submit_date) VALUES (?, ?)");

			pstmtInsert.setInt(1, order.getUserId());
			pstmtInsert.setDate(2, (java.sql.Date) new Date(System.currentTimeMillis()));
			

			pstmtInsert.execute();

		} finally {
			close(connection, pstmtInsert, null);
		}
		return 0;

	}

	public List<Order> getOrderById(String orderId) throws SQLException {
		Connection connection = DBConnection.makeConnection();
		String SQL = "SELECT * FROM order WHERE id = ?";

		try (PreparedStatement pstmt = connection.prepareStatement(SQL)) {
			pstmt.setString(1, orderId);
			ResultSet rs = pstmt.executeQuery();

			List<Order> list = new ArrayList<>();

			if (rs.next()) {
				int id = rs.getInt("id");
				int user_id = rs.getInt("user_id");
				Date submit_date = rs.getDate("submit_date");
				Order order = new Order(id, user_id, submit_date);
				list.add(order);
			}
			return list;
		}
	}

	private void close(Connection connection, PreparedStatement pstmtInsert, ResultSet rs) {
		try {
			if (connection != null) {
				connection.close();
			}
			if (pstmtInsert != null) {
				pstmtInsert.close();
			}
			if (rs != null) {
				rs.close();
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
	}
}
