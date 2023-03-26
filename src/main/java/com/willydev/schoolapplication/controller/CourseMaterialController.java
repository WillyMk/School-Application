package com.willydev.schoolapplication.controller;

import com.willydev.schoolapplication.dto.CourseDto;
import com.willydev.schoolapplication.dto.CourseMaterialDto;
import com.willydev.schoolapplication.model.CourseMaterial;
import com.willydev.schoolapplication.service.CourseMaterialService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/material")
@RequiredArgsConstructor
public class CourseMaterialController {

    private final CourseMaterialService courseMaterialService;

    @PostMapping
    public ResponseEntity<CourseMaterialDto> saveMaterial(@RequestBody CourseMaterialDto courseMaterialDto){
        return new ResponseEntity<CourseMaterialDto>(courseMaterialService.saveMaterial(courseMaterialDto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<?>> getMaterials(){
        return new ResponseEntity<List<?>>(courseMaterialService.getMaterials(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseMaterial> getMaterial(@PathVariable Long id){
        return new ResponseEntity<CourseMaterial>(courseMaterialService.getMaterial(id), HttpStatus.OK);
    }
}
