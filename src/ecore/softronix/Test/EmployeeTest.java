package ecore.softronix.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import ecore.softronix.bean.Employee;
import ecore.softronix.factory.EmployeeServiceFactory;
import ecore.softronix.service.EmployeeService;

public class EmployeeTest {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try 
		{
			while(true)
			{
				System.out.println();
				System.out.println("*******CURD OPERATION PROJECT*********");
				System.out.println(" 1.ADD    ");
				System.out.println(" 2.SEARCH ");
				System.out.println(" 3.UPDATE ");
				System.out.println(" 4.DELETE ");
				System.out.println(" 5.EXIT   ");
				
				System.out.println("PLEASE ENTER ANY ONE OPTION WHICH YOU WANT TO PERFORM[1, 2, 3, 4, 5]");
				int option = Integer.parseInt(br.readLine());
				
				String eid,ename,esal,eaddr,status;
				
				EmployeeService employeeService = EmployeeServiceFactory.getEmployeeService();
				
				Employee emp = null;
				
			switch(option)
			{
				case 1:
				System.out.println("Enter Employee Id: ");
				eid = br.readLine();
				  
				System.out.println("Enter Employee Name: ");
				ename = br.readLine();
				  
				System.out.println("Enter Employee Salary: ");
				esal = br.readLine();
				
				System.out.println("Enter Employee Address: ");
				eaddr = br.readLine();
				
				emp = new Employee();
				
				emp.setEid(eid);
				emp.setEname(ename);
				emp.setEsal(esal);
				emp.setEaddr(eaddr);
				
				status = employeeService.addEmployee(emp);
				System.out.println("Employee Status: "+status);
				
				break;
				
				case 2:
					System.out.println("Enter Employee ID: ");
					eid = br.readLine();
					
					emp = employeeService.searchEmployee(eid);
					
					if(emp == null)
					{
						System.out.println("****Employee ID not Exist:"+eid+" ****");
						System.out.println("----Please Check your ID No.----");
					}
					else
					{
						System.out.println("******Employee Details*******");
						System.out.println("-----------------------------");
						System.out.println("Employee Id      : "+emp.getEid());
						System.out.println("Employee Name    : "+emp.getEname());
						System.out.println("Employee Salary  : "+emp.getEsal());
						System.out.println("Employee Address : "+emp.getEaddr());
					}
					
					break;
					
				case 3:
					
					System.out.println("Enter Employee ID: ");
					eid = br.readLine();
					
					emp = employeeService.searchEmployee(eid);
					if(emp == null)
					{
						System.out.println("Employee ID not Exist");
					}
					else
					{
						System.out.println("Employee Name: [Old Name: '"+emp.getEname()+"']---->New Name: ");
						String new_name = br.readLine();
						if(new_name == null || new_name.equals(""))
						{
							new_name = emp.getEname();
						}
						
						System.out.println("Employee Salary: [Old Salary: '"+emp.getEsal()+"']---->New Salary: ");
						String new_sal = br.readLine();
						if(new_sal == null || new_sal.equals(""))
						{
							new_sal = emp.getEsal();
						}
						
						System.out.println("Employee Address: [Old Address: '"+emp.getEaddr()+"']---->New Address: ");
						String new_addr = br.readLine();
						if(new_addr == null || new_addr.equals(""))
						{
							new_addr = emp.getEaddr();
						}
						
						Employee new_emp = new Employee();
						new_emp.setEid(eid);
						new_emp.setEname(new_name);
					
						new_emp.setEsal(new_sal);
						new_emp.setEaddr(new_addr);
						
						status = employeeService.updateEmployee(new_emp);
						System.out.println("Update Status: "+status);
						
					}
					break;
					
				case 4:
					
					System.out.println("Enter Employee ID: ");
					eid = br.readLine();
					emp = employeeService.searchEmployee(eid);
					
					if(emp == null)
					{
						System.out.println("Employee ID not Exist");
					}
					else
					{
						status = employeeService.deleteEmployee(eid);
						System.out.println("Status: "+status);
					}
					break;
					
				case 5:
					System.out.println("*****Thank You Please Visit Again*****");
					System.exit(0);
					break;
				
				default:
					System.out.println("||---Please Enter a choice from[1,2,3,4,5]---||");
					break;
			}
				  
		   }
		} 
		   catch (Exception e) 
		  {
			e.printStackTrace();
		  }
		
		

	}

}
