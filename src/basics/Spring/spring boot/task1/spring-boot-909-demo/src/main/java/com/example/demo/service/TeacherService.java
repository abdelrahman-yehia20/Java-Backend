package com.example.demo.service;

import com.example.demo.model.Teacher;

import java.util.List;

public interface TeacherService {

    Teacher createTeacher(Teacher teacher);
    Teacher updateTeacher(Teacher teacher);
    Teacher getTeacherById(Long id);
    List<Teacher> getTeachers();
    void removeTeacherById(Long id);

}
