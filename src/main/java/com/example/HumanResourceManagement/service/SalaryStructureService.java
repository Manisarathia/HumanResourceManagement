package com.example.HumanResourceManagement.service;

import com.example.HumanResourceManagement.model.SalaryStructure;
import java.util.List;

public interface SalaryStructureService {

    SalaryStructure create(SalaryStructure salary);

    List<SalaryStructure> getAll();

    SalaryStructure getById(Long id);

    List<SalaryStructure> getByEmpId(Integer empId);

    SalaryStructure update(Long id, SalaryStructure salary);

    void delete(Long id);
}