package com.danilermolenko.spring.mvc_rest_hibernate.dao;

import com.danilermolenko.spring.mvc_rest_hibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentsDAO{

    private SessionFactory factory;

    @Autowired
    public StudentDAOImpl(SessionFactory factory){
        this.factory = factory;
    }
    @Override
    public List<Student> showAllStudents() {
        Session session = factory.getCurrentSession();

        List<Student> students = session.createQuery("from Student ").getResultList();
        return students;
    }

    @Override
    public void saveNewStudent(Student student) {
        Session session = factory.getCurrentSession();
        session.merge(student);
    }

    @Override
    public Student getOneStudent(int id) {
        Session session = factory.getCurrentSession();
        Student student = session.get(Student.class, id);
        return student;
    }

    @Override
    public void deleteStudent(int id) {
        Session session = factory.getCurrentSession();
        Query<Student> query = session.createQuery("delete Student where id =: studentID");
        query.setParameter("studentID", id);
        query.executeUpdate();
    }
}
