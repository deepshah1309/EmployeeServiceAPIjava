package com.example.EmployeeSpringBoot.ExceptionHandler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@RestController
@ControllerAdvice
public class EmployeeGlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleAllException(Exception ex, WebRequest wr){
        EmployeeExceptionResponse exception=new EmployeeExceptionResponse(ex.getMessage(),wr.getDescription(false),
                new Date());
        return new ResponseEntity<Object>(exception, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(EmployeeNotFound.class)
    public ResponseEntity<Object> handleEmployeeNotFoundException(Exception ex, WebRequest wr){
        EmployeeExceptionResponse exception=new EmployeeExceptionResponse(ex.getMessage(),wr.getDescription(false),
                new Date());
        return new ResponseEntity<Object>(exception, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        EmployeeExceptionResponse exception=new EmployeeExceptionResponse("invalid Inputs",ex.getBindingResult().toString(),new Date());
        return new ResponseEntity<Object>(exception, HttpStatus.BAD_REQUEST);

    }
}
