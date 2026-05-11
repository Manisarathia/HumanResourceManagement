package com.example.HumanResourceManagement.service;

import com.example.HumanResourceManagement.dao.SalaryStructureDAO;
import com.example.HumanResourceManagement.model.SalaryStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class SalaryStructureServiceImpl implements SalaryStructureService {

    @Autowired
    private SalaryStructureDAO dao;

    @Override
    public SalaryStructure create(SalaryStructure salary) {

        calculateNetSalary(salary);
        return dao.save(salary);
    }

    @Override
    public List<SalaryStructure> getAll() {
        return dao.findAll();
    }

    @Override
    public SalaryStructure getById(Long id) {
        return dao.findById(id);
    }

    @Override
    public List<SalaryStructure> getByEmpId(Integer empId) {
        return dao.findByEmpId(empId);
    }

    @Override
    public SalaryStructure update(Long id, SalaryStructure salary) {

        SalaryStructure existing = dao.findById(id);

        if (existing != null) {
            existing.setEmpId(salary.getEmpId());
            existing.setBasic(salary.getBasic());
            existing.setHra(salary.getHra());
            existing.setAllowances(salary.getAllowances());
            existing.setDeductions(salary.getDeductions());
            existing.setEffectiveFrom(salary.getEffectiveFrom());

            calculateNetSalary(existing);

            return dao.save(existing);
        }

        return null;
    }

    @Override
    public void delete(Long id) {
        dao.delete(id);
    }

    // 🔥 Business Logic
    private void calculateNetSalary(SalaryStructure salary) {

        BigDecimal basic = safe(salary.getBasic());
        BigDecimal hra = safe(salary.getHra());
        BigDecimal allowances = safe(salary.getAllowances());
        BigDecimal deductions = safe(salary.getDeductions());

        BigDecimal net = basic.add(hra)
                .add(allowances)
                .subtract(deductions);

        salary.setNetSalary(net);
    }

    private BigDecimal safe(BigDecimal value) {
        return value != null ? value : BigDecimal.ZERO;
    }
}