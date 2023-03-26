package com.willydev.schoolapplication.model;

import com.willydev.schoolapplication.dto.TeacherDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "teachers")
    private List<Course> courses;

    public static TeacherDto mapToData(Teacher teacher){
        TeacherDto teacherDto = new TeacherDto();
        teacherDto.setId(teacher.getId());
        teacherDto.setName(teacher.getName());
        if(teacher.getCourses() != null) {
            List<String> courseTitle = new ArrayList<>();
            for (Course c : teacher.getCourses()) {
                courseTitle.add(c.getTitle());
            }
            teacherDto.setCourseName(courseTitle);
        }
        return teacherDto;
    }
}
