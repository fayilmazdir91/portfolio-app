package com.project.portfolioapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Table(name = "users")
@NoArgsConstructor
public class User extends BaseEntity{

    public User(String email, String password, String firstName, String lastName, String title, String about) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.about = about;
    }

    public User(Long id, String email, String password, String firstName, String lastName, String title, String about) {
        this.setId(id);
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.about = about;
    }

    @Column(nullable = false, unique = true)
    @Email
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String about;

    @OneToMany
    @JsonIgnore
    private List<Skill> skills;

    @OneToMany
    @JsonIgnore
    private List<Project> projects;

    @OneToMany
    @JsonIgnore
    private List<Language> languages;

    @OneToMany
    @JsonIgnore
    private List<Experience> experiences;

    @OneToMany
    @JsonIgnore
    private List<Education> educations;

    @OneToMany
    @JsonIgnore
    private List<Certification> certifications;

    @OneToOne
    @JoinColumn(name = "contact_id")
    private Contact contact;



}
