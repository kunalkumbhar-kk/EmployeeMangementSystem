package com.example.employeemanagement.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.employeemanagement.entities.Project;
@Repository
public interface ProjectRepository extends CrudRepository<Project, Long>{

}
