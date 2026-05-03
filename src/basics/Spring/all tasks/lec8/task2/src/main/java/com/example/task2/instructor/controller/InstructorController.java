package com.example.task2.instructor.controller;

import com.example.task2.course.model.Course;
import com.example.task2.instructor.model.Instructor;
import com.example.task2.instructor.service.InstructorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/instructors")
public class InstructorController {


    private final InstructorService instructorService;

    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @PostMapping
    public Instructor createInstructor(@RequestBody Instructor instructor) {
        return instructorService.createInstructor(instructor);
    }

    @GetMapping
    public List<Instructor> getAllInstructors() {
        return instructorService.getAllInstructors();
    }

    // Required API
    @GetMapping("/{id}")
    public Instructor getInstructorById(@PathVariable Long id) {
        return instructorService.getInstructorById(id);
    }

    // Get courses taught by instructor
    @GetMapping("/{id}/courses")
    public List<Course> getCoursesByInstructor(@PathVariable Long id) {
        Instructor instructor = instructorService.getInstructorById(id);
        return instructor.getCourses();
    }

}
