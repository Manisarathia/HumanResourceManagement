package com.example.HumanResourceManagement.service;

import com.example.HumanResourceManagement.model.Attendance;

import java.time.LocalDate;
import java.util.List;

public interface AttendanceService {

    Attendance create(Attendance attendance);

    List<Attendance> getAll();

    Attendance getById(Long id);

    Attendance getByEmpAndDate(Integer empId, LocalDate date);

    Attendance update(Long id, Attendance attendance);

    void delete(Long id);
}