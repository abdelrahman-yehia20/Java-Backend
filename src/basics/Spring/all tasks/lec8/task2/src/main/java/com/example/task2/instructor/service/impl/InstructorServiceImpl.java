package com.example.task2.instructor.service.impl;

import com.example.task2.course.model.Course;
import com.example.task2.instructor.model.Instructor;
import com.example.task2.instructor.repo.InstructorRepo;
import com.example.task2.instructor.service.InstructorService;

import java.util.List;

public class InstructorServiceImpl implements InstructorService {
    private final InstructorRepo instructorRepo;

    public InstructorServiceImpl(InstructorRepo instructorRepo){
        this.instructorRepo = instructorRepo;
    }
    @Override
    public Instructor createInstructor(Instructor instructor) {
        return instructorRepo.save(instructor);
    }

    @Override
    public List<Instructor> getAllInstructors() {
        return instructorRepo.findAll();
    }

    @Override
    public Instructor getInstructorById(Long id) {
        return instructorRepo.findById(id).orElseThrow(()->{
            throw new RuntimeException("instructor not found");
        });
    }

    @Override
    public List<Course> getCoursesByInstructor(Long instructorId) {
        Instructor instructor =  instructorRepo.findById(instructorId)
                .orElseThrow(() -> new RuntimeException("Instructor not found"));
        return instructor.getCourses();
    }
}
