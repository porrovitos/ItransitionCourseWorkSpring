package com.example.fanfic.controller;

import com.example.fanfic.dto.RegistrationRequestDto;
import com.example.fanfic.model.User;
import com.example.fanfic.repository.UserRepository;
import com.example.fanfic.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/registration")
public class RegisterController {
    private final UserService userService;
    private final UserRepository userRepository;

    public RegisterController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @PostMapping()
    public ResponseEntity register(@RequestBody RegistrationRequestDto requestDto) {
        String username = requestDto.getUsername();
        User user = userRepository.findByUsername(username);
        if (user != null) {
            throw new BadCredentialsException("User with this nickname was extended");
        } else {
            User new_user = (User) userService.register(requestDto.getEmail(), requestDto.getUsername(), requestDto.getPassword());
            userRepository.save(new_user);
            Map<Object, Object> response = new HashMap<>();
            response.put("user", new_user);
            return ResponseEntity.ok(response);
        }
    }
}
