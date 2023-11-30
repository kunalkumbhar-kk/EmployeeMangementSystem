package com.example.employeemanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.employeemanagement.entities.Project;
import com.example.employeemanagement.service.ProjectService;

@RestController
public class ProjectController {

	@Autowired
	ProjectService proService;
	
	@PostMapping("/addProject")
	//public String addProject(@Valid @RequestBody Project project) { <-replace this code with below line
	public String addProject(@RequestBody Project project) {
		return proService.addProject(project);
	}
	
	@GetMapping("/getProject/{projectID}")
	public Project getProject(@PathVariable Long projectID) { //<-remove this parentheses+ throws UserNotFoundException {
	return proService.getProject(projectID);
	}
	
	@PutMapping("/updateProject/{projectID}")
	public String updateProject(@PathVariable Long projectID, @RequestBody Project newProject) {
		return proService.updateProject(projectID, newProject);
	}
	
	@DeleteMapping("/deleteProject/{projectID}")
	public String deleteProject(@PathVariable Long projectID) {
		String delmsg = proService.deleteProject(projectID);
		return delmsg;
	}
}
