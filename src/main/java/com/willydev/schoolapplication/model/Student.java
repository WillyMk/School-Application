package com.willydev.schoolapplication.model;

import com.willydev.schoolapplication.dto.StudentDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String mobile;
    private String email;

    @Embedded
    private Guardian guardian;

    @ManyToMany(mappedBy = "students", cascade = CascadeType.ALL)
    private List<Course> courses;

    public static StudentDto mapToData(Student student){
        StudentDto studentDto = new StudentDto();
        studentDto.setId(student.getId());
        studentDto.setEmail(student.getEmail());
        studentDto.setFirstName(student.getFirstName());
        studentDto.setMobile(student.getMobile());
        studentDto.setGuardianName(student.getGuardian().getGuardianName());
        studentDto.setGuardianEmail(student.getGuardian().getGuardianEmail());
        studentDto.setGuardianMobile(student.getGuardian().getGuardianMobile());
        if(student.getCourses() != null) {
            List<String> courseNames = new ArrayList<>();
            for (Course course : student.getCourses()) {
                courseNames.add(course.getTitle());
            }
            studentDto.setCourseName(courseNames);
        }
        return studentDto;
    }
}
