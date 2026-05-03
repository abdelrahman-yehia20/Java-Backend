package com.example.task4.Teacher.controller;

import com.example.task4.Teacher.dto.TeacherDto;
import com.example.task4.Teacher.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/teachers")
public class TeacherController {
    TeacherService teacherService;

    @Autowired
    public TeacherController(TeacherService teacherService){
        this.teacherService = teacherService;
    }

    @PostMapping
    public ResponseEntity<TeacherDto> createTeacher(@RequestBody TeacherDto teacherDto) throws URISyntaxException {
        return ResponseEntity.created(new URI("/teachers/")).body(teacherService.createTeacher(teacherDto));
    }

    @GetMapping
    public ResponseEntity<List<TeacherDto>> getAllTeachers(){
        return ResponseEntity.ok(teacherService.getAllTeachers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeacherDto> getTeacherById(@PathVariable Long id){
        return ResponseEntity.ok(teacherService.getTeacherById(id));
    }

}
