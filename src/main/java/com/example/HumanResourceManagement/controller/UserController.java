package com.example.HumanResourceManagement.controller;

import com.example.HumanResourceManagement.model.User;
import com.example.HumanResourceManagement.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService service;

    // ✅ CREATE
    @PostMapping
    public User create(@RequestBody User user) {
        return service.createUser(user);
    }

    // 🔥 UPDATE
    @PutMapping("/{id}")
    public User update(@PathVariable Long id, @RequestBody User user) {
        return service.updateUser(id, user);
    }

    // ✅ GET ALL
    @GetMapping
    public List<User> getAll() {
        return service.getAllUsers();
    }

    // ✅ GET BY ID
    @GetMapping("/{id}")
    public User getById(@PathVariable Long id) {
        return service.getUserById(id);
    }

    // ✅ DELETE
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.deleteUser(id);
        return "User deleted successfully";
    }
}