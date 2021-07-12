package com.example.fanfic.repository;

import com.example.fanfic.model.Comment;
import com.example.fanfic.model.Fanfic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByFanfic(Fanfic fanfic);
    void deleteByFanfic(Fanfic fanfic);
}
