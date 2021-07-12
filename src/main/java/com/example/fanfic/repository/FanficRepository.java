package com.example.fanfic.repository;

import com.example.fanfic.model.Fandom;
import com.example.fanfic.model.Fanfic;
import com.example.fanfic.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FanficRepository extends JpaRepository<Fanfic, Long> {
    List<Fanfic> findAll();
    List<Fanfic> findByFandom(Fandom fandom);
    List<Fanfic> findByUser(User user);
}
