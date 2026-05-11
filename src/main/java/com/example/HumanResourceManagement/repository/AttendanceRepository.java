package com.example.HumanResourceManagement.repository;

import com.example.HumanResourceManagement.model.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {

    Optional<Attendance> findByEmpIdAndAttendanceDate(Integer empId, LocalDate attendanceDate);
}