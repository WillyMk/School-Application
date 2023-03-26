package com.willydev.schoolapplication.service;

import com.willydev.schoolapplication.dto.TeacherDto;
import com.willydev.schoolapplication.model.Teacher;
import com.willydev.schoolapplication.repository.TeacherRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class TeacherService {

    private final TeacherRepo teacherRepo;

    public TeacherDto saveTeacher(TeacherDto teacherDto) {
        Teacher teacher = TeacherDto.mapToEntity(teacherDto);

        Teacher t = teacherRepo.save(teacher);

        return Teacher.mapToData(t);
    }

    public List<?> getTeachers() {
        List<Teacher> teachers = teacherRepo.findAll();
        return teachers.stream().map(t -> Teacher.mapToData(t)).collect(Collectors.toList());
    }

    public Teacher getTeacher(Long id) {
        Optional<Teacher> teacher = teacherRepo.findById(id);

        if(teacher.isPresent()){
            return teacher.get();
        }

        throw new RuntimeException("Id not fund");
    }
}
