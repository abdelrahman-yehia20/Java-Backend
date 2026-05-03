package com.example.task4.student.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentDto {

    private Long id;

    private String name;

    private String email;

    private Long teacherId;
}
