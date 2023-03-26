package com.willydev.schoolapplication.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class CourseDto {

    private Long id;

    private String title;
    private String code;
    private Long materialId;

    private Long teacherId;

    private List<Long> studentIds;

    private List<String> students;

    private String teacherNames;

    private String materialName;
}
