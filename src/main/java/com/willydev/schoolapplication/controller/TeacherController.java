package com.willydev.schoolapplication.controller;

import com.willydev.schoolapplication.dto.TeacherDto;
import com.willydev.schoolapplication.model.Teacher;
import com.willydev.schoolapplication.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teacher")
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherService teacherService;

    @PostMapping
    public ResponseEntity<TeacherDto> saveTeacher(@RequestBody TeacherDto teacherDto){
        return new ResponseEntity<TeacherDto>(teacherService.saveTeacher(teacherDto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<?>> getTeachers(){
        return new ResponseEntity<List<?>>(teacherService.getTeachers(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Teacher> getTeacher(@PathVariable Long id){
        return new ResponseEntity<Teacher>(teacherService.getTeacher(id), HttpStatus.OK);
    }
}
