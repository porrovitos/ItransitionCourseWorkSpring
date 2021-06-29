package com.example.fanfic.controller;


import com.example.fanfic.repository.FanficRepository;
import com.example.fanfic.model.Fanfic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("fanfic")
public class FanfiqController {
    private final FanficRepository fanficRepository;

    @Autowired
    public FanfiqController(FanficRepository fanficRepository) {
        this.fanficRepository = fanficRepository;
    }

    @GetMapping("{id}")
    public Fanfic getFanfic(@PathVariable("id")Fanfic  fanfic){
        return fanfic;
    }

    @PostMapping("{create}")
    public Fanfic createFanfic(@RequestBody Fanfic  fanfic){
        fanfic.setCreation_date(LocalDateTime.now());
        return fanficRepository.save(fanfic);
    }



}

