package com.example.fanfic.repository;

import com.example.fanfic.model.Fanfic;
import com.example.fanfic.model.Likes;
import com.example.fanfic.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LikeRepository extends JpaRepository<Likes, Long> {
    Likes findByFanficAndUser(Fanfic fanfic, User user);

    List<Likes> findByFanfic(Fanfic fanfic);
}
