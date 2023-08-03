package com.danilermolenko.spring.mvc_rest_hibernate.exceptions;

public class StudentException {
    private String info;

    public StudentException() {
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
