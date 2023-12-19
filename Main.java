package demo.connection.mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws SQLException {
		Connection connection = DBConnection.makeConnection();
		Scanner input = new Scanner(System.in);
		int option;
		do {
			System.out.println("1. Login");
			System.out.println("2. Register");
			System.out.println(" Choose your option. If you do not have account with us, please click register! ");

			option = input.nextInt();
			input.nextLine();

			if (option == 1) {
				System.out.println("-----Login-----");
				int loginResult = UserService.login();
				if (loginResult == 1) {
					displayCourses();
				}
				break;
			} else if (option == 2) {

				System.out.println("-----Register-----");
				UserService.registration();
			}
		} while (true);
	}

	private static void displayCourses() throws SQLException {
		List<Course> courseList = CourseService.getAllCourses();
		System.out.println("List of Courses:");
		do {
			for (Course course : courseList) {
				System.out.println("ID: " + course.getId() + " || Course: " + course.getName());
			}
			CourseService.showCourseDetail();
			
		} while (true);
	}
}
