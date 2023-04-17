package com.project.portfolioapp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "educations")
@Data
public class Education extends BaseEntity{

    @Column(nullable = false)
    @Size(min = 2, max = 50)
    private String institution;

    @Column(nullable = false)
    @Size(min = 2, max = 100)
    private String degree;

    @Column(nullable = false)
    @Size(min = 2, max = 50)
    private String field;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    private String description;

    @Lob
    @Column(name = "image")
    private byte[] image;
}
