package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDAO;
import entity.User;

/**
 * Servlet implementation class AuthenticationController
 */
@WebServlet("/AuthenticationController")
public class AuthenticationController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AuthenticationController() {
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

			switch (action) {
			case "LOGIN": {
				login(request, response);
				break;
			}
			case "LOGOUT": {
				logout(request, response);
				break;
			}
			case "REGISTER": {
				register(request, response);
				break;
			}

			}

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

	private void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		String first_name = request.getParameter("first_name");
		String last_name = request.getParameter("last_name");
		String user_name = request.getParameter("user_name");
		String password = request.getParameter("password");
		String email = request.getParameter("email");

		UserDAO userDao = new UserDAO();

		User user = userDao.getUserByUsernameAndPassword(user_name, password, email, first_name, last_name);

		if (user == null) {
			response.sendRedirect("login.jsp");

		} else {
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			response.sendRedirect("HomeController");

		}
	}

	private void logout(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {

		HttpSession session = request.getSession(false);
		session.removeAttribute("user_name");
		session.removeAttribute("password");
		response.sendRedirect("login.jsp");

	}

	private void register(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {

		String first_name = request.getParameter("first_name");
		String last_name = request.getParameter("last_name");
		String user_name = request.getParameter("user_name");
		String password = request.getParameter("password");
		String email = request.getParameter("email");

		UserDAO userDao = new UserDAO();
		User newUser = userDao.register(user_name, password, email, first_name, last_name);

		if (newUser != null) {

			HttpSession session = request.getSession();
			session.setAttribute("user", newUser);
			response.sendRedirect("login.jsp");
		} else {
			response.sendRedirect("registration.jsp");
		}
	}
}
