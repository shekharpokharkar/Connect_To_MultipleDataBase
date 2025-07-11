package com.seleniumexpress;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.seleniumexpress.mySql.entity.Employee;
import com.seleniumexpress.mySql.repository.EmployeeRepository;
import com.seleniumexpress.postgresql.entity.Customer;
import com.seleniumexpress.postgresql.repository.CustomerRepossitory;

@SpringBootApplication
public class MutipleDataBaseApplication implements CommandLineRunner {

	@Autowired
	private EmployeeRepository employeeRepo;

	@Autowired
	private CustomerRepossitory customerRepository;

	public static void main(String[] args) {
		SpringApplication.run(MutipleDataBaseApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Employee emp = new Employee();
		emp.setEmployeeCity("Delhhi");
		emp.setEmployeeDepartment("IT");
		emp.setEmployeeName("SHADBA");
		Customer cust = new Customer();
		cust.setCustomerCity("KOLHAPUR");
		cust.setCustomerCreditCardDetails("5555");
		cust.setCustomerName("Prajyoat");

		employeeRepo.save(emp);
		customerRepository.save(cust);

		System.out.println("Successfully Done");
	}

}
