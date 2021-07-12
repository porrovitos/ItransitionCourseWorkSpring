package com.example.fanfic.controller;


import com.example.fanfic.model.Comment;
import com.example.fanfic.model.Fanfic;
import com.example.fanfic.model.User;
import com.example.fanfic.service.impl.CommentServiceImpl;
import com.example.fanfic.service.impl.FanficServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("comment")
public class CommentController {

    private final FanficServiceImpl fanficService;
    private final CommentServiceImpl commentService;

    @Autowired
    public CommentController(FanficServiceImpl fanficService, CommentServiceImpl commentService) {
        this.fanficService = fanficService;
        this.commentService = commentService;
    }

    @GetMapping("fanfic/{id}")
    public ResponseEntity<List<Comment>> getFanfic(@PathVariable("id") Long id) {
        Fanfic fanfic = fanficService.findById(id);
        List<Comment> comments = commentService.findByFanfic(fanfic);
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }

    @PostMapping("add")
    public ResponseEntity<Comment> createFanfic(@RequestBody Comment comment) {
        Comment newComment = commentService.addComment(comment);
        return new ResponseEntity<>(newComment, HttpStatus.CREATED);
    }

    @PostMapping("my_comment")
    public ResponseEntity<List<Fanfic>> searchFanficByUser(@RequestBody User user) {
        List<Fanfic> fanficsListByUser = fanficService.findByUser(user);
        return new ResponseEntity<>(fanficsListByUser, HttpStatus.CREATED);
    }
}






