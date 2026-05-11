package com.example.HumanResourceManagement.service;

import com.example.HumanResourceManagement.dao.EmployeeDAO;
import com.example.HumanResourceManagement.model.Employee;
import com.example.HumanResourceManagement.model.EmpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeDAO dao;

    // ✅ CREATE
    public Employee saveEmployee(Employee employee) {

        // Business Logic
        employee.setCreatedAt(LocalDateTime.now());

        if (employee.getStatus() == null) {
            employee.setStatus(EmpStatus.ACTIVE);   // ✔ cleaner way
        }

        return dao.save(employee);
    }

    // ✅ GET ALL
    public List<Employee> getAllEmployees() {
        return dao.findAll();
    }

    // ✅ GET BY ID
    public Employee getEmployeeById(Long id) {
        return dao.findById(id).orElse(null);
    }

    // ✅ UPDATE (NEW METHOD)
    public Employee updateEmployee(Long id, Employee employee) {

        Employee existing = dao.findById(id).orElse(null);

        if (existing == null) {
            throw new RuntimeException("Employee not found with id: " + id);
        }

        // Update fields
        existing.setEmpCode(employee.getEmpCode());
        existing.setFirstName(employee.getFirstName());
        existing.setLastName(employee.getLastName());
        existing.setEmail(employee.getEmail());
        existing.setPhone(employee.getPhone());
        existing.setDepartmentId(employee.getDepartmentId());
        existing.setDesignationId(employee.getDesignationId());
        existing.setJoinDate(employee.getJoinDate());
        existing.setStatus(employee.getStatus());

        return dao.save(existing);
    }

    // ✅ DELETE
    public void deleteEmployee(Long id) {
        dao.deleteById(id);
    }
}