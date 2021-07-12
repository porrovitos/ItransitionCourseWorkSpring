package com.example.fanfic.service.impl;

import com.example.fanfic.model.*;
import com.example.fanfic.repository.CommentRepository;
import com.example.fanfic.repository.FanficRepository;
import com.example.fanfic.repository.FavoriteRepository;
import com.example.fanfic.repository.LikeRepository;
import com.example.fanfic.service.FanficService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
public class FanficServiceImpl implements FanficService {
    private final FanficRepository fanficRepository;
    private final LikeRepository likeRepository;
    private final CommentRepository commentRepository;
    private final FavoriteRepository favoriteRepository;
    @Autowired
    public FanficServiceImpl(FanficRepository fanficRepository, LikeRepository likeRepository, CommentRepository commentRepository, FavoriteRepository favoriteRepository) {
        this.fanficRepository = fanficRepository;
        this.likeRepository = likeRepository;
        this.commentRepository = commentRepository;
        this.favoriteRepository = favoriteRepository;
    }


    @Override
    public List<Fanfic> getAllFanfics() {
        return fanficRepository.findAll();
    }

    @Override
    public List<Fanfic> findByUser(User user) {
        return fanficRepository.findByUser(user);
    }

    @Override
    public Fanfic addFanfic(Fanfic fanfic){
        fanfic.setCreation_date(LocalDateTime.now());
        return fanficRepository.save(fanfic);
    }
    @Override
    public Fanfic findById(Long id) {
        return fanficRepository.findById(id).orElse(null);
    }

    @Override
    public  List<Fanfic> findByFandom(Fandom fandom){
        return fanficRepository.findByFandom(fandom);
    }

    @Override
    public void deleteFanfic(Fanfic fanfic){
        List<Favorite> favoritesForDelete = favoriteRepository.findByFanfic(fanfic);
        favoriteRepository.deleteAll(favoritesForDelete);
        List<Likes> likesForDelete = likeRepository.findByFanfic(fanfic);
        likeRepository.deleteAll(likesForDelete);
        List<Comment> commentsForDelete = commentRepository.findByFanfic(fanfic);
        commentRepository.deleteAll(commentsForDelete);
        fanficRepository.delete(fanfic);
    }


}
