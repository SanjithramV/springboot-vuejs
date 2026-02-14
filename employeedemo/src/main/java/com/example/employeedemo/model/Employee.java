package com.example.employeedemo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "employees")   // IMPORTANT → matches your table name
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "emp_id")   // IMPORTANT → matches DB column
    private String empId;

    @Column(name = "name")
    private String name;

    // Getters and Setters

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getEmpId() { return empId; }
    public void setEmpId(String empId) { this.empId = empId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}