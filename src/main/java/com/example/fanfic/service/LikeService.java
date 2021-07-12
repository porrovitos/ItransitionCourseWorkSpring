package com.example.fanfic.service;


import com.example.fanfic.model.Fanfic;
import com.example.fanfic.model.Likes;
import com.example.fanfic.model.User;

import java.util.Optional;


public interface LikeService {

    Likes findLikeByFanficAndUser(Fanfic fanfic, User user);

    Likes addLike(Likes like);

    Optional<Likes> findById(Long id);

    void removeLike(Long fanficId, Long UserId);
}