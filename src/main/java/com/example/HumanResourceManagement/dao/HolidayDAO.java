package com.example.HumanResourceManagement.dao;

import com.example.HumanResourceManagement.model.Holiday;

import java.time.LocalDate;
import java.util.List;

public interface HolidayDAO {

    Holiday save(Holiday holiday);

    List<Holiday> findAll();

    Holiday findById(Long id);

    Holiday findByDate(LocalDate date);

    void delete(Long id);
}