package ecore.softronix.dao;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import ecore.softronix.bean.Employee;
import ecore.softronix.factory.ConnectionFactoryy;

public class EmployeeDaoImp implements EmployeeDao {

	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	PreparedStatement pst;
	
	@Override
	public String add(Employee emp) {
		
		String status = " ";
		
		try 
		{
			Connection con = ConnectionFactoryy.getConnection();
			pst = con.prepareStatement("select * from employee where eid = ?");
			String eidd = emp.getEid();
			
			pst.setString(1, eidd);
			
			ResultSet rs = pst.executeQuery();
			boolean b = rs.next();
			
			if(b == true)
			{
				System.out.println("Employee already Existed: "+eidd);
			}
			else
			{
				pst = con.prepareStatement("insert into employee values(?,?,?,?)");
				String s1 = emp.getEid();
				String s2 = emp.getEname();
				String s3 = emp.getEsal();
				String s4 = emp.getEaddr();
				
				pst.setString(1, s1);
				pst.setString(2, s2);
				pst.setString(3, s3);
				pst.setString(4, s4);
				
				int rowCount = pst.executeUpdate();
				
				if(rowCount == 1)
				{
					status = "Employee Detail Inserted Succesfully: "+s1;
				}
				else
				{
					status = "Employee Detail Insertion Failure: "+s1;
				}
				
				}
			
			} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return status;
	}

	@Override
	public Employee search(String eid) {
		
		Employee emp = null;
		try 
		{
		   Connection con = ConnectionFactoryy.getConnection();
		   pst = con.prepareStatement("select * from employee where eid = ?");
		   
		   pst.setString(1,eid);
		   
		   ResultSet rs = pst.executeQuery();
		   boolean b = rs.next();
		   
		   if(b == true)
		   {
			   emp = new Employee();
			   emp.setEid(rs.getString("EID"));
			   emp.setEname(rs.getString("ENAME"));
			   emp.setEsal(rs.getString("ESAL"));
			   emp.setEaddr(rs.getString("EADDR"));
		   }
		   else
		   {
			   emp = null;
		   }
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return emp;
	}

	@Override
	public String update(Employee emp) {
		
		String status = "";
		
		try 
		{
			Connection con = ConnectionFactoryy.getConnection();
			pst = con.prepareStatement("update employee set ename = ?, esal = ?, eaddr = ? where eid = ?");
			String e1 = emp.getEname();
			String e2 = emp.getEsal();
			String e3 = emp.getEaddr();
			String e4 = emp.getEid();
			
			pst.setString(1, e1);
			pst.setString(2, e2);
			pst.setString(3, e3);
			pst.setString(4, e4);
			
			int rowCount = pst.executeUpdate();
			
			if(rowCount == 1)
			{
				status = " Employee Details Succesfully Updated: "+e4;
			}
			else
			{
				status = " Employee Details Updation Failure(Please try again after some time) ";
			}
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return status;
	}

	@Override
	public String delete(String eid) {
		
		String status = "";
		
		try 
		{
			Connection con = ConnectionFactoryy.getConnection();
			pst = con.prepareStatement("delete from employee where eid = ? ");
			
			pst.setString(1, eid);
			
			int rowCount = pst.executeUpdate();
			if(rowCount == 1)
			{
				status = "Employee Details Succesfully Deleted: "+eid;
			}
			else
			{
				status = "Employee Details Deletion Failure: "+eid;
			}
			
			
			
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return status;
	}

}
