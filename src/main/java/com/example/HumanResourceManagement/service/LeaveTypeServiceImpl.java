package com.example.HumanResourceManagement.service;

import com.example.HumanResourceManagement.dao.LeaveTypeDAO;
import com.example.HumanResourceManagement.model.LeaveType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaveTypeServiceImpl implements LeaveTypeService {

    @Autowired
    private LeaveTypeDAO dao;

    @Override
    public LeaveType create(LeaveType leaveType) {

        // Prevent duplicate leave type
        if (dao.findByName(leaveType.getName()) != null) {
            throw new RuntimeException("Leave type already exists");
        }

        return dao.save(leaveType);
    }

    @Override
    public List<LeaveType> getAll() {
        return dao.findAll();
    }

    @Override
    public LeaveType getById(Long id) {
        return dao.findById(id);
    }

    @Override
    public LeaveType update(Long id, LeaveType leaveType) {

        LeaveType existing = dao.findById(id);

        if (existing != null) {
            existing.setName(leaveType.getName());
            existing.setMaxDays(leaveType.getMaxDays());
            return dao.save(existing);
        }

        return null;
    }

    @Override
    public void delete(Long id) {
        dao.delete(id);
    }
}