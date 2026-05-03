package com.example.task4.student.service.impl;

import com.example.task4.Teacher.model.Teacher;
import com.example.task4.Teacher.repo.TeacherRepo;
import com.example.task4.student.dto.StudentDto;
import com.example.task4.student.mapper.StudentMapper;
import com.example.task4.student.model.Student;
import com.example.task4.student.repo.StudentRepo;
import com.example.task4.student.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentServiceImpl implements StudentService {

    StudentRepo studentRepo;
    StudentMapper studentMapper;
    TeacherRepo teacherRepo;

    public StudentServiceImpl(StudentRepo studentRepo, StudentMapper studentMapper, TeacherRepo teacherRepo){
        this.studentRepo =studentRepo;
        this.studentMapper = studentMapper;
        this.teacherRepo = teacherRepo;
    }

    @Override
    public StudentDto createStudent(StudentDto studentDto) {
        Student student = studentMapper.toEntity(studentDto);
        if (studentDto.getTeacherId() != null){
            Teacher teacher =teacherRepo.findById(studentDto.getTeacherId()).orElseThrow(()-> new RuntimeException("Teacher not found"));
            student.setTeacher(teacher);
        }
        Student saved = studentRepo.save(student);

        return studentMapper.toDto(saved);
    }

    @Override
    public List<StudentDto> getAllStudents() {
        List<Student> students = studentRepo.findAll();
        return studentMapper.toDtoList(students);
    }

    @Override
    public StudentDto getStudentById(Long id) {
        Student student = studentRepo.findById(id).orElseThrow(()-> new RuntimeException("Student not found"));
        return studentMapper.toDto(student);
    }
}
