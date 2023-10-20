package be5.day72;

public abstract class Employee {
	String id;
	String password;
	String name;
	String departmentCode;
	double baseSalary;
	double bonus;

	public Employee(String id, String password, String name, String departmentCode, double baseSalary, double bonus) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.departmentCode = departmentCode;
		this.baseSalary = baseSalary;
		this.bonus = bonus;
	}

	public abstract void employeeInfo();

	public abstract double calculateSalary();

	public abstract void showSalary();

	public static String login(String id, String password) {

		for (HREmployee employee : DatabaseForEmployees.HR_EMPLOYEE_DB) {
			if (employee.getId().equals(id) && employee.getPassword().equals(password)) {
				return employee.getDepartmentCode();
			}

		}

		for (ITEmployee employee : DatabaseForEmployees.IT_EMPLOYEE_DB) {
			if (employee.getId().equals(id) && employee.getPassword().equals(password)) {
				return employee.getDepartmentCode();
			}

		}

		for (MarketingEmployee employee : DatabaseForEmployees.MARKETING_EMPLOYEE_DB) {
			if (employee.getId().equals(id) && employee.getPassword().equals(password)) {
				return employee.getDepartmentCode();
			}

		}
		return null;
	}
	public static HREmployee findEmployeeInHR(String departmentCode) {
		//to find employee from department code which is given/ as last time could not find employee
		for (HREmployee employee : DatabaseForEmployees.HR_EMPLOYEE_DB) {
			if (employee.getDepartmentCode().equals(departmentCode)) {
				return employee;
			}
		}
		return null;
	}

	public static ITEmployee findEmployeeInIT(String departmentCode) {
		for (ITEmployee employee : DatabaseForEmployees.IT_EMPLOYEE_DB) {
			if (employee.getDepartmentCode().equals(departmentCode)) {
				return employee;
			}
		}
		return null;
	}

	public static MarketingEmployee findEmployeeInMarketing(String departmentCode) {
		for (MarketingEmployee employee : DatabaseForEmployees.MARKETING_EMPLOYEE_DB) {
			if (employee.getDepartmentCode().equals(departmentCode)) {
				return employee;
			}
		}
		return null;
	}
}
