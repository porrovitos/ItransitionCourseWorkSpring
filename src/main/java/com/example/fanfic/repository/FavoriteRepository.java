package com.example.fanfic.repository;

import com.example.fanfic.model.Comment;
import com.example.fanfic.model.Fanfic;
import com.example.fanfic.model.Favorite;
import com.example.fanfic.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FavoriteRepository extends JpaRepository<Favorite, Long> {
    Favorite findByFanficAndUser(Fanfic fanfic, User user);
    List<Favorite> findByFanfic(Fanfic fanfic);
    List<Favorite> findByUser(User user);
}
