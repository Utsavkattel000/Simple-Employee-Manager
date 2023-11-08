package com.example.springproject.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.springproject.model.Employee;
import com.example.springproject.service.DepartmentService;
import com.example.springproject.service.EmployeeService;
@Controller
public class EmployeeController {
	@Autowired
	private EmployeeService empService;
	@Autowired
	private DepartmentService deptService;
	@GetMapping("/employee")
	public String getEmployee(Model model) {
        model.addAttribute("dList", deptService.getAllDepts());
		return "EmployeeForm";
	}
	@PostMapping("/employee")
	public String postEmployee(@ModelAttribute Employee emp) {
		empService.addEmployee(emp);
		
		return "redirect:/empList";
	}
	@GetMapping("/empList")
	public String getEmpList(Model model ) {
		model.addAttribute("empList",empService.getAllEmployee());
		return "EmployeeList";
	}
	@GetMapping("/emp/delete")
	public String delete(@RequestParam Long id) {
		empService.deleteEmployee(id);
		return "redirect:/empList";
	}
	@GetMapping("/emp/edit")
	public String edit(@RequestParam Long id,Model model) {
		model.addAttribute("dList",deptService.getAllDepts());
		model.addAttribute("emodel",empService.getEmployeeById(id));
		return "EmployeeEditForm";
	}
	@PostMapping("/emp/update")
	public String update(@ModelAttribute Employee emp) {
		empService.updateEmployee(emp);
		return "redirect:/empList";
	}
}
