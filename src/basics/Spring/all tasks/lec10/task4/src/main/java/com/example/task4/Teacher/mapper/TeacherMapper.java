package com.example.task4.Teacher.mapper;

import com.example.task4.Teacher.dto.TeacherDto;
import com.example.task4.Teacher.model.Teacher;

import java.util.List;

public interface TeacherMapper {

    Teacher toEntity(TeacherDto teacherDto);
    TeacherDto toDto(Teacher teacher);
    List<Teacher> toEntityList(List<TeacherDto> teacherDtos);
    List<TeacherDto> toDtoList(List<Teacher> teachers);

}
