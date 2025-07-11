package com.seleniumexpress.mysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.seleniumexpress.entity.mysql.Student;

public interface StudentDAO extends JpaRepository<Student, Integer>{

}
