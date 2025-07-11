package com.seleniumexpress;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.seleniumexpress.entity.PgAAdmin.Department;
import com.seleniumexpress.entity.mysql.Student;
import com.seleniumexpress.service.DepartmentService;
import com.seleniumexpress.service.StudentService;

@SpringBootApplication
public class SpringBootMutipleDataBaseApplication implements CommandLineRunner {

	@Autowired
	private StudentService service;

	@Autowired
	private DepartmentService departmetService;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMutipleDataBaseApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Student shekhar = new Student();
		shekhar.setDateOfBirth(LocalDate.of(1997, 02, 14));
		shekhar.setMarried(false);
		shekhar.setSalary(15000l);
		shekhar.setStudentCity("pune");
		shekhar.setStudentGender('M');
		shekhar.setStudentName("shekhar");
		shekhar.setStudentPercentage(86.00f);

		Department dep = new Department();
		dep.setDepartmentCapacity("120");
		dep.setDepartmentName("Mechanical");
		departmetService.saveDepartmet(dep);

		service.saveStudent(shekhar);

	}

}
