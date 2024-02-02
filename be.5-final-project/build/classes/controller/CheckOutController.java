package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.OrderDAO;
import dao.OrderDetailsDAO;
import entity.Order;
import entity.OrderDetails;

/**
 * Servlet implementation class CheckOutController
 */
@WebServlet("/CheckOutController")
public class CheckOutController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CheckOutController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			String orderId = request.getParameter("orderId");
			HttpSession session = request.getSession();
			if (orderId != null) {
				
				OrderDAO orderDAO = new OrderDAO();
				OrderDetailsDAO orderDetailsDAO = new OrderDetailsDAO();

				
				List<OrderDetails> orderDetails = orderDetailsDAO.getOrderDetailsByOrderId(orderId);
				List<Order> order = orderDAO.getOrderById(orderId);

				if (order != null && orderDetails != null) {

					double totalPrice = 0.0;
					for (OrderDetails orderDetail : orderDetails) {
						totalPrice += orderDetail.getSubtotal();
					}

					((Order) order).setTotalPrice(totalPrice);

					session.setAttribute("orderDetails", orderDetails);
					session.setAttribute("order", order);
					request.getRequestDispatcher("/checkout.jsp").forward(request, response);
				} else {
					response.sendRedirect("");
					return;
				}
			}
		}

		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
