package com.example.EmployeeSpringBoot.modal;

import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.UUID;

public class Employee {
    private UUID employeeId;
    @Size(min=3,max = 15,message = "name is not matching the constraint")
    private String name;
    @Email
    private String email;

    public Employee(UUID employeeId, String name, String email) {
        this.employeeId = employeeId;
        this.name = name;
        this.email = email;
    }

    public UUID getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(UUID employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
