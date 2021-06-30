package com.example.EmployeeSpringBoot.ExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND)
public class EmployeeNotFound extends  RuntimeException{
    public EmployeeNotFound(String str){
        super(str);
    }

}
