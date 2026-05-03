package com.example.task2.course.model;

import com.example.task2.instructor.model.Instructor;
import com.example.task2.student.model.Student;
import jakarta.persistence.*;

import java.util.List;
@Entity
public class Course {
    private Long id;
    private String title;
    private String description;

    @ManyToMany(mappedBy = "courses")
    private List<Student> students;

    @ManyToOne
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
