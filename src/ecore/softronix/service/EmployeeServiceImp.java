package ecore.softronix.service;

import ecore.softronix.bean.Employee;
import ecore.softronix.dao.EmployeeDao;
import ecore.softronix.factory.EmployeeDaoFactory;

public class EmployeeServiceImp implements EmployeeService {

	EmployeeDao empDao = EmployeeDaoFactory.getEmployeeDao();
	
	@Override
	public String addEmployee(Employee emp) {
		
		String status = empDao.add(emp);
		return status;
	}

	@Override
	public Employee searchEmployee(String eid) {
		
		Employee emp = empDao.search(eid);
		return emp;
	}

	@Override
	public String updateEmployee(Employee emp) {
		
		String status = empDao.update(emp);
		return status;
	}

	@Override
	public String deleteEmployee(String eid) {
		String status = empDao.delete(eid);
		return status;
	}

}
