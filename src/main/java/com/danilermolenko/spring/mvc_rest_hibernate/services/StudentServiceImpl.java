package com.danilermolenko.spring.mvc_rest_hibernate.services;

import com.danilermolenko.spring.mvc_rest_hibernate.dao.StudentsDAO;
import com.danilermolenko.spring.mvc_rest_hibernate.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

private StudentsDAO studentsDAO;

    @Autowired
    public StudentServiceImpl(StudentsDAO studentsDAO) {
        this.studentsDAO = studentsDAO;
    }

    @Override
    @Transactional
    public List<Student> showAllStudents() {
        return studentsDAO.showAllStudents();
    }

    @Override
    @Transactional
    public void saveNewStudent(Student student) {
        studentsDAO.saveNewStudent(student);
    }

    @Override
    @Transactional
    public Student getOneStudent(int id) {
        return studentsDAO.getOneStudent(id);
    }

    @Override
    @Transactional
    public void deleteStudent(int id) {
        studentsDAO.deleteStudent(id);
    }
}
