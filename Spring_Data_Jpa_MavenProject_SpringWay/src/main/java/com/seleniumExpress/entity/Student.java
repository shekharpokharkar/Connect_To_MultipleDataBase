package com.seleniumExpress.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "students")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Student_Id")
	private Integer studentId;
	@Column(name = "Student_Name")
	private String studentName;
	@Column(name = "Student_City")
	private String studentCity;
	@Column(name = "Student_Marrital_Status")
	private boolean isMarried;
	@Column(name = "Student_Date_Of_Birth")
	private LocalDate dateOfBirth;
	@Column(name = "Student_Salary")
	private Long salary;
	@Column(name = "Student_Gender")
	private char studentGender;
	@Column(name = "Student_Percentage")
	private float studentPercentage;

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentCity() {
		return studentCity;
	}

	public void setStudentCity(String studentCity) {
		this.studentCity = studentCity;
	}

	public boolean isMarried() {
		return isMarried;
	}

	public void setMarried(boolean isMarried) {
		this.isMarried = isMarried;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Long getSalary() {
		return salary;
	}

	public void setSalary(Long salary) {
		this.salary = salary;
	}

	public char getStudentGender() {
		return studentGender;
	}

	public void setStudentGender(char studentGender) {
		this.studentGender = studentGender;
	}

	public float getStudentPercentage() {
		return studentPercentage;
	}

	public void setStudentPercentage(float studentPercentage) {
		this.studentPercentage = studentPercentage;
	}

	public Student(Integer studentId, String studentName, String studentCity, boolean isMarried, LocalDate dateOfBirth,
			Long salary, char studentGender, float studentPercentage) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentCity = studentCity;
		this.isMarried = isMarried;
		this.dateOfBirth = dateOfBirth;
		this.salary = salary;
		this.studentGender = studentGender;
		this.studentPercentage = studentPercentage;
	}

	public Student() {

	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", studentCity=" + studentCity
				+ ", isMarried=" + isMarried + ", dateOfBirth=" + dateOfBirth + ", salary=" + salary
				+ ", studentGender=" + studentGender + ", studentPercentage=" + studentPercentage + "]";
	}

}
