package com.example.HumanResourceManagement.controller;

import com.example.HumanResourceManagement.model.SalaryStructure;
import com.example.HumanResourceManagement.service.SalaryStructureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/salary")
public class SalaryStructureController {

    @Autowired
    private SalaryStructureService service;

    @PostMapping
    public SalaryStructure create(@RequestBody SalaryStructure salary) {
        return service.create(salary);
    }

    @GetMapping
    public List<SalaryStructure> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public SalaryStructure getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping("/employee/{empId}")
    public List<SalaryStructure> getByEmployee(@PathVariable Integer empId) {
        return service.getByEmpId(empId);
    }

    @PutMapping("/{id}")
    public SalaryStructure update(@PathVariable Long id,
                                  @RequestBody SalaryStructure salary) {
        return service.update(id, salary);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "Salary deleted successfully";
    }
}