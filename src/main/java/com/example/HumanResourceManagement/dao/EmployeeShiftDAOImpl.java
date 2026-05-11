package com.example.HumanResourceManagement.dao;

import com.example.HumanResourceManagement.model.EmployeeShift;
import com.example.HumanResourceManagement.repository.EmployeeShiftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeShiftDAOImpl implements EmployeeShiftDAO {

    @Autowired
    private EmployeeShiftRepository repository;

    @Override
    public EmployeeShift save(EmployeeShift empShift) {
        return repository.save(empShift);
    }

    @Override
    public List<EmployeeShift> findAll() {
        return repository.findAll();
    }

    @Override
    public EmployeeShift findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}