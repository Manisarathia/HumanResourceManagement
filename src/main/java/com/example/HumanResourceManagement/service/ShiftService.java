package com.example.HumanResourceManagement.service;


import com.example.HumanResourceManagement.model.Shift;
import java.util.List;

public interface ShiftService {
    Shift createShift(Shift shift);
    List<Shift> getAllShifts();
    Shift getShiftById(Long id);
    Shift updateShift(Long id, Shift shift);
    void deleteShift(Long id);
}
