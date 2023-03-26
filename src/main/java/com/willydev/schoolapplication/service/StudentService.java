package com.willydev.schoolapplication.service;

import com.willydev.schoolapplication.dto.StudentDto;
import com.willydev.schoolapplication.model.Guardian;
import com.willydev.schoolapplication.model.Student;
import com.willydev.schoolapplication.repository.StudentRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class StudentService {
    private final StudentRepo studentRepo;
    public StudentDto saveStudent(StudentDto studentDto) {

      Student student = StudentDto.mapToEntity(studentDto);

      Student s = studentRepo.save(student);

      return Student.mapToData(s);

    }

    public List<?> getStudents() {
        List<Student> students = studentRepo.findAll();
        return students.stream().map(s -> Student.mapToData(s)).collect(Collectors.toList());
    }

    public Student getStudent(Long id) {
        Optional<Student> student = studentRepo.findById(id);

        if(student.isPresent()){
            return student.get();
        }
        throw new RuntimeException("Id "+ id + " not found");
    }
}
