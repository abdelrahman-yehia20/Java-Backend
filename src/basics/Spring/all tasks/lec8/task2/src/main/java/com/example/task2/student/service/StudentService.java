package com.example.task2.student.service;

import com.example.task2.student.model.Student;

import java.util.List;

public interface StudentService {

    Student createStudent(Student student);
    List<Student> getAllStudents();
    Student getStudentById(Long id);
    Student registerStudentToCourse(Long studentId, Long courseId);

}
