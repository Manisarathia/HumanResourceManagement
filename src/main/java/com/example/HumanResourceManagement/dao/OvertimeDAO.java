package com.example.HumanResourceManagement.dao;

import com.example.HumanResourceManagement.model.Overtime;

import java.util.List;
import java.util.Optional;

public interface OvertimeDAO {

    Overtime save(Overtime overtime);

    List<Overtime> findAll();

    Optional<Overtime> findById(Long id);

    void delete(Long id);

    List<Overtime> findByEmpId(Integer empId);
}