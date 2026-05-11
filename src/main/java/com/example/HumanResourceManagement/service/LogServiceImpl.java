package com.example.HumanResourceManagement.service;

import com.example.HumanResourceManagement.dao.LogDAO;
import com.example.HumanResourceManagement.model.Log;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogServiceImpl implements LogService {

    @Autowired
    private LogDAO dao;

    // CREATE
    @Override
    public Log createLog(Log log) {
        return dao.save(log);
    }

    // UPDATE
    @Override
    public Log updateLog(Long id, Log updatedLog) {

        Log existing = dao.findById(id)
                .orElseThrow(() -> new RuntimeException("Log not found"));

        existing.setEmpId(updatedLog.getEmpId());
        existing.setLogTime(updatedLog.getLogTime());
        existing.setType(updatedLog.getType());

        return dao.save(existing);
    }

    // READ ALL
    @Override
    public List<Log> getAllLogs() {
        return dao.findAll();
    }

    // READ BY ID
    @Override
    public Log getLogById(Long id) {
        return dao.findById(id)
                .orElseThrow(() -> new RuntimeException("Log not found"));
    }

    // DELETE
    @Override
    public void deleteLog(Long id) {
        dao.delete(id);
    }

    // BY EMP ID
    @Override
    public List<Log> getLogsByEmpId(Integer empId) {
        return dao.findByEmpId(empId);
    }
}