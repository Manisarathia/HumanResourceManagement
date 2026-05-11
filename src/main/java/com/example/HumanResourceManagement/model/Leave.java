package com.example.HumanResourceManagement.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "leaves")
public class Leave {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "emp_id")
    private Long empId;

    @Column(name = "leave_type_id")
    private Long leaveTypeId;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "total_days")
    private Integer totalDays;

    private String reason;

    @Enumerated(EnumType.STRING)
    private LeaveStatus status;

    @Column(name = "applied_on")
    private LocalDateTime appliedOn;

    // Constructors
    public Leave() {}

    // Getters & Setters

    public Long getId() { return id; }
    public Long getEmpId() { return empId; }
    public Long getLeaveTypeId() { return leaveTypeId; }
    public LocalDate getStartDate() { return startDate; }
    public LocalDate getEndDate() { return endDate; }
    public Integer getTotalDays() { return totalDays; }
    public String getReason() { return reason; }
    public LeaveStatus getStatus() { return status; }
    public LocalDateTime getAppliedOn() { return appliedOn; }

    public void setId(Long id) { this.id = id; }
    public void setEmpId(Long empId) { this.empId = empId; }
    public void setLeaveTypeId(Long leaveTypeId) { this.leaveTypeId = leaveTypeId; }
    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }
    public void setEndDate(LocalDate endDate) { this.endDate = endDate; }
    public void setTotalDays(Integer totalDays) { this.totalDays = totalDays; }
    public void setReason(String reason) { this.reason = reason; }
    public void setStatus(LeaveStatus status) { this.status = status; }
    public void setAppliedOn(LocalDateTime appliedOn) { this.appliedOn = appliedOn; }
}