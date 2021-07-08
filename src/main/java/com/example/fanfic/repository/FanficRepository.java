package com.example.fanfic.repository;

import com.example.fanfic.model.Fanfic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FanficRepository extends JpaRepository<Fanfic, Long> {
    List<Fanfic> findAll();
}
