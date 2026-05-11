package com.example.HumanResourceManagement.controller;

import com.example.HumanResourceManagement.model.LeaveType;
import com.example.HumanResourceManagement.service.LeaveTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/leave-types")
public class LeaveTypeController {

    @Autowired
    private LeaveTypeService service;

    @PostMapping
    public LeaveType create(@RequestBody LeaveType leaveType) {
        return service.create(leaveType);
    }

    @GetMapping
    public List<LeaveType> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public LeaveType getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public LeaveType update(@PathVariable Long id,
                            @RequestBody LeaveType leaveType) {
        return service.update(id, leaveType);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "Leave type deleted successfully";
    }
}