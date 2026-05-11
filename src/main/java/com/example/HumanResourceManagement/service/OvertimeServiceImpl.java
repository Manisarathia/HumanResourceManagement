package com.example.HumanResourceManagement.service;

import com.example.HumanResourceManagement.dao.OvertimeDAO;
import com.example.HumanResourceManagement.model.Overtime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OvertimeServiceImpl implements OvertimeService {

    @Autowired
    private OvertimeDAO dao;

    // CREATE
    @Override
    public Overtime createOvertime(Overtime overtime) {
        return dao.save(overtime);
    }

    // UPDATE
    @Override
    public Overtime updateOvertime(Long id, Overtime updated) {

        Overtime existing = dao.findById(id)
                .orElseThrow(() -> new RuntimeException("Overtime not found"));

        // 🔥 using entity method
        existing.updateFrom(updated);

        return dao.save(existing);
    }

    // READ ALL
    @Override
    public List<Overtime> getAllOvertime() {
        return dao.findAll();
    }

    // READ BY ID
    @Override
    public Overtime getById(Long id) {
        return dao.findById(id)
                .orElseThrow(() -> new RuntimeException("Overtime not found"));
    }

    // DELETE
    @Override
    public void deleteOvertime(Long id) {
        dao.delete(id);
    }

    // BY EMP ID
    @Override
    public List<Overtime> getByEmpId(Integer empId) {
        return dao.findByEmpId(empId);
    }
}