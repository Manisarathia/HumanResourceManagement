package com.example.HumanResourceManagement.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "overtime")
public class Overtime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "emp_id", nullable = false)
    private Integer empId;

    @Column(precision = 5, scale = 2)
    private BigDecimal hours;

    private LocalDate date;

    // 🔥 UPDATE METHOD
    public void updateFrom(Overtime ot) {
        this.empId = ot.getEmpId();
        this.hours = ot.getHours();
        this.date = ot.getDate();
    }

    // Getters & Setters
    public Long getId() { return id; }

    public Integer getEmpId() { return empId; }
    public void setEmpId(Integer empId) { this.empId = empId; }

    public BigDecimal getHours() { return hours; }
    public void setHours(BigDecimal hours) { this.hours = hours; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }
}