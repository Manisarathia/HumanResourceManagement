package com.example.HumanResourceManagement.dao;


import com.example.HumanResourceManagement.model.Department;
import java.util.List;

public interface DepartmentDAO {

    Department save(Department department);

    List<Department> findAll();

    Department findById(Integer id);

    void deleteById(Integer id);
}
