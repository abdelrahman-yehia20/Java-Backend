package com.example.task4.student.service;


import com.example.task4.student.dto.StudentDto;

import java.util.List;

public interface StudentService {
    StudentDto createStudent(StudentDto studentDto);
    List<StudentDto> getAllStudents();
    StudentDto getStudentById(Long id);
}
