package com.willydev.schoolapplication.model;

import com.willydev.schoolapplication.dto.CourseMaterialDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CourseMaterial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public static CourseMaterialDto mapToData(CourseMaterial courseMaterial){
        CourseMaterialDto c = new CourseMaterialDto();
        c.setId(courseMaterial.getId());
        c.setName(courseMaterial.getName());
        return c;
    }
}
