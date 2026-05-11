package com.example.HumanResourceManagement.repository;

import com.example.HumanResourceManagement.model.Overtime;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface OvertimeRepository extends JpaRepository<Overtime, Long> {

    List<Overtime> findByEmpId(Integer empId);

    List<Overtime> findByEmpIdAndDate(Integer empId, LocalDate date);
}