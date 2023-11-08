package com.example.springproject.service;

import java.util.List;

import com.example.springproject.model.Employee;

public interface EmployeeService {
	void addEmployee(Employee emp);

	void deleteEmployee(Long id);

	void updateEmployee(Employee emp);

	Employee getEmployeeById(Long id);

	List<Employee> getAllEmployee();

}
