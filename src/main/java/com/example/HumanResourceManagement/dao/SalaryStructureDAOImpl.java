package com.example.HumanResourceManagement.dao;

import com.example.HumanResourceManagement.model.SalaryStructure;
import com.example.HumanResourceManagement.repository.SalaryStructureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SalaryStructureDAOImpl implements SalaryStructureDAO {

    @Autowired
    private SalaryStructureRepository repository;

    @Override
    public SalaryStructure save(SalaryStructure salary) {
        return repository.save(salary);
    }

    @Override
    public List<SalaryStructure> findAll() {
        return repository.findAll();
    }

    @Override
    public SalaryStructure findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<SalaryStructure> findByEmpId(Integer empId) {
        return repository.findByEmpId(empId);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}