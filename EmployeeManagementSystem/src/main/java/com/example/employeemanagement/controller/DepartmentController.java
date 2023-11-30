package com.example.employeemanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.employeemanagement.entities.Department;
import com.example.employeemanagement.service.DepartmentService;

@RestController
public class DepartmentController {	
	
	@Autowired
	DepartmentService departmentService;
	
	@PostMapping("/addDepartment")
	//public String addDepartment(@Valid @RequestBody Department department) { <-replace this code with below line
	public String addDepartment(@RequestBody Department department) {
		return departmentService.addDepartment(department);
	}
	
	@GetMapping("/getDepartment/{departmentID}")
	public Department getEmployee(@PathVariable Long departmentID) { //<-remove this parentheses+ throws UserNotFoundException {
	return departmentService.getDepartment(departmentID);
	}
	
	@PutMapping("/updateDepartment/{departmentID}")
	public String updateDepartment(@PathVariable Long departmentID, @RequestBody Department newDepartment) {
		return departmentService.updateDepartment(departmentID, newDepartment);
	}
	
	@DeleteMapping("/deleteDepartment/{departmentID}")
	public String deleteDepartment(@PathVariable Long departmentID) {
		String delmsg = departmentService.deleteDepartment(departmentID);
		return delmsg;
	}
}
