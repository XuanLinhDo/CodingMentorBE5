package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDAO;
import entity.User;

/**
 * Servlet implementation class RegistrationControlller
 */
@WebServlet("/RegistrationControlller")
public class RegistrationControlller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegistrationControlller() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String user_name = request.getParameter("user_name");
		String password = request.getParameter("password");
		String full_name = request.getParameter("full_name");
		String gender = request.getParameter("gender");
		String[] hobbies = request.getParameterValues("hobbies");

		UserDAO userDao = new UserDAO();
		User newUser = userDao.register(user_name, password, full_name, gender, hobbies);

		if (newUser != null) {

			if (hobbies != null) {
				for (String hobby : hobbies) {
					if (newUser.getHobbies() == null) {
						newUser.setHobbies(hobby);
					} else {
						newUser.setHobbies(newUser.getHobbies() + ", " + hobby);
					}
				}
			}

			HttpSession session = request.getSession();
			session.setAttribute("user", newUser);
			response.sendRedirect("index.jsp");
		} else {
			response.sendRedirect("registration.jsp");
		}
	}
}
