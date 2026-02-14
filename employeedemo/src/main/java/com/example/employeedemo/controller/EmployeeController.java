package com.example.employeedemo.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import com.example.employeedemo.repository.EmployeeRepository;
import com.example.employeedemo.model.Employee;

@RestController
@RequestMapping("/api/employees")
@CrossOrigin(origins = "http://localhost:5173")
public class EmployeeController {

    private final EmployeeRepository repo;

    public EmployeeController(EmployeeRepository repo) {
        this.repo = repo;
    }

    // CREATE
    @PostMapping
    public Employee create(@RequestBody Employee emp) {
        return repo.save(emp);
    }

    // READ
    @GetMapping
    public List<Employee> getAll() {
        return repo.findAll();
    }
}