package com.willydev.schoolapplication.dto;

import com.willydev.schoolapplication.model.Guardian;
import com.willydev.schoolapplication.model.Student;
import lombok.Data;

import java.util.List;

@Data
public class StudentDto {
    private Long id;
    private String firstName;
    private String mobile;
    private String email;
    private String guardianName;
    private String guardianMobile;
    private String guardianEmail;
    private List<String> courseName;

    public static Student mapToEntity(StudentDto studentDto){
        Guardian guardian = new Guardian();
        guardian.setGuardianEmail(studentDto.getGuardianEmail());
        guardian.setGuardianMobile(studentDto.getGuardianMobile());
        guardian.setGuardianName(studentDto.getGuardianName());

        Student student = new Student();
        student.setEmail(studentDto.getEmail());
        student.setFirstName(studentDto.getFirstName());
        student.setMobile(student.getMobile());
        student.setGuardian(guardian);
        return student;
    }
}
