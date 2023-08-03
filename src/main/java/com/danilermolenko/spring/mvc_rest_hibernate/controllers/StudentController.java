package com.danilermolenko.spring.mvc_rest_hibernate.controllers;

import com.danilermolenko.spring.mvc_rest_hibernate.entity.Student;
import com.danilermolenko.spring.mvc_rest_hibernate.services.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/students")
public class StudentController {
    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/sts")
    public String showAllStudents(Model model){
        model.addAttribute("students", studentService.showAllStudents());
        return "students/students-view";
    }

    @GetMapping("/newStudent")
    public String addNewStudent(Model model){
        Student student = new Student();
        model.addAttribute("newSt", student);
        return "students/one-student-view";
    }

    @PostMapping("/saveStudent")
    public String saveNewStudent(@Valid @ModelAttribute("newSt") Student student, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "students/one-student-view";
        } else {
            studentService.saveNewStudent(student);
            return "redirect:sts";
        }
    }
    @GetMapping("/updateStudent")
    public String updateEmployee(@RequestParam("stID") int id, Model model){
        Student student = studentService.getOneStudent(id);
        model.addAttribute("newSt", student);
        return "students/one-student-view";
    }
    @GetMapping("/deleteStudent")
    public String deleteStudent(@RequestParam("stID") int id){
        studentService.deleteStudent(id);
        return "redirect:sts";
    }
}
