package be5.day72;

public class ITEmployee extends Employee {
	int overTimeHours;
	double hourlyRate;

	public ITEmployee(String id, String password, String name, String departmentCode, double baseSalary, double bonus,
			int overTimeHours, double hourlyRate) {
		super(id, password, name, departmentCode, baseSalary, bonus);
		this.overTimeHours = overTimeHours;
		this.hourlyRate = hourlyRate;
	}

	@Override
	public void employeeInfo() {
		System.out.println("ID : " + id);
		System.out.println("Name : " + name);
		System.out.println("Department Code : " + departmentCode);
		System.out.println("Your base salary : $ " + baseSalary);
		System.out.println("Bonus : $ " + bonus);
		System.out.println("Overtime Hours " + overTimeHours);
		System.out.println("Hourly Rate : $ " + hourlyRate);
	}

	@Override
	public double calculateSalary() {
		return baseSalary + bonus + (overTimeHours * hourlyRate);
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
