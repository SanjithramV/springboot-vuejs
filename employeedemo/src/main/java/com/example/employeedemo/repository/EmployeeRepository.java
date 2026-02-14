package com.example.employeedemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.employeedemo.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}