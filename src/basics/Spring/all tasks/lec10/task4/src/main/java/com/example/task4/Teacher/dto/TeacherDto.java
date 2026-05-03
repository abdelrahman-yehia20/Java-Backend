package com.example.task4.Teacher.dto;

import com.example.task4.student.model.Student;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class TeacherDto {
    private Long id;

    private String name;

    private String email;

    private List<Student> students;
}
