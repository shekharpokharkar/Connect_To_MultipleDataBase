package com.seleniumexpress.entity.PgAAdmin;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Departments")
public class Department {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer departmentId;
	private String departmentName;
	private String departmentCapacity;

	public Integer getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getDepartmentCapacity() {
		return departmentCapacity;
	}

	public void setDepartmentCapacity(String departmentCapacity) {
		this.departmentCapacity = departmentCapacity;
	}

	@Override
	public String toString() {
		return "Department [departmentId=" + departmentId + ", departmentName=" + departmentName
				+ ", departmentCapacity=" + departmentCapacity + "]";
	}

	public Department(Integer departmentId, String departmentName, String departmentCapacity) {
		super();
		this.departmentId = departmentId;
		this.departmentName = departmentName;
		this.departmentCapacity = departmentCapacity;
	}

	public Department() {
		
	}

}
