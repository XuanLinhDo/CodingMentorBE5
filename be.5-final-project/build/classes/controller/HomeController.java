package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CategoryDAO;
import dao.ProductDAO;
import entity.Category;
import entity.Product;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("/HomeController")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProductDAO productDAO = new ProductDAO();
	CategoryDAO categoryDao = new CategoryDAO();
	List<Product> products;
	List<Category> categories;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HomeController() {
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

			String action = request.getParameter("action");
			if (action == null) {
				action = "DEFAULT";
			}

			switch (action) {
			case "SHOW_PRODUCT_BY_CATEGORY": {
				String categoryId = request.getParameter("categoryId");
				products = productDAO.getProductsByCategoryId(categoryId);
				break;
			}

			case "SHOW_ALL": {
				products = productDAO.getAllProducts();

				break;
			}
			case "SEARCH": {
				String searchValue = request.getParameter("searchValue");
				products = productDAO.search(searchValue);

				break;
			}
			default:
				products = productDAO.getLastestProducts();

			}
			categories = categoryDao.getAllCategories();
			dispatchAttributeToView(request, response);

		} catch (SQLException e) {
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

	private void dispatchAttributeToView(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
		request.setAttribute("products", products);
		request.setAttribute("categories", categories);
		rd.forward(request, response);
	}

}
