package coding.mentor.service;

import java.util.ArrayList;
import java.util.Date;

import coding.mentor.data.Course;
import coding.mentor.data.Mentor;
import coding.mentor.database.Database;

public class CourseService {

	public static void showAllCourse() {
		System.out.println();
		System.out.println((0) + ":" + "Your Course");
		System.out.println();
		for (int i = 0; i < Database.COURSES_DB.size(); i++) {
			System.out.println((i + 1) + ":" + Database.COURSES_DB.get(i).getName());
			for (Mentor mentor : Database.COURSES_DB.get(i).getTeachingMentors()) {
				System.out.println("--mentor name: " + mentor.getName());
			}
			System.out.println();
		}
	}

	public static void showCourseDetail(Course course, int i) {

		System.out.println("Course Detail");
		System.out.println("");
		System.out.println("ID: " + Database.COURSES_DB.get(i).getId());
		System.out.println("Name: " + Database.COURSES_DB.get(i).getName());
		for (Mentor mentor : Database.COURSES_DB.get(i).getTeachingMentors()) {
			System.out.println("Mentor name: " + mentor.getName());
		}
		System.out.println("Begin date: " + Database.COURSES_DB.get(i).getBegin());
		System.out.println("End date: " + Database.COURSES_DB.get(i).getEnd());
		System.out.println("Course fee: " + Database.COURSES_DB.get(i).getFee());
		System.out.println("");
		System.out.println("1. Register");
		System.out.println("2. No");
		System.out.println("3. View mentor detail");
	}

	public static void showMentorByCourse(Course course, int j) {
		
		for (Mentor mentor : Database.COURSES_DB.get(j).getTeachingMentors()) {
                System.out.println("Mentor Detail");
				System.out.println("ID: " + mentor.getId());
				System.out.println("Name: " + mentor.getName());	
				System.out.println("Email: " + mentor.getEmail());
				System.out.println("Phone: " + mentor.getPhone());
			}
	}
	
}
