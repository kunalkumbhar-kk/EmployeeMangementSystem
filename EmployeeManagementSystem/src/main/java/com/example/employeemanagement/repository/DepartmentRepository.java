package com.example.employeemanagement.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.employeemanagement.entities.Department;
@Repository
public interface DepartmentRepository extends CrudRepository<Department, Long>{

}
