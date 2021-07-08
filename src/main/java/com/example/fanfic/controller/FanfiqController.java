package com.example.fanfic.controller;


import com.example.fanfic.repository.FanficRepository;
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
    private final FanficRepository fanficRepository;
    private final FanficServiceImpl fanficService;

    @Autowired
    public FanfiqController(FanficRepository fanficRepository, FanficServiceImpl fanficService) {
        this.fanficRepository = fanficRepository;
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

    @PostMapping("{create}")
    public ResponseEntity<Fanfic> createFanfic(@RequestBody Fanfic fanfic) {
        Fanfic newFanfic = fanficService.addFanfic(fanfic);
        return new ResponseEntity<>(newFanfic, HttpStatus.CREATED);
    }
}






