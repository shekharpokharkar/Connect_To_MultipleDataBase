package com.seleniumexpress.mySql.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.seleniumexpress.mySql.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
