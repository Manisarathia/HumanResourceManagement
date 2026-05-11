package com.example.HumanResourceManagement.dao;

import com.example.HumanResourceManagement.model.Attendance;
import com.example.HumanResourceManagement.repository.AttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class AttendanceDAOImpl implements AttendanceDAO {

    @Autowired
    private AttendanceRepository repository;

    @Override
    public Attendance save(Attendance attendance) {
        return repository.save(attendance);
    }

    @Override
    public List<Attendance> findAll() {
        return repository.findAll();
    }

    @Override
    public Attendance findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Attendance findByEmpAndDate(Integer empId, LocalDate date) {
        return repository.findByEmpIdAndAttendanceDate(empId, date).orElse(null);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}