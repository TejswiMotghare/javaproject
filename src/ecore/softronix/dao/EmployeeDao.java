package ecore.softronix.dao;

import ecore.softronix.bean.Employee;

public interface EmployeeDao {
	
     String add(Employee emp);
     Employee search(String eid);
     String update(Employee emp);
     String delete(String eid);

}
