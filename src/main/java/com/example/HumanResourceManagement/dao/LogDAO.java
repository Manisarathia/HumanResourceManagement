package com.example.HumanResourceManagement.dao;

import com.example.HumanResourceManagement.model.Log;

import java.util.List;
import java.util.Optional;

public interface LogDAO {

    Log save(Log log);

    List<Log> findAll();

    Optional<Log> findById(Long id);

    void delete(Long id);

    List<Log> findByEmpId(Integer empId);
}