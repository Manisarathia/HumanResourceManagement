package com.example.HumanResourceManagement.dao;

import com.example.HumanResourceManagement.model.User;

import java.util.List;
import java.util.Optional;

public interface UserDAO {

    User save(User user);

    List<User> findAll();

    Optional<User> findById(Long id);

    void delete(Long id);

    Optional<User> findByUsername(String username);
}