package com.example.SocialMedia.controller;

import com.example.SocialMedia.model.User;
import com.example.SocialMedia.repository.UserRepository;
import com.example.SocialMedia.request.UserRequest;
import com.example.SocialMedia.response.UserResponse;
import com.example.SocialMedia.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")

public class UserController {
@Autowired
private UserService userService;

    @PostMapping("/")
    public void createUser(@RequestBody UserRequest userRequest){
        userService.createUser(userRequest);
    }

    @GetMapping("/{userId}")
    public UserResponse findById(@PathVariable Long userId){
    return userService.getUser(userId);
    }

    @GetMapping("/")
    public List<UserResponse> findAll(){
    return userService.getAllUser();
    }

    @PutMapping("/updateById/{userId}")
    public UserResponse updateById(@PathVariable  Long userId, @RequestBody UserRequest userRequest){
    return userService.updateUserByUserId(userId,userRequest);
    }
}
