package com.example.HumanResourceManagement.dao;

import com.example.HumanResourceManagement.model.Overtime;
import com.example.HumanResourceManagement.repository.OvertimeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class OvertimeDAOImpl implements OvertimeDAO {

    @Autowired
    private OvertimeRepository repository;

    @Override
    public Overtime save(Overtime overtime) {
        return repository.save(overtime);
    }

    @Override
    public List<Overtime> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Overtime> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<Overtime> findByEmpId(Integer empId) {
        return repository.findByEmpId(empId);
    }
}