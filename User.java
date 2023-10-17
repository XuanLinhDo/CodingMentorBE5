package coding.mentor.data;

import java.util.ArrayList;

public class User {
String id;
String password;
String name;
static ArrayList<Course> registeredCourses;
public static User registerForCourse;
int failedCount;

public User(String id, String password, String name) {
	super();
	this.id = id;
	this.password = password;
	this.name = name;
	
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public ArrayList<Course> getRegisteredCourses() {
	return registeredCourses;
}
public void setRegisteredCourses(ArrayList<Course> registeredCourses) {
	this.registeredCourses = registeredCourses;
}
public int getFailedCount() {
	return failedCount;
}
public void setFailedCount(int failedCount) {
	this.failedCount = failedCount;
}
public static void registerForCourse(Course course) {
	registeredCourses.add(course);
	System.out.println("You've successfully registered this course");
	
}
}
