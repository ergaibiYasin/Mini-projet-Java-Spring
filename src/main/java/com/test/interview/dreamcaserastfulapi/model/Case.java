package com.test.interview.dreamcaserastfulapi.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="case")
public class Case {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "caseId")
    private Long id;

    @Column(name = "creationDate")
    private LocalDateTime creationDate;

    @Column(name = "lastUpdateDate")
    private LocalDateTime lastUpdateDate;

    @Column(name = "title")
    private String title;

    @Column(name = "description", length = 2056)
    private String description;

    public Case() {
    }

    // Constructor to create a new Case object with the given properties
    public Case(LocalDateTime creationDate, LocalDateTime lastUpdateDate, String title, String description) {
        this.creationDate = creationDate;
        this.lastUpdateDate = lastUpdateDate;
        this.title = title;
        this.description = description;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDateTime getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(LocalDateTime lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
