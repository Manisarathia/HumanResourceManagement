package com.example.HumanResourceManagement.dao;

import com.example.HumanResourceManagement.model.LeaveType;

import java.util.List;

public interface LeaveTypeDAO {

    LeaveType save(LeaveType leaveType);

    List<LeaveType> findAll();

    LeaveType findById(Long id);

    LeaveType findByName(String name);

    void delete(Long id);
}