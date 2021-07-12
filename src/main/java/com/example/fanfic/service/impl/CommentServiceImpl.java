package com.example.fanfic.service.impl;

import com.example.fanfic.model.Comment;
import com.example.fanfic.model.Fanfic;
import com.example.fanfic.repository.CommentRepository;
import com.example.fanfic.repository.FanficRepository;
import com.example.fanfic.service.CommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;
    private final FanficServiceImpl fanficService;

    public CommentServiceImpl(CommentRepository commentRepository, FanficRepository fanficRepository, FanficServiceImpl fanficService) {
        this.commentRepository = commentRepository;
        this.fanficService = fanficService;
    }

    @Override
    public  List<Comment> findByFanfic(Fanfic fanfic){
        return commentRepository.findByFanfic(fanfic);
    }

    @Override
    public Comment addComment(Comment comment){
        comment.setCreation_date(LocalDateTime.now());
        return commentRepository.save(comment);
    }
}
