package coding.mentor.service;

import java.util.ArrayList;
import java.util.Collection;

import coding.mentor.data.Course;
import coding.mentor.data.Mentor;
import coding.mentor.data.User;
import coding.mentor.database.Database;

public class UserService {
	public static void registerNewUser(String id, String password, String name) {
		if (isUserIdTaken(id)) {
			System.out.println("Registration failed. ID already in use.");
		} else {
			User user = new User(id, password, name);
			Database.USERS_DB.add(user);
			System.out.println("Registration successful!");
		}
	}

	public static boolean isUserIdTaken(String id) {
		for (User user : Database.USERS_DB) {
			if (user.getId().equals(id)) {
				return true;
			}
		}
		return false;
	}

	public static boolean login(String id, String password) {

		for (User user : Database.USERS_DB) {

			if (user.getId().equals(id) && user.getPassword().equals(password)) {
				System.out.println("Login successful!");
				return true;
			}
		}

		return false;
	}

		public static void showRegisteredCoursesByUser(User user) {
			if (user != null) {
	            if (user.getRegisteredCourses().isEmpty()) {
	                System.out.println(user.getName() + " hasn't registered for any courses yet.");
	            } else {
	                System.out.println(user.getName() + " has registered for the following courses:");
	                for (Course course : user.getRegisteredCourses()) {
	                    System.out.println(course.getName());
	                }
	            }
	        } else {
	            System.out.println("User not found.");
	        }
	    
		}

	

	public static void registerNewCourse(Course course) {
		System.out.println("You've registered successfully.");
	}

}
