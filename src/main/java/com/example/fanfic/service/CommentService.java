package com.example.fanfic.service;


import com.example.fanfic.model.Comment;
import com.example.fanfic.model.Fanfic;

import java.util.List;

public interface CommentService {

    List<Comment> findByFanfic(Fanfic fanfic);
    Comment addComment(Comment comment);
}