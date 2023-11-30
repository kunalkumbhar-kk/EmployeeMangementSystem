package com.example.employeemanagement.service;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employeemanagement.entities.Employee;
import com.example.employeemanagement.exception.EmployeeNotFoundException;
import com.example.employeemanagement.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository empRepository;
	
	public String addEmployee(Employee employee) {
		
		Employee emp = empRepository.save(employee);
		
		if(emp != null)
			return "Employee " + emp.getEmployeeID() +"Sucessfully Created";
		return null;
	}
	
	public Employee getEmployee(Long employeeID) throws EmployeeNotFoundException{
		Employee employee = null;
		try {
		employee = empRepository.findById(employeeID).get();
		} catch(NoSuchElementException ex) {
			throw new EmployeeNotFoundException("Employee not found with id "+employeeID);
		}
		return employee;
	}
	
	public String updateEmployee(Long employeeID, Employee newEmployee) {
		Employee emp = empRepository.findById(employeeID).get();
		emp.setEmpname(newEmployee.getEmpname());
		emp.setPassword(newEmployee.getPassword());
		emp.setEmail(newEmployee.getEmail());
		emp.setPhone(newEmployee.getPhone());
		emp.setAddress(newEmployee.getAddress());
		emp.setDateOfBirth(newEmployee.getDateOfBirth());
		emp.setJoiningDate(newEmployee.getJoiningDate());
		emp = empRepository.save(emp);
			if(emp != null)
				return "Employee " + emp.getEmployeeID() + ", " + emp.getEmpname() + ", " + emp.getPassword() + ", " + emp.getEmail() + ", " + emp.getPhone() + ", " + emp.getAddress() + ", " + emp.getDateOfBirth() + ", " + emp.getJoiningDate() + " Successfully update";
			else
				return null;
	}
	
	public String deleteEmployee(Long employeeID) {
		
		empRepository.deleteById(employeeID);
		
		if(employeeID == null) {
			return "Employee with Id " + employeeID + " not found";
		}else {
			return "Employee With Id " + employeeID + " deleted sucessfully";
		}
		
	}
}
