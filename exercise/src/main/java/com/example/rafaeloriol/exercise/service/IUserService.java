package com.example.rafaeloriol.exercise.service;

import com.example.rafaeloriol.exercise.model.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {

    List<User> findAll();

    Optional<User> findById(Long id);

    User createUser (User user);

    User updateUser (User user);

    void deleteUser (Long id);

    void deleteUsers();
}
