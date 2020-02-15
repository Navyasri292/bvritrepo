package com.cg.ems.bean;

public class Employee
{
 private int employeeId;
 private String EmployeeName;
 private double Salary;
public Employee(int employeeId, String employeeName, double salary) {
	super();
	this.employeeId = employeeId;
	this.EmployeeName = employeeName;
	this.Salary = salary;
}
public Employee() {
	super();
	
}
public int getEmployeeId() {
	return employeeId;
}
public void setEmployeeId(int employeeId) {
	this.employeeId = employeeId;
}
public String getEmployeeName() {
	return EmployeeName;
}
public void setEmployeeName(String employeeName) {
	EmployeeName = employeeName;
}
public double getSalary() {
	return Salary;
}
public void setSalary(double salary) {
	Salary = salary;
}
 
 
 
 
 
 
}
