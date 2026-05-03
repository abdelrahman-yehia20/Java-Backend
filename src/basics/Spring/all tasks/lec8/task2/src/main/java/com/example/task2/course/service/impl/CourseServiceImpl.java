package com.example.task2.course.service.impl;

import com.example.task2.course.model.Course;
import com.example.task2.course.repo.CourseRepo;
import com.example.task2.course.service.CourseService;
import com.example.task2.instructor.model.Instructor;
import com.example.task2.instructor.repo.InstructorRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    private final CourseRepo courseRepo;
    private final InstructorRepo instructorRepo;

    public CourseServiceImpl(CourseRepo courseRepo, InstructorRepo instructorRepo){
        this.courseRepo= courseRepo;
        this.instructorRepo =instructorRepo;
    }

    @Override
    public Course createCourse(Course course) {
        return courseRepo.save(course);
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepo.findAll();
    }

    @Override
    public Course getCourseById(Long id) {
        return courseRepo.findById(id).orElseThrow(()->{
            throw new RuntimeException("course not found");
        });
    }

    @Override
    public Course assignInstructorToCourse(Long courseId, Long instructorId) {
        Course course = courseRepo.findById(courseId).orElseThrow(() -> new RuntimeException("course not found"));
        Instructor instructor = instructorRepo.findById(instructorId).orElseThrow(() -> new RuntimeException("instructor not found"));
        course.setInstructor(instructor);
        return courseRepo.save(course);
    }
}
