package com.example.springproject.service;

import java.util.List;

import com.example.springproject.model.Department;

public interface DepartmentService {
     void addDept(Department dept);
     void deleteDept(int did);
     void updateDepartment(Department dept);
     Department getById(int id);
     List<Department> getAllDepts();
	
	
	
	
	
}
