package com.example.HumanResourceManagement.service;

import com.example.HumanResourceManagement.model.Payroll;
import java.util.List;

public interface PayrollService {

    Payroll createPayroll(Payroll payroll);

    Payroll updatePayroll(Long id, Payroll payroll);

    List<Payroll> getAllPayrolls();

    Payroll getPayrollById(Long id);

    void deletePayroll(Long id);

    List<Payroll> getPayrollByEmpId(Integer empId);
}