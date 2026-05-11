package com.example.HumanResourceManagement.service;

import com.example.HumanResourceManagement.model.Log;

import java.util.List;

public interface LogService {

    Log createLog(Log log);

    Log updateLog(Long id, Log log);

    List<Log> getAllLogs();

    Log getLogById(Long id);

    void deleteLog(Long id);

    List<Log> getLogsByEmpId(Integer empId);
}