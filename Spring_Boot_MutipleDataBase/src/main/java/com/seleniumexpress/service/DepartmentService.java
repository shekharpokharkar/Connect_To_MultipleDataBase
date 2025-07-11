package com.seleniumexpress.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seleniumexpress.entity.PgAAdmin.Department;
import com.seleniumexpress.pgAdmin.repository.DepartmetDAO;

@Service
public class DepartmentService {

	@Autowired
	private DepartmetDAO DepartmetRepository;
	
	
	public void saveDepartmet(Department departmet)
	{
		Department department = DepartmetRepository.save(departmet);
		System.out.println("Student saved successfully"+department);
	}

}
