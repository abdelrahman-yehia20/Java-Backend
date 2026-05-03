package com.example.task4.Teacher.service.impl;

import com.example.task4.Teacher.dto.TeacherDto;
import com.example.task4.Teacher.mapper.TeacherMapper;
import com.example.task4.Teacher.model.Teacher;
import com.example.task4.Teacher.repo.TeacherRepo;
import com.example.task4.Teacher.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    TeacherRepo teacherRepo;
    TeacherMapper teacherMapper;

    @Autowired
    public TeacherServiceImpl(TeacherRepo teacherRepo, TeacherMapper teacherMapper){
        this.teacherRepo = teacherRepo;
        this.teacherMapper = teacherMapper;
    }

    @Override
    public TeacherDto createTeacher(TeacherDto teacherDto) {
        Teacher teacher = teacherMapper.toEntity(teacherDto);
        if (teacher.getStudents() != null) {
            teacher.getStudents().forEach(student -> student.setTeacher(teacher));
        }
        Teacher teacherSaved = teacherRepo.save(teacher);
         teacherDto = teacherMapper.toDto(teacherSaved);
        return teacherDto;
    }

    @Override
    public List<TeacherDto> getAllTeachers() {
        List<Teacher> teachers = teacherRepo.findAll();
        return teacherMapper.toDtoList(teachers);
    }

    @Override
    public TeacherDto getTeacherById(Long id) {
        Teacher teacher = teacherRepo.findById(id).orElseThrow(() -> new RuntimeException("Teacher not found"));
        return teacherMapper.toDto(teacher);
    }
}
