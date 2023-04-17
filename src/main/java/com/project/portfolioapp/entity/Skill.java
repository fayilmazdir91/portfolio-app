package com.project.portfolioapp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table(name = "skills")
@Data
public class Skill extends BaseEntity {

    @Column(nullable = false)
    @Size(min = 2, max = 50)
    private String name;

    @Column(nullable = false)
    @Size(min = 2, max = 200)
    private String description;

    @Lob
    @Column(name = "image")
    private byte[] image;

    @Column(nullable = false)
    @Min(1)
    @Max(10)
    private int proficiencyLevel;
}
