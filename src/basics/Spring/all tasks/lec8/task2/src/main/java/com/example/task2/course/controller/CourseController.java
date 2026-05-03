package com.example.task2.course.controller;

import com.example.task2.course.model.Course;
import com.example.task2.course.service.CourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService){
        this.courseService = courseService;
    }

    @PostMapping
    public Course createCourse(@RequestBody Course course){
        return courseService.createCourse(course);
    }

    @GetMapping
    public List<Course> getAllCourses(){
        return courseService.getAllCourses();
    }

    @GetMapping("/{id}")
    public Course getCourseById(@PathVariable Long id){
        return courseService.getCourseById(id);
    }

    @PostMapping("{courseId}/instructor/{instructorId}")
    public Course assignInstructor(@PathVariable Long courseId,@PathVariable Long instructorId){
        return courseService.assignInstructorToCourse(courseId,instructorId);
    }
}
