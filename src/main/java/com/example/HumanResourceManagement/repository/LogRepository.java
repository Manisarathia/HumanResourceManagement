package com.example.HumanResourceManagement.repository;

import com.example.HumanResourceManagement.model.Log;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LogRepository extends JpaRepository<Log, Long> {

    List<Log> findByEmpId(Integer empId);
}