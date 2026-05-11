package com.example.HumanResourceManagement.service;

import com.example.HumanResourceManagement.model.User;

import java.util.List;

public interface UserService {

    User createUser(User user);

    User updateUser(Long id, User user);

    List<User> getAllUsers();

    User getUserById(Long id);

    void deleteUser(Long id);
}