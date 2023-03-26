package com.willydev.schoolapplication.model;

import com.willydev.schoolapplication.dto.CourseDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String code;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "material_id", referencedColumnName = "id")
    private CourseMaterial material;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "student_course",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private List<Student> students;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "teacher_id", referencedColumnName = "id")
    private Teacher teachers;

    public static CourseDto mapToData(Course course){
        CourseDto courseDto = new CourseDto();
        courseDto.setId(course.getId());
        courseDto.setTitle(course.getTitle());
        courseDto.setCode(course.getCode());
        if(course.getTeachers() != null) {
            courseDto.setTeacherNames(course.getTeachers().getName());
        }
        if(course.getMaterial() != null) {
            courseDto.setMaterialName(course.getMaterial().getName());
        }
        if(course.getStudents() != null) {
            List<String> students = new ArrayList<>();
            List<Student> s = course.getStudents();
            for (Student student : s) {
                students.add(student.getFirstName());
            }
            courseDto.setStudents(students);
        }
        return courseDto;
    }

}
