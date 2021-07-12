package com.example.fanfic.controller;


import com.example.fanfic.model.Fanfic;
import com.example.fanfic.model.Favorite;
import com.example.fanfic.model.User;
import com.example.fanfic.repository.FavoriteRepository;
import com.example.fanfic.service.UserService;
import com.example.fanfic.service.impl.FanficServiceImpl;
import com.example.fanfic.service.impl.FavoriteServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("favorite")
public class FavoriteController {

    private final FanficServiceImpl fanficService;
    private final FavoriteServiceImpl favoriteService;
    private final UserService userService;
    private final FavoriteRepository favoriteRepository;

    public FavoriteController(FanficServiceImpl fanficService, FavoriteServiceImpl favoriteService, UserService userService, FavoriteRepository favoriteRepository) {
        this.fanficService = fanficService;
        this.favoriteService = favoriteService;
        this.userService = userService;
        this.favoriteRepository = favoriteRepository;
    }


    @PostMapping("fanfic/{fanfic_id}")
    public ResponseEntity<Favorite> getFavoriteByFanficAndUser(@PathVariable("fanfic_id") Long fanfic_id, @RequestBody User user) {
        Fanfic fanfic = fanficService.findById(fanfic_id);
        Favorite inFavorite= favoriteService.findByFanficAndUser(fanfic, user);
        return new ResponseEntity<>(inFavorite, HttpStatus.OK);
    }

    @PostMapping("add")
    public ResponseEntity<Favorite> createFavorite(@RequestBody Favorite favorite) {
        Favorite newFavorite = favoriteService.addFavorite(favorite);
        return new ResponseEntity<>(newFavorite, HttpStatus.CREATED);
    }

    @PostMapping("my_favorite_fanfics")
    public ResponseEntity<List<Favorite>> searchFavoriteByUser(@RequestBody User user) {
        List<Favorite> favoriteListByUser = favoriteService.findByUser(user);
        return new ResponseEntity<>(favoriteListByUser, HttpStatus.OK);
    }



    @DeleteMapping("fanfic/{fanfic_id}/delete/{user_id}")
    public void deleteFavorite(@PathVariable("fanfic_id") Long fanfic_id,@PathVariable("user_id") Long user_id) {
        Fanfic fanfic = fanficService.findById(fanfic_id);
        User user = userService.findById(user_id);
        Favorite for_delete = favoriteRepository.findByFanficAndUser(fanfic,user);
        favoriteRepository.delete(for_delete);
    }
}






