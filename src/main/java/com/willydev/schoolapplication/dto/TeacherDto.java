package com.willydev.schoolapplication.dto;

import com.willydev.schoolapplication.model.Teacher;
import lombok.Data;

import java.util.List;

@Data
public class TeacherDto {

    private Long id;

    private String name;

    private List<String> courseName;

    public static Teacher mapToEntity(TeacherDto teacherDto){
        Teacher teacher = new Teacher();
        teacher.setName(teacherDto.getName());
        return teacher;
    }
}
