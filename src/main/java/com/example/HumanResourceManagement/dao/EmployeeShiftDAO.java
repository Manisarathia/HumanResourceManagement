package com.example.HumanResourceManagement.dao;

import com.example.HumanResourceManagement.model.EmployeeShift;
import java.util.List;

public interface EmployeeShiftDAO {
    EmployeeShift save(EmployeeShift empShift);
    List<EmployeeShift> findAll();
    EmployeeShift findById(Long id);
    void delete(Long id);
}