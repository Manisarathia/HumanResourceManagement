package com.example.HumanResourceManagement.service;



import com.example.HumanResourceManagement.dao.ShiftDAO;
import com.example.HumanResourceManagement.model.Shift;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShiftServiceImpl implements ShiftService {

    @Autowired
    private ShiftDAO dao;

    @Override
    public Shift createShift(Shift shift) {
        return dao.save(shift);
    }

    @Override
    public List<Shift> getAllShifts() {
        return dao.findAll();
    }

    @Override
    public Shift getShiftById(Long id) {
        return dao.findById(id);
    }

    @Override
    public Shift updateShift(Long id, Shift shift) {
        Shift existing = dao.findById(id);
        if (existing != null) {
            existing.setName(shift.getName());
            existing.setStartTime(shift.getStartTime());
            existing.setEndTime(shift.getEndTime());
            existing.setGraceTime(shift.getGraceTime());
            return dao.save(existing);
        }
        return null;
    }

    @Override
    public void deleteShift(Long id) {
        dao.delete(id);
    }
}
