package com.seleniumexpress.postgresql.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.seleniumexpress.postgresql.entity.Customer;

public interface CustomerRepossitory extends JpaRepository<Customer, Integer>{

}
