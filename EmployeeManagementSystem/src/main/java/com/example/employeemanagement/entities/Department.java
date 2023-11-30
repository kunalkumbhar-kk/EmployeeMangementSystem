package com.example.employeemanagement.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long departmentID;
	
	private String name;
	private String description;
	
	public Department() {
		// TODO Auto-generated constructor stub
	}

	public Department(Long departmentID, String name, String description) {
		super();
		this.departmentID = departmentID;
		this.name = name;
		this.description = description;
	}

	public Long getDepartmentID() {
		return departmentID;
	}

	public void setDepartmentID(Long departmentID) {
		this.departmentID = departmentID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Department [departmentID=" + departmentID + ", name=" + name + ", description=" + description + "]";
	}
	
}
