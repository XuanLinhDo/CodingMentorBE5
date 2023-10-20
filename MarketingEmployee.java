package be5.day72;

public class MarketingEmployee extends Employee {

	public MarketingEmployee(String id, String password, String name, String departmentCode, double baseSalary,
			double bonus) {
		super(id, password, name, departmentCode, baseSalary, bonus);
	}

	@Override
	public void employeeInfo() {
		System.out.println("ID : " + id);
		System.out.println("Name : " + name);
		System.out.println("Department Code : " + departmentCode);
		System.out.println("Your base salary : $ " + baseSalary);
		System.out.println("Bonus : $ " + bonus);
	}

	@Override
	public double calculateSalary() {
		return baseSalary + bonus;
	}

	@Override
	public void showSalary() {
		System.out.println("Total Salary : " + calculateSalary());

	}

	public String getId() {

		return id;
	}

	public String getPassword() {

		return password;
	}

	public String getDepartmentCode() {
		
		return departmentCode;
	}

}
