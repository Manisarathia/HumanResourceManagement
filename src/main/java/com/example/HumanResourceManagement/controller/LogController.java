package com.example.HumanResourceManagement.controller;

import com.example.HumanResourceManagement.model.Log;
import com.example.HumanResourceManagement.service.LogService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/logs")
public class LogController {

    @Autowired
    private LogService service;

    // CREATE
    @PostMapping
    public Log create(@RequestBody Log log) {
        return service.createLog(log);
    }

    // UPDATE
    @PutMapping("/{id}")
    public Log update(@PathVariable Long id, @RequestBody Log log) {
        return service.updateLog(id, log);
    }

    // GET ALL
    @GetMapping
    public List<Log> getAll() {
        return service.getAllLogs();
    }

    // GET BY ID
    @GetMapping("/{id}")
    public Log getById(@PathVariable Long id) {
        return service.getLogById(id);
    }

    // GET BY EMPLOYEE
    @GetMapping("/employee/{empId}")
    public List<Log> getByEmpId(@PathVariable Integer empId) {
        return service.getLogsByEmpId(empId);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.deleteLog(id);
        return "Log deleted successfully";
    }
}