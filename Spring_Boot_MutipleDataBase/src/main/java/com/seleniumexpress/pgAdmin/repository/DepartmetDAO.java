package com.seleniumexpress.pgAdmin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.seleniumexpress.entity.PgAAdmin.Department;

public interface DepartmetDAO extends JpaRepository<Department, Integer>{

}
