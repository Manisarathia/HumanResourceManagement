package com.example.HumanResourceManagement.controller;

import com.example.HumanResourceManagement.model.Leave;
import com.example.HumanResourceManagement.service.LeaveService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/leaves")
@CrossOrigin(origins = "*")
public class LeaveController {

    private final LeaveService service;

    public LeaveController(LeaveService service) {
        this.service = service;
    }

    @PostMapping
    public Leave applyLeave(@RequestBody Leave leave) {
        return service.applyLeave(leave);
    }

    @GetMapping
    public List<Leave> getAllLeaves() {
        return service.getAllLeaves();
    }

    @GetMapping("/employee/{empId}")
    public List<Leave> getByEmpId(@PathVariable Long empId) {
        return service.getEmployeeLeaves(empId);
    }

    @PutMapping("/{id}")
    public Leave updateLeave(@PathVariable Long id, @RequestBody Leave leave) {
        return service.updateLeave(id, leave);
    }

    @DeleteMapping("/{id}")
    public String deleteLeave(@PathVariable Long id) {
        service.deleteLeave(id);
        return "Leave deleted successfully";
    }
}