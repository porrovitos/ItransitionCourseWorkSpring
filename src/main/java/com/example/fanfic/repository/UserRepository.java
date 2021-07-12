package com.example.fanfic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.fanfic.model.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

    List<User> findAll();
}
