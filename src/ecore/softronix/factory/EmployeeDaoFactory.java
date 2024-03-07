package ecore.softronix.factory;

import ecore.softronix.dao.EmployeeDao;
import ecore.softronix.dao.EmployeeDaoImp;

public class EmployeeDaoFactory
{
	private static EmployeeDao empDao;
	
	static
	{
		empDao = new EmployeeDaoImp();
	}
	
	public static EmployeeDao getEmployeeDao()
	{
		return empDao;
	}

}
