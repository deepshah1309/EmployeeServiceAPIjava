package com.example.EmployeeSpringBoot.Controllers;

import com.example.EmployeeSpringBoot.modal.Employee;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class EmployeeDao {
    static List<Employee>  list=new ArrayList<>();

    static{
        list.add(new Employee(UUID.randomUUID(),"Deep","deepshah1309@gmail.com"));
        list.add(new Employee(UUID.randomUUID(),"Darsh","jasanidarsh3@gmail.com"));
        list.add(new Employee(UUID.randomUUID(),"Jay","jay4luhar@gmail.com"));
        list.add(new Employee(UUID.randomUUID(),"Monil","monilnbakshi@gmail.com"));



    }
    public List<Employee> getAllEmployees(){
        return list;
    }

    public List<Employee> getEmployeeById(UUID id) {
        List<Employee> output=new ArrayList<>();
        return list.stream().filter(emp->emp.getEmployeeId().equals(id)).collect(Collectors.toList());
    }

    public Employee saveEmployee(Employee emp) {
        UUID uuid = UUID.randomUUID();
        emp.setEmployeeId(uuid);
        list.add(emp);
        return emp;
    }

    public Employee deleteEmployee(UUID empid) {
        Iterator<Employee> itr= list.iterator();
        while(itr.hasNext()){
            Employee emp=itr.next();
            if(emp.getEmployeeId().equals(empid)){
                itr.remove();
                return emp;
            }
        }
        return null;

    }

    public Employee getEmployeeByIdsecond(UUID id) {
        List<Employee> output=new ArrayList<>();
        return list.stream().filter(emp->emp.getEmployeeId().equals(id)).findAny().orElse(null);
    }
}
