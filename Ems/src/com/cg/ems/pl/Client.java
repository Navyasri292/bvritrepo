package com.cg.ems.pl;

import java.util.List;
import java.util.Scanner;

import com.cg.ems.bean.Employee;
import com.cg.ems.exception.EmployeeException;
import com.cg.ems.service.EmployeeService;
import com.cg.ems.service.EmployeeServiceImpl;

public class Client {

	public static void main(String[] args) {
		Scanner scr=new Scanner (System.in);
		EmployeeService employeeservice=new EmployeeServiceImpl();
	    int choice=0;
 	    Employee employee=null;
	    List<Employee> list=null;
  	    while(choice!=5)
	 {
		 System.out.println("1.Add Employee");
		 System.out.println("2.Search Employee");
		 System.out.println("3.Delete Employee");
		 System.out.println("4.List All Employees");
		 System.out.println("5.exit");
		 System.out.println("enter your choice");
		 choice=scr.nextInt();
		 switch(choice)
		 
		 {
		 case 1: System.out.println("Enter the name");
		         scr.nextLine();
		         String name=scr.nextLine();
		          System.out.println("enter Salary");
		          double salary=scr.nextDouble();
		          employee =new Employee();
		          employee.setEmployeeName(name);
		          employee.setSalary(salary);
		          try
		          {
		     
		          
		          int id=employeeservice.addEmployee(employee);
		          System.out.println("Employee Id="+id);
		          }
		          catch (EmployeeException e)
		          {
		        	  System.out.println(e.getMessage());
		          }
			      break;
		 case 2: 
			 
	                    	  System.out.println("Enter the id");
                              int id =scr.nextInt();
                              try
                              {
                              employee=employeeservice.findEmployeeById(id);
                              System.out.println("Name="+employee.getEmployeeName());
                              System.out.println("Salary="+employee.getSalary());
                              }
                              catch(EmployeeException e)
                              {
                            	  System.out.println(e.getMessage());
                              }
		                          break;
		 
		 case 3:
			 System.out.println("Enter the id");
            id =scr.nextInt();
             try
             {
             employee=employeeservice.deleteEmployeeById(id);
             System.out.println("Name="+employee.getEmployeeName());
             System.out.println("Salary="+employee.getSalary());
             }
             catch(EmployeeException e)
             {
           	  System.out.println(e.getMessage());
             }
                          			 
			                    break;
		 case 4:              
			                     try
			                     {
			                     list =employeeservice.findAllEmployee();
			                     for(Employee emp:list)
			                     {
			                    	  id=emp.getEmployeeId();
			                    	  name=emp.getEmployeeName();
			                    	  salary=emp.getSalary();
			                    	  System.out.println(id+" "+name+" "+salary);
			                     }
			                     }
			                     catch(EmployeeException e)
			                     {
			                    	 System.out.println(e.getMessage());
			                     }
		                          break;
		 case 5:
			                       System.out.println("Thank you");
			                        return ;
	      
		 }
	 }
	}

}
        