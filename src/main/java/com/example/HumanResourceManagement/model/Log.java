package com.example.HumanResourceManagement.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "logs")
public class Log {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "emp_id", nullable = false)
    private Integer empId;

    @Column(name = "log_time")
    private LocalDateTime logTime;

    @Column(name = "type")
    private String type; // IN / OUT

    // 🔥 UPDATE METHOD (helper)
    public void updateFrom(Log log) {
        this.empId = log.getEmpId();
        this.logTime = log.getLogTime();
        this.type = log.getType();
    }

    // Getters & Setters
    public Long getId() { return id; }

    public Integer getEmpId() { return empId; }
    public void setEmpId(Integer empId) { this.empId = empId; }

    public LocalDateTime getLogTime() { return logTime; }
    public void setLogTime(LocalDateTime logTime) { this.logTime = logTime; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
}