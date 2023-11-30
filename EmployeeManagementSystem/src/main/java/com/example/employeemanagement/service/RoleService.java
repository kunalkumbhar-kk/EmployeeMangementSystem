package com.example.employeemanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employeemanagement.entities.Role;
import com.example.employeemanagement.repository.RoleRepository;

@Service
public class RoleService {
	
	@Autowired
	RoleRepository roleRepository;
	
	public String addRole(Role role) {
		Role ro = roleRepository.save(role);
		if(ro != null)
			return "Role " + ro.getRoleID() + " successfully created";
		else
			return null;
	}
	
	public Role getRole(Long roleID){
		Role role = null;
		//try {
		role = roleRepository.findById(roleID).get();
		//} catch(NoSuchElementException ex) {
			//throw new UserNotFoundException("User not found with id "+roleID);
		
		return role;
	}
	
	public String updateRole(Long roleID, Role newRole) {
		Role ro = roleRepository.findById(roleID).get();
		ro.setTitle(newRole.getTitle());
		ro.setDescription(newRole.getDescription());
		ro = roleRepository.save(ro);
			if(ro != null)
				return "Role " + ro.getRoleID() + ", " + ro.getTitle() + ", " + ro.getDescription() + " Successfully update";
			else
				return null;
	}
	
	public String deleteRole(Long roleID) {
		
		roleRepository.deleteById(roleID);
		
		if(roleID == null) {
			return "Role with Id " + roleID + " not found";
		}else {
			return "Role With Id " + roleID + " deleted sucessfully";
		}
		
	}
}
