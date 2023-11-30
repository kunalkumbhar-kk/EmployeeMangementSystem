package com.example.employeemanagement.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.employeemanagement.entities.Project;
import com.example.employeemanagement.repository.ProjectRepository;

@Service
public class ProjectService {
	
	@Autowired
	ProjectRepository projectRepository;
	
	public String addProject(Project project) {
		Project pro = projectRepository.save(project);
		if(pro != null)
			return "Project " + pro.getProjectID() + " successfully created";
		else
			return null;
	}
	
	public Project getProject(Long projectID){
		Project project = null;
		//try {
		project = projectRepository.findById(projectID).get();
		//} catch(NoSuchElementException ex) {
			//throw new UserNotFoundException("User not found with id "+projectID);
		
		return project;
	}
	
	public String updateProject(Long projectID, Project newProject) {
		Project pro = projectRepository.findById(projectID).get();
		pro.setName(newProject.getName());
		pro.setDescription(newProject.getDescription());
		pro.setStartDate(newProject.getStartDate());
		pro.setEndDate(newProject.getEndDate());
		pro.setStatus(newProject.getStatus());
		pro = projectRepository.save(pro);
			if(pro != null)
				return "Project " + pro.getProjectID() + ", " + pro.getName() + ", " + pro.getDescription() + ", " + pro.getDescription() + ", " + pro.getStartDate() + ", " + pro.getEndDate() + ", " + pro.getStatus() + " Successfully update";
			else
				return null;
	}
	
	public String deleteProject(Long projectID) {
		
		projectRepository.deleteById(projectID);
		
		if(projectID == null) {
			return "Project with Id " + projectID + " not found";
		}else {
			return "Project With Id " + projectID + " deleted sucessfully";
		}
		
	}
}
