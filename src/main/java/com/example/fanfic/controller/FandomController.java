package com.example.fanfic.controller;

import com.example.fanfic.model.Fandom;
import com.example.fanfic.model.Fanfic;
import com.example.fanfic.repository.FandomRepository;
import com.example.fanfic.service.impl.FandomServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("fandom")
public class FandomController {
    private final FandomRepository fandomRepository;
    private final FandomServiceImpl fandomService;

    public FandomController(FandomRepository fandomRepository, FandomServiceImpl fanficService) {
        this.fandomRepository = fandomRepository;
        this.fandomService = fanficService;
    }

    @GetMapping()
    public ResponseEntity<List<Fandom>> findAllFandom() {
        List<Fandom> fandoms = fandomService.getAllFandom();
        return new ResponseEntity<>(fandoms, HttpStatus.OK);
    }
}
