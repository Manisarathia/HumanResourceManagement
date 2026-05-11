package com.example.HumanResourceManagement.controller;

import com.example.HumanResourceManagement.model.EmployeeShift;
import com.example.HumanResourceManagement.service.EmployeeShiftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee-shifts")
public class EmployeeShiftController {

    @Autowired
    private EmployeeShiftService service;

    @PostMapping
    public EmployeeShift create(@RequestBody EmployeeShift empShift) {
        return service.create(empShift);
    }

    @GetMapping
    public List<EmployeeShift> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public EmployeeShift getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public EmployeeShift update(@PathVariable Long id, @RequestBody EmployeeShift empShift) {
        return service.update(id, empShift);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "Employee Shift deleted successfully";
    }
}