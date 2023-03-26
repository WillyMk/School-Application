package com.willydev.schoolapplication.controller;

import com.willydev.schoolapplication.dto.CourseDto;
import com.willydev.schoolapplication.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @PostMapping
    public ResponseEntity<CourseDto> saveCourse(@RequestBody CourseDto courseDto){
        return new ResponseEntity<CourseDto>(courseService.saveCourse(courseDto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<?>> getCourses(){
        return new ResponseEntity<List<?>>(courseService.getCourses(), HttpStatus.OK);
    }
}
