package com.example.HumanResourceManagement.dao;

import com.example.HumanResourceManagement.model.Designation;
import com.example.HumanResourceManagement.repository.DesignationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DesignationDAOImpl implements DesignationDAO {

    @Autowired
    private DesignationRepository repository;

    @Override
    public Designation save(Designation designation) {
        return repository.save(designation);
    }

    @Override
    public List<Designation> findAll() {
        return repository.findAll();
    }

    @Override
    public Designation findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
