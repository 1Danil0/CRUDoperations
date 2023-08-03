package com.danilermolenko.spring.mvc_rest_hibernate.controllers;

import com.danilermolenko.spring.mvc_rest_hibernate.entity.Student;
import com.danilermolenko.spring.mvc_rest_hibernate.exceptions.NoSuchStudentException;
import com.danilermolenko.spring.mvc_rest_hibernate.services.StudentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class StudentAPIController {

    private StudentService studentService;

    @Autowired
    public StudentAPIController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public List<Student> getAllStudents(){
        List<Student> allStudents = studentService.showAllStudents();
        return allStudents;
    }
    @GetMapping("/students/{id}")
    public Student getOneStudent(@PathVariable("id")int id){
        Student student = studentService.getOneStudent(id);
        if(student == null) {
            throw new NoSuchStudentException("There is no student with ID = " + id);
        }
        return student;
    }

    @PostMapping("/students")
    public void addNewStudent(@RequestBody Student student){
        studentService.saveNewStudent(student);
    }
    @PutMapping("/students")
    public void updateStudent(@RequestBody Student student){
        studentService.saveNewStudent(student);
    }
    @DeleteMapping("/students/{id}")
    public void deleteStudent(@PathVariable("id") int id){
        Student student = studentService.getOneStudent(id);
        if(student == null) {
            throw new NoSuchStudentException("There is no student with ID = " + id);
        }
        studentService.deleteStudent(id);
    }
}
