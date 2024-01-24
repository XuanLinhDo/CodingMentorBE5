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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String action = request.getParameter("ACTION");

            switch (action) {
                case "ADD_TO_CART": {
                    addToCart(request, response);
                    break; 
                }

                default:
                    break;
            }
        } catch (ServletException | IOException | SQLException e) {
            e.printStackTrace();
        }
    }

	private void addToCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
	String productId = request.getParameter("productId");
	
	Map<String, Integer> shoppingCartItems;
	HttpSession session = request.getSession();
	if(session.getAttribute("cart") == null) {
		shoppingCartItems = new HashMap<>();
	} else {
		shoppingCartItems = (Map<String, Integer>) session.getAttribute("cart");
	}
	   if (shoppingCartItems.containsKey(productId)) {
		   
	        shoppingCartItems.put(productId, shoppingCartItems.get(productId) + 1);
	    } else {
	        shoppingCartItems.put(productId, 1);
	    }
	session.setAttribute("cart", shoppingCartItems);
	
	ProductDAO productDAO = new ProductDAO();
	CategoryDAO categoryDao = new CategoryDAO();
	
	Product product = productDAO.getProductById(productId);
	List<Category> categories = categoryDao.getAllCategories();
	
	for (Map.Entry<String, Integer> entry : shoppingCartItems.entrySet()) {
        String productInCartId = entry.getKey();
        int quantity = entry.getValue();
        System.out.println("Product ID: " + productInCartId + ", Quantity: " + quantity);
    }
	
	
	response.sendRedirect("ProductController?porductId=" + productId);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
