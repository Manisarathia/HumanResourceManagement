package com.example.HumanResourceManagement.service;

import com.example.HumanResourceManagement.model.Designation;
import java.util.List;

public interface DesignationService {
    Designation create(Designation designation);
    List<Designation> getAll();
    Designation getById(Long id);
    Designation update(Long id, Designation designation);
    void delete(Long id);
}