package com.example.fanfic.service;


import com.example.fanfic.model.Fanfic;

import java.util.List;

public interface FanficService {


    List<Fanfic> getAllFanfics();

    Fanfic findByUsername(String username);

    Fanfic findById(Long id);

    Fanfic addFanfic(Fanfic fanfic);

}