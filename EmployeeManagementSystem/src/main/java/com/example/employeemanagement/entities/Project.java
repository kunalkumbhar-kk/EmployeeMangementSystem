package com.example.employeemanagement.entities;

import java.time.LocalDate;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Project {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long projectID;
	
	private String name; 
	private String description;
	private LocalDate startDate;
	private LocalDate endDate;
	//manager (reference to Employee entity) - Employee (@ManyToOne)
	//department (reference to Department entity) - Department (@ManyToOne)
	private String status; 
	
	@ManyToOne
    @JoinColumn(name = "departmentID")
    private Department department;

    @ManyToMany
    @JoinTable(
        name = "project_employee",
        joinColumns = @JoinColumn(name = "projectID"),
        inverseJoinColumns = @JoinColumn(name = "employeeID")
    )
    private Set<Employee> employees;
	
	public Project() {
		// TODO Auto-generated constructor stub
	}

	public Project(Long projectID, String name, String description, LocalDate startDate, LocalDate endDate,
			String status) {
		super();
		this.projectID = projectID;
		this.name = name;
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;
		this.status = status;
	}

	public Long getProjectID() {
		return projectID;
	}

	public void setProjectID(Long projectID) {
		this.projectID = projectID;
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

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Project [projectID=" + projectID + ", name=" + name + ", description=" + description + ", startDate="
				+ startDate + ", endDate=" + endDate + ", status=" + status + "]";
	}
	
	
}
