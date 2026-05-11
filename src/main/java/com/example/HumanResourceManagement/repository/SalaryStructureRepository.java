package com.example.HumanResourceManagement.repository;

import com.example.HumanResourceManagement.model.SalaryStructure;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SalaryStructureRepository extends JpaRepository<SalaryStructure, Long> {

    List<SalaryStructure> findByEmpId(Integer empId);
}