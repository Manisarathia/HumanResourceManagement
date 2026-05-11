package com.example.HumanResourceManagement.repository;

import com.example.HumanResourceManagement.model.Leave;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LeaveRepository extends JpaRepository<Leave, Long> {

    List<Leave> findByEmpId(Long empId);
}