package com.example.fanfic.service;


import com.example.fanfic.model.Fanfic;
import com.example.fanfic.model.Favorite;
import com.example.fanfic.model.User;

import java.util.List;

public interface FavoriteService {

    Favorite findByFanficAndUser(Fanfic fanfic, User user);
    Favorite addFavorite(Favorite favorite);
    List<Favorite> findByUser(User user);
}