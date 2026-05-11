package com.example.HumanResourceManagement.dao;


import com.example.HumanResourceManagement.model.Designation;
import java.util.List;

public interface DesignationDAO {
    Designation save(Designation designation);
    List<Designation> findAll();
    Designation findById(Long id);
    void delete(Long id);
}
