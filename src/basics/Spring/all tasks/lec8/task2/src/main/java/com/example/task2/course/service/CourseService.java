package com.example.task2.course.service;

import com.example.task2.course.model.Course;

import java.util.List;

public interface CourseService {

    Course createCourse(Course course);
    List<Course> getAllCourses();
    Course getCourseById(Long id);
    Course assignInstructorToCourse(Long courseId, Long instructorId);
}
