package com.example.HumanResourceManagement.service;

import com.example.HumanResourceManagement.dao.DesignationDAO;
import com.example.HumanResourceManagement.model.Designation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DesignationServiceImpl implements DesignationService {

    @Autowired
    private DesignationDAO dao;

    @Override
    public Designation create(Designation designation) {
        return dao.save(designation);
    }

    @Override
    public List<Designation> getAll() {
        return dao.findAll();
    }

    @Override
    public Designation getById(Long id) {
        return dao.findById(id);
    }

    @Override
    public Designation update(Long id, Designation designation) {
        Designation existing = dao.findById(id);
        if (existing != null) {
            existing.setTitle(designation.getTitle());
            return dao.save(existing);
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        dao.delete(id);
    }
}
