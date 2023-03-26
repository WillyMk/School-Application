package com.willydev.schoolapplication.controller;

import com.willydev.schoolapplication.dto.StudentDto;
import com.willydev.schoolapplication.model.Student;
import com.willydev.schoolapplication.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping
    public ResponseEntity<StudentDto> saveStudent(@RequestBody StudentDto studentDto){
        return new ResponseEntity<StudentDto>(studentService.saveStudent(studentDto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<?>> getStudent(){
        return new ResponseEntity<List<?>>(studentService.getStudents(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id){
        return new ResponseEntity<Student>(studentService.getStudent(id), HttpStatus.OK);
    }
}
