package com.danilermolenko.spring.mvc_rest_hibernate.exceptions;

public class NoSuchStudentException extends RuntimeException{
    public NoSuchStudentException(String message){
        super(message);
    }
}
