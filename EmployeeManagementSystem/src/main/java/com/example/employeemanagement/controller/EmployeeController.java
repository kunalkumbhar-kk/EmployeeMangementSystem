package com.example.employeemanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.employeemanagement.entities.Employee;
import com.example.employeemanagement.exception.EmployeeNotFoundException;
import com.example.employeemanagement.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeService empService;
	
	@PostMapping("/addEmplyee")
	public String addEmployee(@Valid @RequestBody Employee employee) {
		return empService.addEmployee(employee);
	}
	
	@GetMapping("/getEmployee/{employeeID}")
	public Employee getEmployee(@PathVariable Long employeeID) throws EmployeeNotFoundException{
		return empService.getEmployee(employeeID);
	}
	
	@PutMapping("/updateEmployee/{employeeID}")
	public String updateEmployee(@PathVariable Long employeeID, @RequestBody Employee newEmployee) {
		return empService.updateEmployee(employeeID, newEmployee);
	}
	
	@DeleteMapping("/deleteEmployee/{employeeID}")
	public String deleteEmployee(@PathVariable Long employeeID) {
		String delmsg = empService.deleteEmployee(employeeID);
		return delmsg;
	}
}

