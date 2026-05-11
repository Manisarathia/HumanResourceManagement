package com.example.HumanResourceManagement.dao;

import com.example.HumanResourceManagement.model.SalaryStructure;
import java.util.List;

public interface SalaryStructureDAO {

    SalaryStructure save(SalaryStructure salary);

    List<SalaryStructure> findAll();

    SalaryStructure findById(Long id);

    List<SalaryStructure> findByEmpId(Integer empId);

    void delete(Long id);
}