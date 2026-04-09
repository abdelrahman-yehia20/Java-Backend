package com.example.demo.controller;

import com.example.demo.model.Teacher;
import com.example.demo.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TeacherController {

    TeacherService teacherService;

    @Autowired
    public TeacherController(TeacherService teacherService){
        this.teacherService = teacherService;
    }

    @PostMapping("/save")
    public Teacher createTeacher(@RequestBody Teacher teacher){
        return teacherService.createTeacher(teacher);
    }

    @PutMapping("/update")
    public Teacher updateTeacher(@RequestBody Teacher teacher){
        return teacherService.updateTeacher(teacher);
    }

    @GetMapping("/teachers")
    public List<Teacher> getAllTeachers(){
     return teacherService.getTeachers();
    }

//    @GetMapping("/teachers/id/{id}")
//    public Teacher getTeacherById(@PathVariable("id") Long id){
//        return teacherService.getTeacherById(id);
//    }

    @GetMapping("/teacher")
    public Teacher getTeacherById(@RequestParam("id") Long id){
        return teacherService.getTeacherById(id);
    }

    @DeleteMapping("/teachers/id/{id}")
    public void removeTeacherById(@PathVariable("id") Long id){
         teacherService.removeTeacherById(id);
    }
}
