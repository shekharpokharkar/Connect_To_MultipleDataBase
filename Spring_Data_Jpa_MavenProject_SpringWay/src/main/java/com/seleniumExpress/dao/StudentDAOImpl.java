package com.seleniumExpress.dao;

import org.springframework.stereotype.Service;

import com.seleniumExpress.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Service
public class StudentDAOImpl {

	@PersistenceContext(name = "mysqldb")
	public EntityManager entityManager;
	
	@Transactional
	public void saveStudent(Student student)
	{
		entityManager.persist(student);
		System.out.println("Student saved successfully");
	}
}
