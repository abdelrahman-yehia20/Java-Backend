package com.example.task4.Teacher.service;


import com.example.task4.Teacher.dto.TeacherDto;

import java.util.List;

public interface TeacherService {
    TeacherDto createTeacher(TeacherDto teacherDto);
    List<TeacherDto> getAllTeachers();
    TeacherDto getTeacherById(Long id);


}
