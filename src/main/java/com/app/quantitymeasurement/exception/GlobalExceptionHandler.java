package com.app.quantitymeasurement.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleException(Exception e){
        return new ResponseEntity<>(new ErrorResponse(
            LocalDateTime.now(), 500, "Internal Server Error", e.getMessage()),
            HttpStatus.INTERNAL_SERVER_ERROR);
    }
}