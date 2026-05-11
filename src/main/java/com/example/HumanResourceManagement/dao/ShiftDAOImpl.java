package com.example.HumanResourceManagement.dao;


import com.example.HumanResourceManagement.model.Shift;
import com.example.HumanResourceManagement.repository.ShiftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ShiftDAOImpl implements ShiftDAO {

    @Autowired
    private ShiftRepository repository;

    @Override
    public Shift save(Shift shift) {
        return repository.save(shift);
    }

    @Override
    public List<Shift> findAll() {
        return repository.findAll();
    }

    @Override
    public Shift findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
