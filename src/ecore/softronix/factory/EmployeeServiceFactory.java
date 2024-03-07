package ecore.softronix.factory;

import ecore.softronix.service.EmployeeService;
import ecore.softronix.service.EmployeeServiceImp;


public class EmployeeServiceFactory 
{
	private static EmployeeService empService;
	
	static
	{
		empService = new EmployeeServiceImp();
	}
	
	public static EmployeeService getEmployeeService()
	{
		return empService;
	}

}
