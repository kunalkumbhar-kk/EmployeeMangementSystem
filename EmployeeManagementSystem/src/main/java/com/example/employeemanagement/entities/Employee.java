package com.example.employeemanagement.entities;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long employeeID;
	
	@NotBlank(message = "Employee name is required")
	private String empname;
	private String password;
	private String email;
	private String phone;
	private String address;
	private LocalDate dateOfBirth;
	private LocalDate joiningDate;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "departmentID")
    private Department department;
	
	@ManyToOne
    @JoinColumn(name = "roleID")
    private Role role;
	
	public Employee(){}

	public Employee(Long employeeID, String empname, String password, String email, String phone, String address,
			LocalDate dateOfBirth, LocalDate joiningDate) {
		super();
		this.employeeID = employeeID;
		this.empname = empname;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.dateOfBirth = dateOfBirth;
		this.joiningDate = joiningDate;
		//department (reference to Department entity) - Department (@ManyToOne)
		//role (reference to Role entity) - Role (@ManyToOne)
	}

	public Long getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(Long employeeID) {
		this.employeeID = employeeID;
	}

	public String getEmpname() {
		return empname;
	}

	public void setEmpname(String empname) {
		this.empname = empname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public LocalDate getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(LocalDate joiningDate) {
		this.joiningDate = joiningDate;
	}

	@Override
	public String toString() {
		return "Employee [employeeID=" + employeeID + ", empname=" + empname + ", password=" + password + ", email="
				+ email + ", phone=" + phone + ", address=" + address + ", dateOfBirth=" + dateOfBirth
				+ ", joiningDate=" + joiningDate + "]";
	}

}
