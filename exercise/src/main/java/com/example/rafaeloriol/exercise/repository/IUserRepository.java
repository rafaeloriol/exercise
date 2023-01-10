package com.example.rafaeloriol.exercise.repository;

import com.example.rafaeloriol.exercise.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {

}
