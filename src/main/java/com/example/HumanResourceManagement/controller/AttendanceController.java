package com.example.HumanResourceManagement.controller;

import com.example.HumanResourceManagement.model.Attendance;
import com.example.HumanResourceManagement.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/attendance")
public class AttendanceController {

    @Autowired
    private AttendanceService service;

    @PostMapping
    public Attendance create(@RequestBody Attendance attendance) {
        return service.create(attendance);
    }

    @GetMapping
    public List<Attendance> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Attendance getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping("/emp/{empId}/date/{date}")
    public Attendance getByEmpAndDate(@PathVariable Integer empId,
                                      @PathVariable String date) {
        return service.getByEmpAndDate(empId, LocalDate.parse(date));
    }

    @PutMapping("/{id}")
    public Attendance update(@PathVariable Long id,
                             @RequestBody Attendance attendance) {
        return service.update(id, attendance);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "Attendance deleted successfully";
    }
}