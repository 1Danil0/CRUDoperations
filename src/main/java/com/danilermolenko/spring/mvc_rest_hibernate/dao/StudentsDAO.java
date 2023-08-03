package com.danilermolenko.spring.mvc_rest_hibernate.dao;

import com.danilermolenko.spring.mvc_rest_hibernate.entity.Student;

import java.util.List;

public interface StudentsDAO {

    public List<Student> showAllStudents();

    public void saveNewStudent(Student student);

    public Student getOneStudent(int id);

    public void deleteStudent(int id);
}
