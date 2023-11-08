package com.example.springproject.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springproject.model.Department;
import com.example.springproject.repository.DepartmentRepository;
import com.example.springproject.service.DepartmentService;

@Service

public class DepartmentServiceImpl implements DepartmentService {
	@Autowired
	private DepartmentRepository deptRepo;

	@Override
	public void addDept(Department dept) {
		deptRepo.save(dept);

	}

	@Override
	public void deleteDept(int did) {
		deptRepo.deleteById(did);
	}

	@Override
	public void updateDepartment(Department dept) {
		deptRepo.save(dept);

	}

	@Override
	public List<Department> getAllDepts() {
		return deptRepo.findAll();
	}

	@Override
	public Department getById(int id) {
		return deptRepo.findById(id).get();
	}

}
