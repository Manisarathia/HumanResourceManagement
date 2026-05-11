package com.example.HumanResourceManagement.dao;

import com.example.HumanResourceManagement.model.Payroll;
import com.example.HumanResourceManagement.repository.PayrollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PayrollDAOImpl implements PayrollDAO {

    @Autowired
    private PayrollRepository repository;

    public Payroll save(Payroll payroll) {
        return repository.save(payroll);
    }

    public List<Payroll> findAll() {
        return repository.findAll();
    }

    public Optional<Payroll> findById(Long id) {
        return repository.findById(id);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public List<Payroll> findByEmpId(Integer empId) {
        return repository.findByEmpId(empId);
    }
}