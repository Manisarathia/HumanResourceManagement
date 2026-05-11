package com.example.HumanResourceManagement.service;

import com.example.HumanResourceManagement.dao.UserDAO;
import com.example.HumanResourceManagement.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO dao;

    // ✅ CREATE
    @Override
    public User createUser(User user) {
        return dao.save(user);
    }

    // 🔥 UPDATE using entity method
    @Override
    public User updateUser(Long id, User updatedUser) {

        User existing = dao.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // 🔥 Clean update
        existing.updateFrom(updatedUser);

        return dao.save(existing);
    }

    // ✅ READ
    @Override
    public List<User> getAllUsers() {
        return dao.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return dao.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    // ✅ DELETE
    @Override
    public void deleteUser(Long id) {
        dao.delete(id);
    }
}