package com.example.HumanResourceManagement.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "holidays",
        uniqueConstraints = @UniqueConstraint(columnNames = "date"))
public class Holiday {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true)
    private LocalDate date;

    private String type; // NATIONAL / FESTIVAL / COMPANY

    // Getters & Setters
    public Long getId() { return id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
}