package com.example.employeemanagement.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.employeemanagement.entities.Role;
@Repository
public interface RoleRepository extends CrudRepository<Role, Long>{

}
