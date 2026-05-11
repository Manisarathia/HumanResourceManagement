package com.example.HumanResourceManagement.dao;

import com.example.HumanResourceManagement.model.Holiday;
import com.example.HumanResourceManagement.repository.HolidayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class HolidayDAOImpl implements HolidayDAO {

    @Autowired
    private HolidayRepository repository;

    @Override
    public Holiday save(Holiday holiday) {
        return repository.save(holiday);
    }

    @Override
    public List<Holiday> findAll() {
        return repository.findAll();
    }

    @Override
    public Holiday findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Holiday findByDate(LocalDate date) {
        return repository.findByDate(date).orElse(null);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}