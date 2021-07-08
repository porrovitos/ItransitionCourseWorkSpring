package com.example.fanfic.service.impl;

import com.example.fanfic.model.Fandom;
import com.example.fanfic.model.Fanfic;
import com.example.fanfic.repository.FandomRepository;
import com.example.fanfic.service.FandomService;
import com.example.fanfic.service.FanficService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
public class FandomServiceImpl implements FandomService {
    private final FandomRepository fandomRepository;

    public FandomServiceImpl(FandomRepository fandomRepository) {
        this.fandomRepository = fandomRepository;
    }


    @Override
    public List<Fandom> getAllFandom() {
        return fandomRepository.findAll();
    }
}
