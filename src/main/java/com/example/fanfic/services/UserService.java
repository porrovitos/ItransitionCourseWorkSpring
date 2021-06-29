package com.example.fanfic.services;


import com.example.fanfic.model.User;

import java.util.List;

public interface UserService {


    List<User> getAll();

    User findByUsername(String username);

    User findById(Long id);

    void delete(Long id);

    Object register(String email, String username, String password);
}