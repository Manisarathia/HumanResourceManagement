package com.example.HumanResourceManagement.controller;

import com.example.HumanResourceManagement.model.Designation;
import com.example.HumanResourceManagement.service.DesignationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/designations")
public class DesignationController {

    @Autowired
    private DesignationService service;

    @PostMapping
    public Designation create(@RequestBody Designation designation) {
        return service.create(designation);
    }

    @GetMapping
    public List<Designation> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Designation getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public Designation update(@PathVariable Long id, @RequestBody Designation designation) {
        return service.update(id, designation);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
