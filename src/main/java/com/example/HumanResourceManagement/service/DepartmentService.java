package com.example.HumanResourceManagement.service;

import com.example.HumanResourceManagement.dao.DepartmentDAO;
import com.example.HumanResourceManagement.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentDAO dao;

    public Department saveDepartment(Department department) {
        return dao.save(department);
    }

    public List<Department> getAllDepartments() {
        return dao.findAll();
    }

    public Department getDepartmentById(Integer id) {
        return dao.findById(id);
    }

    public Department updateDepartment(Integer id, Department department) {   // ✅ NEW METHOD

        Department existing = dao.findById(id);

        if (existing == null) {
            throw new RuntimeException("Department not found with id: " + id);
        }

        existing.setName(department.getName());

        return dao.save(existing);
    }

    public void deleteDepartment(Integer id) {
        dao.deleteById(id);
    }
}