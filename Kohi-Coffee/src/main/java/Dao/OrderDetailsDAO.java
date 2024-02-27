package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.OrderDetails;
import DBConnection.DBConnection;

public class OrderDetailsDAO {
	public void addOrderDetails(OrderDetails orderDetails) throws SQLException {
		Connection connection = null;
		PreparedStatement pstmtInsert = null;
        try {
        	connection = DBConnection.makeConnection();
             pstmtInsert = connection.prepareStatement("INSERT INTO `order_details` (order_id, product_id, quantity, price) VALUES (?, ?, ?, ?)");

            pstmtInsert.setInt(1, orderDetails.getOrderId());
            pstmtInsert.setInt(2, orderDetails.getProductId());
            pstmtInsert.setInt(3, orderDetails.getQuantity());
            pstmtInsert.setInt(4, orderDetails.getPrice());

            pstmtInsert.execute();


        } finally  {
          close(connection, pstmtInsert, null);
        }

    }
	public List<OrderDetails> getOrderDetailsByOrderId(String orderId) throws SQLException {
		Connection connection = DBConnection.makeConnection();
		String SQL = "SELECT * FROM order-details WHERE order_id = ?";

		try (PreparedStatement pstmt = connection.prepareStatement(SQL)) {
			pstmt.setString(1, orderId);
			ResultSet rs = pstmt.executeQuery();

			List<OrderDetails> list = new ArrayList<>();

			if (rs.next()) {
				int id = rs.getInt("id");
				int order_id = rs.getInt("order_id");
				int product_id = rs.getInt("product_id");
				int quantity = rs.getInt("quantity");
				int price = rs.getInt("price");
				OrderDetails orderDetails = new OrderDetails(id, order_id, product_id, quantity, price);
				list.add(orderDetails);
			}
			return list;
		}
	}

	private void close(Connection connection, PreparedStatement pstmtInsert, ResultSet rs) {
		try {
			if(connection !=null) {
				connection.close();
			}
			if(pstmtInsert !=null) {
				pstmtInsert.close();
			}
			if(rs !=null) {
				rs.close();
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
	}
}
