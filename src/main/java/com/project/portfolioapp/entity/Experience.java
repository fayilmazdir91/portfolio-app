package com.project.portfolioapp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "experiences")
@Data
public class Experience extends BaseEntity {

    @Column(nullable = false)
    @Size(min = 2, max = 50)
    private String title;

    @Size(min = 2, max = 200)
    private String description;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Lob
    @Column(name = "image")
    private byte[] image;
}
