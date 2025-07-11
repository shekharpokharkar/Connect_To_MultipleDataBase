package com.seleniumexpress.mySql.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Employees")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer employeeId;
	private String employeeCity;
	private String employeeDepartment;
	private String employeeName;

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeCity() {
		return employeeCity;
	}

	public void setEmployeeCity(String employeeCity) {
		this.employeeCity = employeeCity;
	}

	public String getEmployeeDepartment() {
		return employeeDepartment;
	}

	public void setEmployeeDepartment(String employeeDepartment) {
		this.employeeDepartment = employeeDepartment;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeCity=" + employeeCity + ", employeeDepartment="
				+ employeeDepartment + ", employeeName=" + employeeName + "]";
	}

	public Employee(Integer employeeId, String employeeCity, String employeeDepartment, String employeeName) {

		this.employeeId = employeeId;
		this.employeeCity = employeeCity;
		this.employeeDepartment = employeeDepartment;
		this.employeeName = employeeName;
	}

	public Employee() {

	}

}
