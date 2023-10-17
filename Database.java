package coding.mentor.database;

import java.util.ArrayList;
import java.util.Date;

import coding.mentor.data.Course;
import coding.mentor.data.Mentor;
import coding.mentor.data.User;

public class Database {
public static ArrayList<Mentor> MENTORS_DB = new ArrayList<Mentor>();
public static ArrayList<Course> COURSES_DB = new ArrayList<Course>();
public static ArrayList<User> USERS_DB = new ArrayList<User>();

public static void initDB() {
	// initialize Mentor DB
	MENTORS_DB.add(new Mentor(1, "Dung", "dung@gmail","0414878923"));
	MENTORS_DB.add(new Mentor(2, "Jayden", "Jayden@gmail","0414878934"));
	MENTORS_DB.add(new Mentor(3, "Tony", "Tonyg@gmail","0414820923"));
	
	// Initialize COurses DB
	ArrayList<Mentor> teachingMentors = new ArrayList<Mentor>();
	teachingMentors.add(MENTORS_DB.get(0));
	COURSES_DB.add(new Course(1, "BE 1", teachingMentors, new Date(2023 , 9, 21), new Date(2024, 2, 13), 3000 ));
	
	teachingMentors = new ArrayList<Mentor>();
	teachingMentors.add(MENTORS_DB.get(0));
	teachingMentors.add(MENTORS_DB.get(1));
	COURSES_DB.add(new Course(2, "DA 1", teachingMentors, new Date(2023 , 10, 12), new Date(2024 , 3, 21), 3100 ));
	
	teachingMentors = new ArrayList<Mentor>();
	teachingMentors.add(MENTORS_DB.get(2));
	COURSES_DB.add(new Course(3, "BE 7", teachingMentors, new Date(2023, 9, 14), new Date(2024 , 1, 15), 2000 ));
	
	
}
	
}


