package com.example.HumanResourceManagement.dao;

import com.example.HumanResourceManagement.model.Log;
import com.example.HumanResourceManagement.repository.LogRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class LogDAOImpl implements LogDAO {

    @Autowired
    private LogRepository repository;

    @Override
    public Log save(Log log) {
        return repository.save(log);
    }

    @Override
    public List<Log> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Log> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<Log> findByEmpId(Integer empId) {
        return repository.findByEmpId(empId);
    }
}