package com.example.fanfic.service.impl;

import com.example.fanfic.model.Fanfic;
import com.example.fanfic.repository.FanficRepository;
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

    @Autowired
    public FanficServiceImpl(FanficRepository fanficRepository) {
        this.fanficRepository = fanficRepository;
    }


    @Override
    public List<Fanfic> getAllFanfics() {
        return fanficRepository.findAll();
    }

    @Override
    public Fanfic findByUsername(String username) {
//        Fanfic result = fanficRepository.findByUsername(username);
        return null;
    }

    @Override
    public Fanfic addFanfic(Fanfic fanfic){
        fanfic.setCreation_date(LocalDateTime.now());
        return fanficRepository.save(fanfic);
    }
    @Override
    public Fanfic findById(Long id) {
        Fanfic result = fanficRepository.findById(id).orElse(null);
        if (result == null) {
            return null;
        }
        return result;
    }
}
