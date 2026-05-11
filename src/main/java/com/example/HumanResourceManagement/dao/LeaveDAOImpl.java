package com.example.HumanResourceManagement.dao;

import com.example.HumanResourceManagement.dao.LeaveDAO;
import com.example.HumanResourceManagement.model.Leave;
import com.example.HumanResourceManagement.model.LeaveStatus;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class LeaveDAOImpl implements LeaveDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Leave save(Leave leave) {
        if (leave.getId() == null) {
            entityManager.persist(leave);
            return leave;
        } else {
            return entityManager.merge(leave);
        }
    }

    @Override
    public Optional<Leave> findById(Long id) {
        Leave leave = entityManager.find(Leave.class, id);
        return Optional.ofNullable(leave);
    }

    @Override
    public List<Leave> findAll() {
        return entityManager
                .createQuery("FROM Leave", Leave.class)
                .getResultList();
    }

    @Override
    public void deleteById(Long id) {
        Leave leave = entityManager.find(Leave.class, id);
        if (leave != null) {
            entityManager.remove(leave);
        }
    }

    @Override
    public List<Leave> findByEmpId(Long empId) {
        return entityManager
                .createQuery("FROM Leave l WHERE l.empId = :empId", Leave.class)
                .setParameter("empId", empId)
                .getResultList();
    }

    @Override
    public List<Leave> findByStatus(LeaveStatus status) {
        return entityManager
                .createQuery("FROM Leave l WHERE l.status = :status", Leave.class)
                .setParameter("status", status)
                .getResultList();
    }

    @Override
    public List<Leave> findByEmpIdAndStatus(Long empId, LeaveStatus status) {
        return entityManager
                .createQuery("FROM Leave l WHERE l.empId = :empId AND l.status = :status", Leave.class)
                .setParameter("empId", empId)
                .setParameter("status", status)
                .getResultList();
    }

    @Override
    public List<Leave> findByStartDateBetween(LocalDate start, LocalDate end) {
        return entityManager
                .createQuery("FROM Leave l WHERE l.startDate BETWEEN :start AND :end", Leave.class)
                .setParameter("start", start)
                .setParameter("end", end)
                .getResultList();
    }
}