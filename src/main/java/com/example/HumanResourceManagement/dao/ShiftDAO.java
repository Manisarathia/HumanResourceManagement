package com.example.HumanResourceManagement.dao;



import com.example.HumanResourceManagement.model.Shift;
import java.util.List;

public interface ShiftDAO {
    Shift save(Shift shift);
    List<Shift> findAll();
    Shift findById(Long id);
    void delete(Long id);
}