package com.danilermolenko.spring.mvc_rest_hibernate.entity;

import com.danilermolenko.spring.mvc_rest_hibernate.annotations.NotDigits;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name = "students")

public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @NotBlank(message = "Name must not be blank")
    @NotEmpty(message = "name must not be empty")
    @NotDigits
    @Column(name = "name")
    private String name;
    @NotBlank
    @NotDigits
    @NotEmpty
    @Column(name = "surname")
    private String surname;
    @Min(value = 1)
    @Max(value = 5)
    @Column(name = "coarse")
    private int coarse;
    @Min(value = 2)
    @Max(value = 5)
    @Column(name = "grade")
    private double grade;

    public Student(){}

    public Student(String name, String surname, int coarse, double grade) {
        this.name = name;
        this.surname = surname;
        this.coarse = coarse;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", coarse=" + coarse +
                ", avgGrade=" + grade +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getCoarse() {
        return coarse;
    }

    public void setCoarse(int coarse) {
        this.coarse = coarse;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double avgGrade) {
        this.grade = avgGrade;
    }
}
