package be5.day72;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		DatabaseForEmployees.initDB();

		Scanner input = new Scanner(System.in);
		String loggedInToGetDepartmentCode = null;

		while (true) {
			System.out.println("----Login----");
			System.out.print("Id: ");
			String id = input.nextLine();
			System.out.print("Password: ");
			String password = input.nextLine();

			loggedInToGetDepartmentCode = Employee.login(id, password);

			if (loggedInToGetDepartmentCode != null) {
				System.out.println("Login successfully.");
				System.out.println("Your department code: " + loggedInToGetDepartmentCode);
			} else {
				System.out.println("Login failed. Invalid user login or password.");
				continue;
			}
			System.out.println("----HomePage----");
			System.out.println("- Check your info and salary by inputing your deparment code.");
			System.out.println("- Exit.");
			String employeeChoice = input.nextLine();
			String departmentCode = employeeChoice;
			
			if (employeeChoice.equalsIgnoreCase("Exit")) {
				loggedInToGetDepartmentCode = null;
				System.out.println("Exit.");
			}
			else if (loggedInToGetDepartmentCode.equals(departmentCode)) {

				Employee employee = getEmployeeByDepartmentCode(loggedInToGetDepartmentCode, departmentCode);

				employee.employeeInfo();
				employee.calculateSalary();
				employee.showSalary();

			} else {
				System.out.println("Invalid department code. Try again.");
			}
		}
	}

	public static Employee getEmployeeByDepartmentCode(String loggedInToGetDepartmentCode, String departmentCode) {
		
		switch (loggedInToGetDepartmentCode) {
		case "HR":
			return HREmployee.findEmployeeInHR(departmentCode);
		case "IT":
			return ITEmployee.findEmployeeInIT(departmentCode);
		case "MK":
			return MarketingEmployee.findEmployeeInMarketing(departmentCode);

		}
		return null;
	}

}
