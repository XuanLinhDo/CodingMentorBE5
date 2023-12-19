package demo.connection.mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CourseService {
	public static List<Course> getAllCourses() throws SQLException {
		Connection connection = DBConnection.makeConnection();
		String SQL = "SELECT * FROM course";

		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery(SQL);

		List<Course> list = new ArrayList<Course>();

		while (rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			Course course = new Course(id, name);
			list.add(course);
		}
		return list;
	}

	public static void showCourseDetail() throws SQLException {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the course ID to view details");
		int selectedCourseId = input.nextInt();
		input.nextLine();
		
		Connection connection = DBConnection.makeConnection();
		String SQL = "SELECT * FROM course_detail WHERE course_id = " + selectedCourseId;

		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery(SQL);

		while (rs.next()) {
			System.out.print(" Course ID : " + rs.getInt("course_id"));
			System.out.print(" Course Name : " + rs.getString("course_name"));
			System.out.print(" Start Date : " + rs.getDate("start_date"));
			System.out.println(" End Date : " + rs.getDate("end_date"));
			System.out.print(" Fee : " + rs.getString("fee"));
			System.out.print(" Mentor Name : " + rs.getString("mentor_name"));
		}
	}
}