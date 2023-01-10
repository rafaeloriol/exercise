package com.example.rafaeloriol.exercise.service.impl;

import com.example.rafaeloriol.exercise.model.User;
import com.example.rafaeloriol.exercise.repository.IUserRepository;
import com.example.rafaeloriol.exercise.service.IUserService;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {

    private IUserRepository userRepository;

    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findById(Long id) {
        if (id == null) {
            return Optional.empty();
        }
        return userRepository.findById(id);
    }

    @Override
    public User createUser(User user) {
        if (ObjectUtils.isEmpty(user)){
            return null;
        }
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        if (ObjectUtils.isEmpty(user)){
            return null;
        }
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        if(id !=null && userRepository.existsById(id))
            userRepository.deleteById(id);
    }

    @Override
    public void deleteUsers() {
        userRepository.deleteAll();
    }
}
