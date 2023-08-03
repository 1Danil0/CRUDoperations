package com.danilermolenko.spring.mvc_rest_hibernate.services;

import com.danilermolenko.spring.mvc_rest_hibernate.entity.Student;

import java.util.List;

public interface StudentService {

    public List<Student> showAllStudents();

    public void saveNewStudent(Student student);

    public Student getOneStudent(int id);

    public void deleteStudent(int id);
}
