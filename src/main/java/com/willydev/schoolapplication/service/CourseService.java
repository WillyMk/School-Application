package com.willydev.schoolapplication.service;

import com.willydev.schoolapplication.dto.CourseDto;
import com.willydev.schoolapplication.dto.CourseMaterialDto;
import com.willydev.schoolapplication.model.Course;
import com.willydev.schoolapplication.model.CourseMaterial;
import com.willydev.schoolapplication.model.Student;
import com.willydev.schoolapplication.model.Teacher;
import com.willydev.schoolapplication.repository.CourseRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class CourseService {

    private final CourseRepo courseRepo;
    private final CourseMaterialService courseMaterialService;

    private final  TeacherService teacherService;

    private final StudentService studentService;

    public CourseDto saveCourse(CourseDto courseDto) {
        Course course = new Course();
        course.setCode(courseDto.getCode());
        course.setTitle(courseDto.getTitle());
        if(courseDto.getMaterialId() == null){
            throw new IllegalArgumentException("You need to input a mateial");
        }

        CourseMaterial c = courseMaterialService.getMaterial(courseDto.getMaterialId());
        course.setMaterial(c);

        Teacher teacher = teacherService.getTeacher(courseDto.getTeacherId());
        course.setTeachers(teacher);

        List<Student> studentIds = new ArrayList<>();
        for(Long studentId: courseDto.getStudentIds()){
            Student student = studentService.getStudent(studentId);
            studentIds.add(student);
        }

        course.setStudents(studentIds);

        Course courseData = courseRepo.save(course);

        return Course.mapToData(courseData);
    }

    public List<?> getCourses() {
        List<Course> courses = courseRepo.findAll();
        return courses.stream().map(c -> Course.mapToData(c)).collect(Collectors.toList());
    }
}
