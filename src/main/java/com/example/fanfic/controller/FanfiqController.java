package com.example.fanfic.controller;


import com.example.fanfic.model.Fandom;
import com.example.fanfic.model.User;
import com.example.fanfic.model.Fanfic;
import com.example.fanfic.service.impl.FanficServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("fanfic")
public class FanfiqController {
    private final FanficServiceImpl fanficService;

    @Autowired
    public FanfiqController(FanficServiceImpl fanficService) {
        this.fanficService = fanficService;
    }

    @GetMapping()
    public ResponseEntity<List<Fanfic>> findAllFunfic() {
        List<Fanfic> fanfics = fanficService.getAllFanfics();
        return new ResponseEntity<>(fanfics, HttpStatus.OK);
    }

    @GetMapping("id/{id}")
    public ResponseEntity<Fanfic> getFanfic(@PathVariable("id") Long id) {
        Fanfic fanfic = fanficService.findById(id);
        return new ResponseEntity<>(fanfic, HttpStatus.OK);
    }

    @PostMapping("add")
    public ResponseEntity<Fanfic> createFanfic(@RequestBody Fanfic fanfic) {
        Fanfic newFanfic = fanficService.addFanfic(fanfic);
        return new ResponseEntity<>(newFanfic, HttpStatus.CREATED);
    }

    @PostMapping("my_fanfics")
    public ResponseEntity<List<Fanfic>> searchFanficByUser(@RequestBody User user) {
        List<Fanfic> fanficsListByUser = fanficService.findByUser(user);
        return new ResponseEntity<>(fanficsListByUser, HttpStatus.CREATED);
    }

    @PostMapping("search/fandom")
    public ResponseEntity<List<Fanfic>> searchFanficByFandom(@RequestBody Fandom fandom) {
        List<Fanfic> fanfics = fanficService.findByFandom(fandom);
        return new ResponseEntity<>(fanfics, HttpStatus.OK);
    }

    @DeleteMapping("delete/{fanfic_id}")
    public void deleteFanfic(@PathVariable("fanfic_id") Long fanfic_id) {
        Fanfic fanfic = fanficService.findById(fanfic_id);
        fanficService.deleteFanfic(fanfic);
    }
}






