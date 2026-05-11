package com.example.HumanResourceManagement.service;

import com.example.HumanResourceManagement.model.LeaveType;

import java.util.List;

public interface LeaveTypeService {

    LeaveType create(LeaveType leaveType);

    List<LeaveType> getAll();

    LeaveType getById(Long id);

    LeaveType update(Long id, LeaveType leaveType);

    void delete(Long id);
}