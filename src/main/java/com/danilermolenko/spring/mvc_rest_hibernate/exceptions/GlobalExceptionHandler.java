package com.danilermolenko.spring.mvc_rest_hibernate.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<StudentException> handleException(NoSuchStudentException exception){
        StudentException handler = new StudentException();
        handler.setInfo(exception.getMessage());
        return new ResponseEntity<>(handler, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler
    public ResponseEntity<StudentException> handleException(RuntimeException e){
        StudentException handler = new StudentException();
        handler.setInfo(e.getMessage());
        return new ResponseEntity<>(handler,HttpStatus.BAD_REQUEST);
    }

}
