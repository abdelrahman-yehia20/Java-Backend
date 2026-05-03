package com.example.task4.student.mapper;



import com.example.task4.student.dto.StudentDto;
import com.example.task4.student.model.Student;

import java.util.List;

public interface StudentMapper {

    Student toEntity(StudentDto studentDto);
    StudentDto toDto(Student student);
    List<Student> toEntityList(List<StudentDto> studentDtos);
    List<StudentDto> toDtoList(List<Student> students);
}
