package com.example.HumanResourceManagement.service;

import com.example.HumanResourceManagement.dao.EmployeeShiftDAO;
import com.example.HumanResourceManagement.model.EmployeeShift;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeShiftServiceImpl implements EmployeeShiftService {

    @Autowired
    private EmployeeShiftDAO dao;

    @Override
    public EmployeeShift create(EmployeeShift empShift) {
        return dao.save(empShift);
    }

    @Override
    public List<EmployeeShift> getAll() {
        return dao.findAll();
    }

    @Override
    public EmployeeShift getById(Long id) {
        return dao.findById(id);
    }

    @Override
    public EmployeeShift update(Long id, EmployeeShift empShift) {
        EmployeeShift existing = dao.findById(id);
        if (existing != null) {
            existing.setEmpId(empShift.getEmpId());
            existing.setShiftId(empShift.getShiftId());
            existing.setEffectiveFrom(empShift.getEffectiveFrom());
            existing.setEffectiveTo(empShift.getEffectiveTo());
            return dao.save(existing);
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        dao.delete(id);
    }
}