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
        guardian.setGuardian_email(studentDto.getGuardianEmail());
        guardian.setGuardian_mobile(studentDto.getGuardianMobile());
        guardian.setGuardian_name(studentDto.getGuardianName());

        Student student = new Student();
        student.setEmail(studentDto.getEmail());
        student.setFirstName(studentDto.getFirstName());
        student.setMobile(student.getMobile());
        student.setGuardian(guardian);
        return student;
    }
}
