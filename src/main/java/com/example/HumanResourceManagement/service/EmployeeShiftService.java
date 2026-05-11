package com.example.HumanResourceManagement.service;

import com.example.HumanResourceManagement.model.EmployeeShift;
import java.util.List;

public interface EmployeeShiftService {
    EmployeeShift create(EmployeeShift empShift);
    List<EmployeeShift> getAll();
    EmployeeShift getById(Long id);
    EmployeeShift update(Long id, EmployeeShift empShift);
    void delete(Long id);
}