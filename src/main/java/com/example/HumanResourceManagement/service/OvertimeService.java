package com.example.HumanResourceManagement.service;

import com.example.HumanResourceManagement.model.Overtime;

import java.util.List;

public interface OvertimeService {

    Overtime createOvertime(Overtime overtime);

    Overtime updateOvertime(Long id, Overtime overtime);

    List<Overtime> getAllOvertime();

    Overtime getById(Long id);

    void deleteOvertime(Long id);

    List<Overtime> getByEmpId(Integer empId);
}