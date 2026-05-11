package com.example.HumanResourceManagement.controller;

import com.example.HumanResourceManagement.model.Holiday;
import com.example.HumanResourceManagement.service.HolidayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/holidays")
public class HolidayController {

    @Autowired
    private HolidayService service;

    @PostMapping
    public Holiday create(@RequestBody Holiday holiday) {
        return service.create(holiday);
    }

    @GetMapping
    public List<Holiday> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Holiday getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping("/date/{date}")
    public Holiday getByDate(@PathVariable String date) {
        return service.getByDate(LocalDate.parse(date));
    }

    @PutMapping("/{id}")
    public Holiday update(@PathVariable Long id,
                          @RequestBody Holiday holiday) {
        return service.update(id, holiday);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "Holiday deleted successfully";
    }
}