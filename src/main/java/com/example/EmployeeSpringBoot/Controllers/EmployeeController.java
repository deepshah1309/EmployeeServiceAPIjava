package com.example.EmployeeSpringBoot.Controllers;

import com.example.EmployeeSpringBoot.ExceptionHandler.EmployeeNotFound;
import com.example.EmployeeSpringBoot.modal.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeDao service;
    @GetMapping("/employees")
    public List<Employee> getAll(){
            return service.getAllEmployees();
    }
    @GetMapping(path="/employee/{id}")
    public List<Employee> getById(@PathVariable UUID id){
        List<Employee> listEmp=service.getEmployeeById(id);
        if(0 ==listEmp.size()){
            throw new EmployeeNotFound("Couldn't find the employee for you sorry");
        }

        return listEmp;
    }
    @GetMapping(path="/employee/single/{id}")
    public EntityModel<Employee> getByIdSecond(@PathVariable UUID id){
        Employee mp=service.getEmployeeByIdsecond(id);
        if(null==mp){
            throw new EmployeeNotFound("Couldn't find the employee for you sorry");
        }
        EntityModel<Employee> eModel=EntityModel.of(mp);
        Link link=WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAll()).withRel("all-employees");
        eModel.add(link);
        return eModel;
    }
    @PostMapping("/employees/user")
    public ResponseEntity<Object> saveEmployee(@Valid @RequestBody  Employee emp){
           Employee employee= service.saveEmployee(emp);
        URI uri=ServletUriComponentsBuilder.fromCurrentRequest().path("{EmployeeId}").buildAndExpand(employee.getEmployeeId()).toUri();
        return ResponseEntity.created(uri).build();
    }
    @DeleteMapping("/employees/delete/user/{employeeId}")
    public void deleteEmployee(@PathVariable  UUID employeeId){
        Employee emp=service.deleteEmployee(employeeId);
        if(null==emp){
            throw new EmployeeNotFound("oops!COULDN'T FIND THAT EMPLOYEE");
        }


    }


}
