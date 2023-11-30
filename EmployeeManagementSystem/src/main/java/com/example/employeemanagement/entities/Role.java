package com.example.employeemanagement.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long roleID;
	
	private String title;
	private String description;
	
	public Role() {
		// TODO Auto-generated constructor stub
	}

	public Role(Long roleID, String title, String description) {
		super();
		this.roleID = roleID;
		this.title = title;
		this.description = description;
	}

	public Long getRoleID() {
		return roleID;
	}

	public void setRoleID(Long roleID) {
		this.roleID = roleID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Role [roleID=" + roleID + ", title=" + title + ", description=" + description + "]";
	}
	
}
