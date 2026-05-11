package com.example.HumanResourceManagement.controller;


import com.example.HumanResourceManagement.model.Shift;
import com.example.HumanResourceManagement.service.ShiftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shifts")
public class ShiftController {

    @Autowired
    private ShiftService service;

    @PostMapping
    public Shift create(@RequestBody Shift shift) {
        return service.createShift(shift);
    }

    @GetMapping
    public List<Shift> getAll() {
        return service.getAllShifts();
    }

    @GetMapping("/{id}")
    public Shift getById(@PathVariable Long id) {
        return service.getShiftById(id);
    }

    @PutMapping("/{id}")
    public Shift update(@PathVariable Long id, @RequestBody Shift shift) {
        return service.updateShift(id, shift);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.deleteShift(id);
        return "Shift deleted successfully";
    }
}
