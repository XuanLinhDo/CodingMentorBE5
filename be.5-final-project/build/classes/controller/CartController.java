package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CategoryDAO;
import dao.ProductDAO;
import entity.Cart;
import entity.Category;
import entity.Product;

/**
 * Servlet implementation class CartController
 */
@WebServlet("/CartController")
public class CartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CartController() {
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
			String action = request.getParameter("ACTION");

			switch (action) {
			case "ADD_TO_CART": {
				addToCart(request, response);
				break;
			}
			case "VIEW_CART": {
				viewCart(request, response);
				break;
			}

			default:
				break;
			}
		} catch (ServletException | IOException | SQLException e) {
			e.printStackTrace();
		}
	}

	private void addToCart(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		String productId = request.getParameter("productId");

		Cart cart;
		HttpSession session = request.getSession();
		if (session.getAttribute("cart") == null) {
			cart = new Cart();
			cart.setItems(new HashMap<Product, Integer>());
		} else {
			cart = (Cart) session.getAttribute("cart");
		}

		Product product = ProductDAO.getProductById(productId);
		if (cart.getItems().containsKey(productId)) {
			int newQuantity = cart.getItems().get(product) + 1;
			cart.getItems().put(product, newQuantity);
		} else {
			cart.getItems().put(product, 1);
		}
		session.setAttribute("cart", cart);
		response.sendRedirect("ProductController?porductId=" + productId);
	}

	private void viewCart(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {

		HttpSession session = request.getSession();
		Cart cart = (Cart) session.getAttribute("cart");
		if (cart != null) {
			double total = 0.0;
			for (Map.Entry<Product, Integer> entry : cart.getItems().entrySet()) {
				String name = entry.getKey().getName();
				int quantity = entry.getKey().getQuantity();
				double subTotal = entry.getKey().getPrice() * quantity;
				total += subTotal;
			}
			
			request.setAttribute("cart", cart);
			request.setAttribute("total", total);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/view-cart.jsp");
			dispatcher.forward(request, response);
		} else {

			response.sendRedirect("index.jsp");
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
