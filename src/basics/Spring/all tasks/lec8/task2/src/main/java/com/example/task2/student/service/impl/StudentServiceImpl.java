package com.example.task2.student.service.impl;

import com.example.task2.course.model.Course;
import com.example.task2.course.repo.CourseRepo;
import com.example.task2.student.model.Student;
import com.example.task2.student.repo.StudentRepo;
import com.example.task2.student.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepo studentRepo;
    private final CourseRepo courseRepo;

    public StudentServiceImpl(StudentRepo studentRepo, CourseRepo courseRepo){
        this.studentRepo = studentRepo;
        this.courseRepo = courseRepo;
    }

    @Override
    public Student createStudent(Student student) {
        return studentRepo.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));
    }

    @Override
    public Student registerStudentToCourse(Long studentId, Long courseId) {
        Student student = studentRepo.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        Course course = courseRepo.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        student.getCourses().add(course);

        return studentRepo.save(student);
    }
}