package com.example.task2.instructor.service;

import com.example.task2.course.model.Course;
import com.example.task2.instructor.model.Instructor;

import java.util.List;

public interface InstructorService {

    Instructor createInstructor(Instructor instructor);

    List<Instructor> getAllInstructors();

    Instructor getInstructorById(Long id);

    List<Course> getCoursesByInstructor(Long instructorId);
}
