package com.example.HumanResourceManagement.service;

import com.example.HumanResourceManagement.dao.HolidayDAO;
import com.example.HumanResourceManagement.model.Holiday;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class HolidayServiceImpl implements HolidayService {

    @Autowired
    private HolidayDAO dao;

    @Override
    public Holiday create(Holiday holiday) {

        // Prevent duplicate holiday on same date
        if (dao.findByDate(holiday.getDate()) != null) {
            throw new RuntimeException("Holiday already exists on this date");
        }

        return dao.save(holiday);
    }

    @Override
    public List<Holiday> getAll() {
        return dao.findAll();
    }

    @Override
    public Holiday getById(Long id) {
        return dao.findById(id);
    }

    @Override
    public Holiday getByDate(LocalDate date) {
        return dao.findByDate(date);
    }

    @Override
    public Holiday update(Long id, Holiday holiday) {

        Holiday existing = dao.findById(id);

        if (existing != null) {
            existing.setName(holiday.getName());
            existing.setDate(holiday.getDate());
            existing.setType(holiday.getType());
            return dao.save(existing);
        }

        return null;
    }

    @Override
    public void delete(Long id) {
        dao.delete(id);
    }
}