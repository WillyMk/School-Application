package com.willydev.schoolapplication.dto;

import com.willydev.schoolapplication.model.CourseMaterial;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CourseMaterialDto {
    private Long id;
    private String name;

    public static CourseMaterial mapToEntity(CourseMaterialDto courseMaterialDto){
        CourseMaterial c = new CourseMaterial();
        c.setName(courseMaterialDto.getName());
        return c;
    }
}
