package com.example.fanfic.controller;


import com.example.fanfic.model.Fanfic;
import com.example.fanfic.model.Likes;
import com.example.fanfic.model.User;
import com.example.fanfic.repository.FanficRepository;
import com.example.fanfic.repository.LikeRepository;
import com.example.fanfic.service.UserService;
import com.example.fanfic.service.impl.FanficServiceImpl;
import com.example.fanfic.service.impl.LikeServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("like")
public class LikeController {

    private final FanficServiceImpl fanficService;
    private final LikeServiceImpl likeService;
    private final UserService userService;
    private final LikeRepository likeRepository;
    private final FanficRepository fanficRepository;

    public LikeController(FanficServiceImpl fanficService, LikeServiceImpl likeService, UserService userService, LikeRepository likeRepository, FanficRepository fanficRepository) {
        this.fanficService = fanficService;
        this.likeService = likeService;
        this.userService = userService;
        this.likeRepository = likeRepository;
        this.fanficRepository = fanficRepository;
    }


    @PostMapping("fanfic/{fanfic_id}")
    public ResponseEntity<Likes> getLikeByFanficAndUser(@PathVariable("fanfic_id") Long fanfic_id, @RequestBody User user) {
        Fanfic fanfic = fanficService.findById(fanfic_id);
        Likes inFavorite= likeService.findLikeByFanficAndUser(fanfic, user);
        return new ResponseEntity<>(inFavorite, HttpStatus.OK);
    }

    @PostMapping("add")
    public ResponseEntity<Likes> addLike(@RequestBody Likes like) {
        Likes newLike = likeService.addLike(like);
        return new ResponseEntity<>(newLike, HttpStatus.CREATED);
    }

    @DeleteMapping("fanfic/{fanfic_id}/delete/{user_id}")
    public void deleteLike(@PathVariable("fanfic_id") Long fanfic_id,@PathVariable("user_id") Long user_id) {
        likeService.removeLike(fanfic_id,user_id);
    }
}






