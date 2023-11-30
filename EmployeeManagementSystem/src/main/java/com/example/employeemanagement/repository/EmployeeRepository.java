package com.example.employeemanagement.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.employeemanagement.entities.Employee;
@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long>{

}
