package com.project.portfolioapp.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name= "projects")
@Data
public class Project extends BaseEntity {

    @Column(nullable = false)
    @Size(min = 2, max = 50)
    private String name;

    @Column(nullable = false)
    @Size(min = 2, max = 200)
    private String description;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(nullable = false)
    @Size(min = 2, max = 200)
    private String url;

    @Lob
    @Column(name = "image")
    private byte[] image;

    @ManyToMany
    @JoinTable(
            name = "project_technologies",
            joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "technology_id"))
    private Set<Technology> technologies;
}
