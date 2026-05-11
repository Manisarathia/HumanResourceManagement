package com.example.HumanResourceManagement.dao;


import com.example.HumanResourceManagement.model.Department;
import com.example.HumanResourceManagement.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DepartmentDAOImpl implements DepartmentDAO {

    @Autowired
    private DepartmentRepository repository;

    public Department save(Department department) {
        return repository.save(department);
    }

    public List<Department> findAll() {
        return repository.findAll();
    }

    public Department findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
