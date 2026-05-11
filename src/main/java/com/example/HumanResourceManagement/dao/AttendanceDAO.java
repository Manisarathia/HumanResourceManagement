package com.example.HumanResourceManagement.dao;

import com.example.HumanResourceManagement.model.Attendance;

import java.time.LocalDate;
import java.util.List;

public interface AttendanceDAO {

    Attendance save(Attendance attendance);

    List<Attendance> findAll();

    Attendance findById(Long id);

    Attendance findByEmpAndDate(Integer empId, LocalDate date);

    void delete(Long id);
}