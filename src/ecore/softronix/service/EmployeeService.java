package ecore.softronix.service;

import ecore.softronix.bean.Employee;

public interface EmployeeService {
	
	String addEmployee(Employee emp);
	Employee searchEmployee(String eid);
	String updateEmployee(Employee emp);
	String deleteEmployee(String eid);
	
	

}
