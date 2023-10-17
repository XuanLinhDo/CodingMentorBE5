package be5.day71;

import java.util.ArrayList;
import java.util.Scanner;

import coding.mentor.data.User;
import coding.mentor.data.Course;
import coding.mentor.database.Database;
import coding.mentor.service.CourseService;
import coding.mentor.service.UserService;

public class Main {
	final static int REGISTER = 1;
	final static int BACK_TO_COURSE_LIST = 2;
	final static int VIEW_MENTOR_DETAIL = 3;

	public static void main(String[] args) {
		CourseService courseService = new CourseService();
		UserService userService = new UserService();
		Database.initDB();
		Scanner input = new Scanner(System.in);
		boolean isKeepLoop = false;

		do {
			doLoginAndRegisterByUserInput();
		} while (isKeepLoop);

		boolean isMainMenu = false;
		do {
			mainMenu();
		} while (isMainMenu);
	}

	public static boolean doLoginAndRegisterByUserInput() {
		Scanner input = new Scanner(System.in);
		int loginAttempts = 0;
		int maxAttempts = 3;
		int option;
		do {
			System.out.println("1. Login");
			System.out.println("2. Register");
			System.out.println(" Choose your option. If you do not have account with us, please click register! ");

			option = input.nextInt();
			input.nextLine();

			if (option == 1) {

				System.out.println("-----Login-----");

				while (loginAttempts < maxAttempts) {
					System.out.println("ID: ");
					String id = input.nextLine();

					System.out.println("Password: ");
					String password = input.nextLine();
					boolean currentUser = UserService.login(id, password);
					if (currentUser) {

						return false;
					} else {
						System.out.println("Login failed. Invalid ID or password.");
						loginAttempts++;
						System.out.println("Remaning login attempts: " + (maxAttempts - loginAttempts));
						if (loginAttempts >= maxAttempts) {
							System.out.println("Login attempts exceeded. Account locked.");
							return false;
						}
					}
				}
			}

			else if (option == 2) {

				System.out.println("-----Register-----");

				System.out.println("ID: ");
				String id = input.nextLine();

				System.out.println("Password: ");
				String password = input.nextLine();

				System.out.println("Name: ");
				String name = input.nextLine();
				UserService.registerNewUser(id, password, name);
			}
		} while (true);

	}

	public static void mainMenu() {
		Scanner input = new Scanner(System.in);
		int userChoice;
		do {
			CourseService.showAllCourse();
			System.out.println("Please select options.");
			userChoice = input.nextInt();
			input.nextLine();
			if (userChoice == 1) {

				CourseService.showCourseDetail(null, userChoice - 1);
				int option;
				option = input.nextInt();
				input.nextLine();
				switch (option) {
				case REGISTER:
					UserService.registerNewCourse(null);
					break;
				case BACK_TO_COURSE_LIST:
					System.out.println("Thank for viewing our course.");

					break;
				case VIEW_MENTOR_DETAIL:
					CourseService.showMentorByCourse(null, userChoice - 1);
					break;
				}
			}
			if (userChoice == 2) {

				CourseService.showCourseDetail(null, userChoice - 1);
				int option;
				option = input.nextInt();
				input.nextLine();
				switch (option) {
				case REGISTER:
					UserService.registerNewCourse(null);
					break;
				case BACK_TO_COURSE_LIST:
					System.out.println("Thank for viewing our course.");

					break;
				case VIEW_MENTOR_DETAIL:
					CourseService.showMentorByCourse(null, userChoice - 1);
					break;
				}
			}
			if (userChoice == 3) {

				CourseService.showCourseDetail(null, userChoice - 1);
				int option;
				option = input.nextInt();
				input.nextLine();
				switch (option) {
				case REGISTER:
					UserService.registerNewCourse(null);
					break;
				case BACK_TO_COURSE_LIST:
					System.out.println("Thank for viewing our course.");

					break;
				case VIEW_MENTOR_DETAIL:
					CourseService.showMentorByCourse(null, userChoice - 1);
					break;
				}
			}
			if (userChoice == 0) {
				UserService.showRegisteredCoursesByUser(null);
			}
		} while (userChoice != 4);

	}

}
