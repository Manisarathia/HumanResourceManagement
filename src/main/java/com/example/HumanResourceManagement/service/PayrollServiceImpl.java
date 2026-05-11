package com.example.HumanResourceManagement.service;

import com.example.HumanResourceManagement.dao.PayrollDAO;
import com.example.HumanResourceManagement.model.Payroll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Service
public class PayrollServiceImpl implements PayrollService {

    @Autowired
    private PayrollDAO dao;

    @Override
    public Payroll createPayroll(Payroll payroll) {
        calculateSalary(payroll);
        return dao.save(payroll);
    }

    @Override
    public Payroll updatePayroll(Long id, Payroll updatedPayroll) {

        Payroll existing = dao.findById(id)
                .orElseThrow(() -> new RuntimeException("Payroll not found"));

        existing.setEmpId(updatedPayroll.getEmpId());
        existing.setMonth(updatedPayroll.getMonth());
        existing.setYear(updatedPayroll.getYear());
        existing.setTotalDays(updatedPayroll.getTotalDays());
        existing.setPresentDays(updatedPayroll.getPresentDays());
        existing.setLeaveDays(updatedPayroll.getLeaveDays());
        existing.setLopDays(updatedPayroll.getLopDays());
        existing.setGrossSalary(updatedPayroll.getGrossSalary());

        calculateSalary(existing);

        return dao.save(existing);
    }

    @Override
    public List<Payroll> getAllPayrolls() {
        return dao.findAll();
    }

    @Override
    public Payroll getPayrollById(Long id) {
        return dao.findById(id)
                .orElseThrow(() -> new RuntimeException("Payroll not found"));
    }

    @Override
    public void deletePayroll(Long id) {
        dao.delete(id);
    }

    @Override
    public List<Payroll> getPayrollByEmpId(Integer empId) {
        return dao.findByEmpId(empId);
    }

    // 🔥 Business Logic
    private void calculateSalary(Payroll payroll) {

        if (payroll.getTotalDays() != null && payroll.getTotalDays() > 0
                && payroll.getGrossSalary() != null) {

            int workingDays = payroll.getPresentDays() + payroll.getLeaveDays();

            BigDecimal perDaySalary = payroll.getGrossSalary()
                    .divide(BigDecimal.valueOf(payroll.getTotalDays()), 2, RoundingMode.HALF_UP);

            BigDecimal netSalary = perDaySalary.multiply(BigDecimal.valueOf(workingDays));

            payroll.setNetSalary(netSalary);
        }
    }
}