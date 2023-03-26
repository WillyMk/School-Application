package com.willydev.schoolapplication.model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Guardian {
    private String guardian_name;
    private String guardian_mobile;
    private String guardian_email;
}
