package com.example.fanfic.service.impl;

import com.example.fanfic.model.Comment;
import com.example.fanfic.model.Fanfic;
import com.example.fanfic.model.Favorite;
import com.example.fanfic.model.User;
import com.example.fanfic.repository.FavoriteRepository;
import com.example.fanfic.service.FavoriteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
public class FavoriteServiceImpl implements FavoriteService {
    private final FavoriteRepository favoriteRepository;
    private final FanficServiceImpl fanficService;

    public FavoriteServiceImpl(FavoriteRepository avoriteRepository, FanficServiceImpl fanficService) {
        this.favoriteRepository = avoriteRepository;
        this.fanficService = fanficService;
    }


    @Override
    public Favorite findByFanficAndUser(Fanfic fanfic, User user) {
        return favoriteRepository.findByFanficAndUser(fanfic, user);
    }

    @Override
    public Favorite addFavorite(Favorite favorite) {
        return favoriteRepository.save(favorite);
    }


    @Override
    public List<Favorite> findByUser(User user) {
        return favoriteRepository.findByUser(user);
    }


}
