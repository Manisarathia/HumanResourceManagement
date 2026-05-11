package com.example.HumanResourceManagement.repository;

import com.example.HumanResourceManagement.model.Payroll;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PayrollRepository extends JpaRepository<Payroll, Long> {

    List<Payroll> findByEmpId(Integer empId);

    List<Payroll> findByMonthAndYear(Integer month, Integer year);
}