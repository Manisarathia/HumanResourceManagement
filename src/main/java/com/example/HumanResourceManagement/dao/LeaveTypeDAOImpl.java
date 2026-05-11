package com.example.HumanResourceManagement.dao;

import com.example.HumanResourceManagement.model.LeaveType;
import com.example.HumanResourceManagement.repository.LeaveTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LeaveTypeDAOImpl implements LeaveTypeDAO {

    @Autowired
    private LeaveTypeRepository repository;

    @Override
    public LeaveType save(LeaveType leaveType) {
        return repository.save(leaveType);
    }

    @Override
    public List<LeaveType> findAll() {
        return repository.findAll();
    }

    @Override
    public LeaveType findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public LeaveType findByName(String name) {
        return repository.findByName(name).orElse(null);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}