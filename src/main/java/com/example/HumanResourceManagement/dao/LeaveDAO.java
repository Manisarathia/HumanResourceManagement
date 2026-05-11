package com.example.HumanResourceManagement.dao;

import com.example.HumanResourceManagement.model.Leave;
import com.example.HumanResourceManagement.model.LeaveStatus;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface LeaveDAO {

    Leave save(Leave leave);

    Optional<Leave> findById(Long id);

    List<Leave> findAll();

    void deleteById(Long id);

    List<Leave> findByEmpId(Long empId);

    List<Leave> findByStatus(LeaveStatus status);

    List<Leave> findByEmpIdAndStatus(Long empId, LeaveStatus status);

    List<Leave> findByStartDateBetween(LocalDate start, LocalDate end);
}