package com.example.EmployeeSpringBoot.ExceptionHandler;

import java.util.Date;

public class EmployeeExceptionResponse {
    public EmployeeExceptionResponse(String errorMessage, String description, Date date) {
        this.errorMessage = errorMessage;
        this.description = description;
        this.date = date;
    }

    private String errorMessage,description;
    private Date date;

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
