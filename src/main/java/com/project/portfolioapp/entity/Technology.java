package com.project.portfolioapp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Set;

@Entity
@Table(name = "technologies")
@Data
public class Technology extends BaseEntity {

    @Column(nullable = false)
    @Size(min = 2, max = 50)
    private String name;

    @Column(nullable = false)
    @Size(min = 2, max = 200)
    private String description;

    private String url;

    @ManyToMany(mappedBy = "technologies")
    private Set<Project> projects;
}
