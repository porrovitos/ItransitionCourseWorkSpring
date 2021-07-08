package com.example.fanfic.repository;

import com.example.fanfic.model.Fandom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FandomRepository extends JpaRepository<Fandom, Long> {
    List<Fandom> findAll();
}
