package com.project.portfolioapp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "certifications")
@Data
public class Certification extends BaseEntity {

    @Column(nullable = false, unique = true)
    @Size(min = 2, max = 50)
    private String name;

    @Column(nullable = false, unique = true)
    @Size(min = 2, max = 200)
    private String description;

    @Column(nullable = false, unique = true)
    private LocalDate certificationDate;
}