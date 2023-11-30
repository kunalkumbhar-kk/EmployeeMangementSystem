package com.example.employeemanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employeemanagement.entities.Department;
import com.example.employeemanagement.repository.DepartmentRepository;

@Service
public class DepartmentService {
	
	@Autowired
	DepartmentRepository departmentRepository;
	
	public String addDepartment(Department department) {
		Department dept = departmentRepository.save(department);
		if(dept != null)
			return "Department " + dept.getDepartmentID() + " successfully created";
		else
			return null;
	}
	
	public Department getDepartment(Long departmentID){
		Department department = null;
		//try {
		department = departmentRepository.findById(departmentID).get();
		//} catch(NoSuchElementException ex) {
			//throw new UserNotFoundException("User not found with id "+departmentID);
		
		return department;
	}
	
	public String updateDepartment(Long departmentID, Department newdepartment) {
		Department dept = departmentRepository.findById(departmentID).get();
		dept.setName(newdepartment.getName());
		dept.setDescription(newdepartment.getDescription());
		dept = departmentRepository.save(dept);
			if(dept != null)
				return "Department " + dept.getDepartmentID() + ", " + dept.getName() + ", " + dept.getDescription() + " Successfully update";
			else
				return null;
	}
	
	public String deleteDepartment(Long departmentID) {
		
		departmentRepository.deleteById(departmentID);
		
		if(departmentID == null) {
			return "Department with Id " + departmentID + " not found";
		}else {
			return "Department With Id " + departmentID + " deleted sucessfully";
		}
		
	}
}
