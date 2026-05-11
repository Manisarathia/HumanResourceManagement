package com.example.HumanResourceManagement.controller;

import com.example.HumanResourceManagement.model.Overtime;
import com.example.HumanResourceManagement.service.OvertimeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/overtime")
public class OvertimeController {

    @Autowired
    private OvertimeService service;

    // CREATE
    @PostMapping
    public Overtime create(@RequestBody Overtime overtime) {
        return service.createOvertime(overtime);
    }

    // UPDATE
    @PutMapping("/{id}")
    public Overtime update(@PathVariable Long id, @RequestBody Overtime overtime) {
        return service.updateOvertime(id, overtime);
    }

    // GET ALL
    @GetMapping
    public List<Overtime> getAll() {
        return service.getAllOvertime();
    }

    // GET BY ID
    @GetMapping("/{id}")
    public Overtime getById(@PathVariable Long id) {
        return service.getById(id);
    }

    // GET BY EMPLOYEE
    @GetMapping("/employee/{empId}")
    public List<Overtime> getByEmpId(@PathVariable Integer empId) {
        return service.getByEmpId(empId);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.deleteOvertime(id);
        return "Overtime deleted successfully";
    }
}