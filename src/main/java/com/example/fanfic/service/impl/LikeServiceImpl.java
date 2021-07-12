package com.example.fanfic.service.impl;

import com.example.fanfic.model.Fanfic;
import com.example.fanfic.model.Likes;
import com.example.fanfic.model.User;
import com.example.fanfic.repository.FanficRepository;
import com.example.fanfic.repository.LikeRepository;
import com.example.fanfic.service.LikeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class LikeServiceImpl implements LikeService {
    private final LikeRepository likeRepository;
    private final FanficRepository fanficRepository;
    private final UserServiceImpl userService;
    private final FanficServiceImpl fanficService;

    public LikeServiceImpl(LikeRepository likeRepository, FanficRepository fanficRepository, UserServiceImpl userService, FanficServiceImpl fanficService) {
        this.likeRepository = likeRepository;
        this.fanficRepository = fanficRepository;
        this.userService = userService;
        this.fanficService = fanficService;
    }


    @Override
    public Likes findLikeByFanficAndUser(Fanfic fanfic, User user){
        return likeRepository.findByFanficAndUser(fanfic, user);
    }

    @Override
    public Likes addLike(Likes like){
        Fanfic changeCountOfLikes = fanficRepository.getById(like.getFanfic().getId());
        changeCountOfLikes.setCount_likes(changeCountOfLikes.getCount_likes() + 1);
        fanficRepository.save(changeCountOfLikes);
        return likeRepository.save(like);
    }


    @Override
    public Optional<Likes> findById(Long id){
        return likeRepository.findById(id);
    }

    @Override
    public void removeLike(Long fanficId, Long UserId){
        Fanfic fanfic = fanficService.findById(fanficId);
        User user = userService.findById(UserId);
        Likes for_delete = findLikeByFanficAndUser(fanfic,user);
        Fanfic changeCountOfLikes = fanficRepository.getById(fanficId);
        changeCountOfLikes.setCount_likes(changeCountOfLikes.getCount_likes() - 1);
        fanficRepository.save(changeCountOfLikes);
        likeRepository.delete(for_delete);
    }
}
