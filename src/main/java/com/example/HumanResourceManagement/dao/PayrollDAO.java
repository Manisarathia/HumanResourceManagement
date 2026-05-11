package com.example.HumanResourceManagement.dao;

import com.example.HumanResourceManagement.model.Payroll;
import java.util.List;
import java.util.Optional;

public interface PayrollDAO {

    Payroll save(Payroll payroll);

    List<Payroll> findAll();

    Optional<Payroll> findById(Long id);

    void delete(Long id);

    List<Payroll> findByEmpId(Integer empId);
}