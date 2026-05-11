package com.example.HumanResourceManagement.service;

import com.example.HumanResourceManagement.model.Holiday;

import java.time.LocalDate;
import java.util.List;

public interface HolidayService {

    Holiday create(Holiday holiday);

    List<Holiday> getAll();

    Holiday getById(Long id);

    Holiday getByDate(LocalDate date);

    Holiday update(Long id, Holiday holiday);

    void delete(Long id);
}