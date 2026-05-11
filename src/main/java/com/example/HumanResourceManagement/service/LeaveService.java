package com.example.HumanResourceManagement.service;

import com.example.HumanResourceManagement.model.Leave;
import com.example.HumanResourceManagement.model.LeaveStatus;
import com.example.HumanResourceManagement.repository.LeaveRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class LeaveService {

    private final LeaveRepository repo;

    public LeaveService(LeaveRepository repo) {
        this.repo = repo;
    }

    // CREATE
    public Leave applyLeave(Leave leave) {
        leave.setStatus(LeaveStatus.PENDING);
        leave.setAppliedOn(LocalDateTime.now());
        return repo.save(leave);
    }

    // READ ALL
    public List<Leave> getAllLeaves() {
        return repo.findAll();
    }

    // READ BY EMP ID
    public List<Leave> getEmployeeLeaves(Long empId) {
        return repo.findByEmpId(empId);
    }

    // UPDATE
    public Leave updateLeave(Long id, Leave updatedLeave) {
        Leave leave = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Leave not found"));

        leave.setStartDate(updatedLeave.getStartDate());
        leave.setEndDate(updatedLeave.getEndDate());
        leave.setTotalDays(updatedLeave.getTotalDays());
        leave.setReason(updatedLeave.getReason());
        leave.setStatus(updatedLeave.getStatus());

        return repo.save(leave);
    }

    // DELETE
    public void deleteLeave(Long id) {
        repo.deleteById(id);
    }
}