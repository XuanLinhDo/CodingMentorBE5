package be5.day72;

import java.util.ArrayList;

public class DatabaseForEmployees {
	public static ArrayList<HREmployee> HR_EMPLOYEE_DB = new ArrayList<HREmployee>();
	public static ArrayList<ITEmployee> IT_EMPLOYEE_DB = new ArrayList<ITEmployee>();
	public static ArrayList<MarketingEmployee> MARKETING_EMPLOYEE_DB = new ArrayList<MarketingEmployee>();

	public static void initDB() {
		
		HR_EMPLOYEE_DB.add(new HREmployee("111","1234","lin","HR", 98000, 4900));
		HR_EMPLOYEE_DB.add(new HREmployee("121","2341","liosn","HR", 110000, 5500));
		HR_EMPLOYEE_DB.add(new HREmployee("141","2913","lisdn","HR", 108000, 5400));
		
		IT_EMPLOYEE_DB.add(new ITEmployee("123","1235","lisdn","IT", 86000, 4300, 15, 40));
		IT_EMPLOYEE_DB.add(new ITEmployee("321","0927","l2n","IT", 98000, 4900, 10, 42));
		IT_EMPLOYEE_DB.add(new ITEmployee("143","1212","lis43","IT", 138000, 6900, 5, 65));
		
		MARKETING_EMPLOYEE_DB.add(new MarketingEmployee("001","12352","AAA","MK", 80000, 4000));
		MARKETING_EMPLOYEE_DB.add(new MarketingEmployee("002","12321","BBB","MK", 65000, 3250));
		MARKETING_EMPLOYEE_DB.add(new MarketingEmployee("003","12112","CCC","MK", 108000, 5400));
		
	}
}
