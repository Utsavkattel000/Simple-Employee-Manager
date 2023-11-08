package com.example.springproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.springproject.model.Department;
import com.example.springproject.service.DepartmentService;

@Controller
public class DepartmentController {
	@Autowired
	private DepartmentService deptService;
	@GetMapping("/department")
public String getDepartment() {
	return "DepartmemtForm";
}
	@PostMapping("/department")
    public String postDepartment(@ModelAttribute Department dept) {
		deptService.addDept(dept);
    	return "DepartmentForm";
    }
	@GetMapping("/deptList")
	public String getList(Model model) {
		model.addAttribute("dList",deptService.getAllDepts());
		return "DepartmentList";
	}
	@GetMapping("/dept/delete")
	public String delete(@RequestParam int id) {
		deptService.deleteDept(id);
		return"redirect:/deptList";
	}
	@GetMapping("/dept/edit")
	public String edit(@RequestParam int id,Model model) {
		model.addAttribute("dmodel",deptService.getById(id));
		
		return "DepartmentEditForm";
		}
	@PostMapping("/dept/update")
	public String update(@ModelAttribute Department dept) {
		deptService.updateDepartment(dept);
		return "redirect:/deptList";
	}
	
	
	
	
	
	
}
