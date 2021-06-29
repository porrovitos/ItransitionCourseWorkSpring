package com.example.fanfic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.fanfic.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
