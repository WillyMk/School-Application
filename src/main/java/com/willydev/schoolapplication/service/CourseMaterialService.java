package com.willydev.schoolapplication.service;

import com.willydev.schoolapplication.dto.CourseMaterialDto;
import com.willydev.schoolapplication.model.CourseMaterial;
import com.willydev.schoolapplication.repository.CourseMaterialRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class CourseMaterialService {

    private final CourseMaterialRepo courseMaterialRepo;

    public CourseMaterialDto saveMaterial(CourseMaterialDto courseMaterialDto) {
        CourseMaterial courseMaterial = CourseMaterialDto.mapToEntity(courseMaterialDto);

        CourseMaterial c = courseMaterialRepo.save(courseMaterial);

        return CourseMaterial.mapToData(c);
    }

    public List<?> getMaterials() {
        List<CourseMaterial> materials = courseMaterialRepo.findAll();
        return materials.stream().map(m -> CourseMaterial.mapToData(m)).collect(Collectors.toList());
    }

    public CourseMaterial getMaterial(Long id) {
        Optional<CourseMaterial> material = courseMaterialRepo.findById(id);
        if(material.isPresent()){
            return  material.get();
        }
        throw new RuntimeException("Id by number " + id + "not found");
    }
}
