package com.example.HumanResourceManagement.controller;

import com.example.HumanResourceManagement.model.Payroll;
import com.example.HumanResourceManagement.service.PayrollService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payroll")
public class PayrollController {

    @Autowired
    private PayrollService service;

    @PostMapping
    public Payroll create(@RequestBody Payroll payroll) {
        return service.createPayroll(payroll);
    }

    // 🔥 UPDATE
    @PutMapping("/{id}")
    public Payroll update(@PathVariable Long id, @RequestBody Payroll payroll) {
        return service.updatePayroll(id, payroll);
    }

    @GetMapping
    public List<Payroll> getAll() {
        return service.getAllPayrolls();
    }

    @GetMapping("/{id}")
    public Payroll getById(@PathVariable Long id) {
        return service.getPayrollById(id);
    }

    @GetMapping("/employee/{empId}")
    public List<Payroll> getByEmpId(@PathVariable Integer empId) {
        return service.getPayrollByEmpId(empId);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.deletePayroll(id);
        return "Payroll deleted successfully";
    }
}