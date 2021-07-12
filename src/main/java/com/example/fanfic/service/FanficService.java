package com.example.fanfic.service;


import com.example.fanfic.model.Fandom;
import com.example.fanfic.model.Fanfic;
import com.example.fanfic.model.User;

import java.util.List;

public interface FanficService {


    List<Fanfic> getAllFanfics();

    List<Fanfic> findByUser(User user);

    Fanfic findById(Long id);

    Fanfic addFanfic(Fanfic fanfic);

    List<Fanfic> findByFandom(Fandom fandom);

    void deleteFanfic(Fanfic fanfic);
}