package com.example.HumanResourceManagement.service;

import com.example.HumanResourceManagement.dao.AttendanceDAO;
import com.example.HumanResourceManagement.model.Attendance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Duration;
import java.util.List;

@Service
public class AttendanceServiceImpl implements AttendanceService {

    @Autowired
    private AttendanceDAO dao;

    @Override
    public Attendance create(Attendance attendance) {

        // Calculate work hours
        if (attendance.getCheckIn() != null && attendance.getCheckOut() != null) {
            long minutes = Duration.between(
                    attendance.getCheckIn(),
                    attendance.getCheckOut()
            ).toMinutes();

            BigDecimal hours = BigDecimal.valueOf(minutes)
                    .divide(BigDecimal.valueOf(60), 2, RoundingMode.HALF_UP);

            attendance.setWorkHours(hours);
        }

        return dao.save(attendance);
    }

    @Override
    public List<Attendance> getAll() {
        return dao.findAll();
    }

    @Override
    public Attendance getById(Long id) {
        return dao.findById(id);
    }

    @Override
    public Attendance getByEmpAndDate(Integer empId, java.time.LocalDate date) {
        return dao.findByEmpAndDate(empId, date);
    }

    @Override
    public Attendance update(Long id, Attendance attendance) {

        Attendance existing = dao.findById(id);

        if (existing != null) {

            existing.setEmpId(attendance.getEmpId());
            existing.setAttendanceDate(attendance.getAttendanceDate());
            existing.setCheckIn(attendance.getCheckIn());
            existing.setCheckOut(attendance.getCheckOut());
            existing.setStatus(attendance.getStatus());

            // Recalculate hours
            if (attendance.getCheckIn() != null && attendance.getCheckOut() != null) {
                long minutes = Duration.between(
                        attendance.getCheckIn(),
                        attendance.getCheckOut()
                ).toMinutes();

                BigDecimal hours = BigDecimal.valueOf(minutes)
                        .divide(BigDecimal.valueOf(60), 2, RoundingMode.HALF_UP);

                existing.setWorkHours(hours);
            }

            return dao.save(existing);
        }

        return null;
    }

    @Override
    public void delete(Long id) {
        dao.delete(id);
    }
}