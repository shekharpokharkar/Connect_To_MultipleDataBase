package com.seleniumexpress.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seleniumexpress.entity.mysql.Student;
import com.seleniumexpress.mysql.repository.StudentDAO;

@Service
public class StudentService {
	
	@Autowired
	private StudentDAO studentRepository;
	
	
	public void saveStudent(Student student)
	{
		Student student2 = studentRepository.save(student);
		System.out.println("Student saved successfully"+student2);
	}

}
