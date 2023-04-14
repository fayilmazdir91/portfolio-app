package com.project.portfolioapp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table(name = "contacts")
@Data
public class Contact extends BaseEntity {

    @Column(nullable = false, unique = true)
    @Size(min = 2, max = 50)
    private String fullName;

    @Column(nullable = false, unique = true)
    @Email
    private String email;

    @Column(nullable = false, unique = true)
    @Size(min = 2, max = 200)
    private String message;
}