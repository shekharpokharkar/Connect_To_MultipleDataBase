package com.seleniumExpress;

import java.time.LocalDate;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.seleniumExpress.configuration.AppConfig;
import com.seleniumExpress.dao.StudentDAOImpl;
import com.seleniumExpress.entity.Student;


public class App {
	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		StudentDAOImpl studentDAOImpl = context.getBean("studentDAOImpl", StudentDAOImpl.class);

		Student shekhar = new Student();
		shekhar.setDateOfBirth(LocalDate.of(1997, 02, 14));
		shekhar.setMarried(false);
		shekhar.setSalary(15000l);
		shekhar.setStudentCity("pune");
		shekhar.setStudentGender('M');
		shekhar.setStudentName("shekhar");
		shekhar.setStudentPercentage(86.00f);

		studentDAOImpl.saveStudent(shekhar);
	}
}
