package com.example.employeemanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.employeemanagement.entities.Role;
import com.example.employeemanagement.service.RoleService;

@RestController
public class RoleController {
	
	@Autowired
	RoleService roleService;
	
	@PostMapping("/addRole")
	//public String addRole(@Valid @RequestBody Employee employee) { <-replace this code with below line
	public String addRole(@RequestBody Role role) {
		return roleService.addRole(role);
	}
	
	@GetMapping("/getRole/{roleID}")
	public Role getRole(@PathVariable Long roleID) { //<-remove this parentheses+ throws UserNotFoundException {
	return roleService.getRole(roleID);
	}
	
	@PutMapping("/updateRole/{roleID}")
	public String updateRole(@PathVariable Long roleID, @RequestBody Role newRole) {
		return roleService.updateRole(roleID, newRole);
	}
	
	@DeleteMapping("/deleteRole/{roleID}")
	public String deleteRole(@PathVariable Long roleID) {
		String delmsg = roleService.deleteRole(roleID);
		return delmsg;
	}

}
