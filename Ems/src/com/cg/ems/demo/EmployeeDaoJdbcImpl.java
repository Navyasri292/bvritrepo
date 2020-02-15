package com.cg.ems.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.cg.ems.bean.Employee;
import com.cg.ems.dao.EmployeeDao;
import com.cg.ems.exception.EmployeeException;

import EMS.Util.DBUtil;

public class EmployeeDaoJdbcImpl implements EmployeeDao
{

	@Override
	public int addEmployee(Employee employee) throws EmployeeException {
		int id=0;
		try
		{
		Connection connection=DBUtil.getConnection();
		String cmd="insert into employee_tbl5 values(?,?,?)";
		PreparedStatement pstmt=  connection.prepareStatement(cmd);
		pstmt.setInt(1,employee.getEmployeeId());
		pstmt.setString(2, employee.getEmployeeName());
		pstmt.setDouble(3, employee.getSalary());
		pstmt.executeUpdate();
		connection.close();
		}
		catch(Exception e)
		{
			throw new EmployeeException(e.getMessage());
	}
		id=employee.getEmployeeId();
		
		return id;
	}

	@Override
	public Employee findEmployeeById(int employeeId) throws EmployeeException {
		Employee employee=new Employee();
		try
		{
		Connection connection=DBUtil.getConnection();
		String cmd="select empid,empname,empsal from employee_tbl5 where empid=?";
		PreparedStatement pstmt=  connection.prepareStatement(cmd);
		pstmt.setInt(1,employeeId);
		ResultSet rst=pstmt.executeQuery();
		if(rst.next()) 
		{
			int id=rst.getInt("empid");
			String name=rst.getString("empname");
			double sal=rst.getDouble("empSal");
			employee.setEmployeeId(id);
			employee.setEmployeeName(name);
			employee.setSalary(sal);
			
		}
		else
		{
			throw new EmployeeException("ID NOT FOUND");
		}
			
		connection.close();
		}	
		catch(Exception e)
		{
			throw new EmployeeException(e.getMessage());
	}
		
		return employee;
	}

	@Override
	public Employee deleteEmployeeById(int employeeId) throws EmployeeException {
		/*try
		{
		Connection connection=DBUtil.getConnection();
		String cmd="delete from table product_tbl where employeeid=(?)";
		PreparedStatement pstmt=  connection.prepareStatement(cmd);
		pstmt.setInt(1, employee.getEmployeeId());	
		pstmt.executeUpdate();
		connection.close();
		}
		catch(Exception e)
		{
			throw new EmployeeException(e.getMessage());
	}*/
		return null;
	}

	@Override
	public List<Employee> findAllEmployee() throws EmployeeException {
		
		return null;
	}

}
